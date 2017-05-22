package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Matchlist;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.DRAVEN;
import static org.junit.Assert.assertEquals;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchEndpoints}.
 */
@Ignore
public class ApiMatchListTest extends ApiTest {

    @Test
    public void get() { // C9 Sneaky's Account ID
        checkGet(api.matches.getMatchlist(Region.NA, 78247, null, null, null,
            Collections.singletonList(16), Collections.singletonList(DRAVEN)));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.matches.getMatchlistAsync(Region.NA, 78247, Collections.singletonList(16), null, null,
            Collections.singletonList(DRAVEN)).thenAccept(this::checkGet).get();
    }
    private void checkGet(Matchlist result) {
        assertEquals(0, result.startIndex);
        assertEquals(18, result.endIndex);
        assertEquals(18, result.totalGames);
        assertEquals(18, result.matches.size());
        long[] expected = {
                2379723179L, 2258983969L, 2253809465L, 2252238606L, 2250285762L, 2247158837L, 2235194044L, 2223182691L,
                2220389541L, 2217936310L, 2203146757L, 2174080519L, 2174003071L, 2172905917L, 2172288759L, 2143848249L,
                2119419310L, 2092895493L};
        for (int i = 0; i < result.matches.size(); i++)
            assertEquals(expected[i], result.matches.get(i).gameId);
    }
}
