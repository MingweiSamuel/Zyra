package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.LocaleUtil;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;
import org.junit.Test;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStaticDataEndpoints}.
 */
public class ApiStaticDataTest {

    @Test
    public void getChampions() throws ExecutionException {
        //TODO: champdata argument as collection
        checkGetChampions(api.staticData.getChampions(Region.NA, LocaleUtil.zh_CN, null, null));
    }

    private void checkGetChampions(ChampionList result) {
        System.out.println(result.data);
        System.out.println(result.keys);
    }
}
