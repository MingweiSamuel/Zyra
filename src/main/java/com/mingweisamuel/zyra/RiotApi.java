package com.mingweisamuel.zyra;

import com.google.gson.Gson;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.util.Lazy;
import com.mingweisamuel.zyra.util.RateLimitedRequester;
import org.asynchttpclient.Param;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API. The main class for interacting with the Riot API on a low level.<br><br>
 *
 * The {@link com.mingweisamuel.zyra.entity.EntityApi} is simpler and more user-friendly to use.
 */
public class RiotApi implements Closeable {

    /** Json parser. */
    private final Gson gson = new Gson();
    /** Web requester. */
    private final Lazy<RateLimitedRequester> requester;

    public final ChampionEndpoints champions = new ChampionEndpoints(this);
    public final ChampionMasteryEndpoints championMasteries = new ChampionMasteryEndpoints(this);
    public final LeagueEndpoints leagues = new LeagueEndpoints(this);
    public final LolStaticDataEndpoints staticData = new LolStaticDataEndpoints(this);
    public final LolStatusEndpoints status = new LolStatusEndpoints(this);
    public final MatchEndpoints matches = new MatchEndpoints(this);
    public final SpectatorEndpoints spectator = new SpectatorEndpoints(this);
    public final SummonerEndpoints summoners = new SummonerEndpoints(this);
    public final ThirdPartyCodeEndpoints thirdPartyCode = new ThirdPartyCodeEndpoints(this);
    public final TournamentEndpoints tournament = new TournamentEndpoints(this);
    public final TournamentStubEndpoints tournamentStub = new TournamentStubEndpoints(this);

    /**
     * Creates a new RiotApi instance with default configuration.
     * @param apiKey Riot API key.
     * @return RiotApi instance using supplied apiKey.
     */
    public static RiotApi newInstance(String apiKey) {
        return new RiotApi(RiotApiConfig.builder(apiKey).build());
    }

    /**
     * Creates a new RiotApi instance with the provided configuration.
     * @param config RiotApiConfig. use {@link RiotApiConfig#builder(String)} and
     * {@link RiotApiConfig.Builder#build()}
     * @return RiotApi instance using supplied configuration.
     */
    public static RiotApi newInstance(RiotApiConfig config) {
        return new RiotApi(config);
    }

    private RiotApi(RiotApiConfig config) {
        requester = new Lazy<>(() -> new RateLimitedRequester(config));
    }

    /**
     * Standardizes the supplied summoner name by removing whitespace and converting all uppercase letters to lowercase.
     * @param name Summoner name.
     * @return Standardized summoner name.
     */
    public static String standardizeName(String name) {
        return name.replaceAll("\\s", "").toLowerCase();
    }

    @Override
    public void close() throws IOException {
        requester.get().close(); // May create the requester to immediately close it.
    }

    //region util
    <T> T getBasic(String methodId, String url, Region region, Type type, List<Param> params) {
        return this.<T>getBasicAsync(methodId, url, region, type, params).join();
    }

    <T> CompletableFuture<T> getBasicAsync(String methodId, String url, Region region, Type type, List<Param> params) {
        return requester.get().getRequestRateLimitedAsync(methodId, url, region, params)
                .thenApply(r -> r.getStatusCode() != 200 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    <T> T getBasicNonRateLimited(String methodId, String url, Region region, Type type, List<Param> params) {
        return this.<T>getBasicNonRateLimitedAsync(methodId, url, region, type, params).join();
    }

    <T> CompletableFuture<T> getBasicNonRateLimitedAsync(String methodId, String url, Region region, Type type, List<Param> params) {
        return requester.get().getRequestNonRateLimitedAsync(methodId, url, region, params)
                .thenApply(r -> r.getStatusCode() != 200 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    <T> T getNonApi(String fullUrl, Type type, List<Param> params) {
        return this.<T>getNonApiAsync(fullUrl, type, params).join();
    }

    <T> CompletableFuture<T> getNonApiAsync(String fullUrl, Type type, List<Param> params) {
        return requester.get().getRequestAsync(fullUrl, "", params)
                .thenApply(r -> gson.fromJson(r.getResponseBody(), type));
    }
    //endregion

    /**
     * Creates params from each pair of elements. Must be an even number of elements. Key values must be non-null.
     * @param paired
     * @return
     */
    List<Param> makeParams(Object... paired) {

        ArrayList<Param> result = new ArrayList<>(paired.length / 2);
        for (int i = 0; i < paired.length; i += 2) {

            Object key = paired[i];
            if (key == null)
                throw new IllegalStateException("Cannot have null param key");

            Object value = paired[i + 1];
            if (value == null)
                continue;

            if (value instanceof Collection) {
                for (Object v : ((Collection<?>) value))
                    result.add(new Param(key.toString(), v.toString()));
            }
            else
                result.add(new Param(key.toString(), value.toString()));
        }
        return result;
    }
    //endregion
}
