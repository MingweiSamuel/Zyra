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
