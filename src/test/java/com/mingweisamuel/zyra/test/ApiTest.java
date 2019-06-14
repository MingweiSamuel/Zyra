package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.RiotApiConfig;
import org.junit.Rule;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.ExecutionException;

public abstract class ApiTest {

    protected static final String SUMMONER_ID_LUGNUTSK = "SBM8Ubipo4ge2yj7bhEzL7yvV0C9Oc1XA2l6v5okGMA_nCw";
    protected static final String SUMMONER_ID_MA5STERY = "IbC4uyFEEW3ZkZw6FZF4bViw3P1EynclAcI6-p-vCpI99Ec";
    protected static final String SUMMONER_ID_C9SNEAKY = "ghHSdADqgxKwcRl_vWndx6wKiyZx0xKQv-LOhOcU5LU";

    protected static final String ACCOUNT_ID_C9SNEAKY = "ML_CcLT94UUHp1iDvXOXCidfmzzPrk_Jbub1f_INhw";

    @Rule
    public TestRule globalTimeout = new DisableOnDebug(Timeout.seconds(60));

    protected static final RiotApi api = RiotApi.newInstance(RiotApiConfig.builder(
        System.getenv("API_KEY"))
            .setMaxConcurrentRequests(Integer.parseInt(System.getProperty("testThreadCount")))
            .setRetries(10).build());

    @Rule
    public final AsyncUnwrapper unwrapper = new AsyncUnwrapper();

    /** Unwraps ExecutionExceptions. */
    private class AsyncUnwrapper implements TestRule {
        @Override
        public Statement apply(final Statement base, final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    }
                    catch (ExecutionException e) {
                        throw e.getCause();
                    }
                }
            };
        }
    }
}
