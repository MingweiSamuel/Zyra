package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.util.RiotRequestException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RiotRequester extends Requester {

    /** Root url for Riot API requests. */
    public static final String RIOT_ROOT_URL = "%s.api.pvp.net/";

    /** Ten seconds in milliseconds. */
    public static final long TEN_SECONDS = 10_000;
    /** Ten minutes in milliseconds. */
    public static final long TEN_MINUTES = 600_000;
    /** Default rate limit per ten seconds (10). */
    public static final int TEN_SECONDS_DEFAULT_LIMIT = 10;
    /** Default rate limit per ten minutes (500). */
    public static final int TEN_MINUTES_DEFAULT_LIMIT = 500;

    /** Stores the rate limits to respect. Key is time in milliseconds, value is max requests per that time. */
    private final ConcurrentMap<Long, Integer> rateLimits = new ConcurrentHashMap<>();
    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    /** Creates a RiotRequester with APIKEY and the default client and default rate limits. */
    RiotRequester(String apiKey) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS, TEN_SECONDS_DEFAULT_LIMIT);
        rateLimits.put(TEN_MINUTES, TEN_MINUTES_DEFAULT_LIMIT);
    }

    RiotRequester(String apiKey, int rateLimitPer10Seconds, int rateLimitPer10Minutes) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS, rateLimitPer10Seconds);
        rateLimits.put(TEN_MINUTES, rateLimitPer10Minutes);
    }

    RiotRequester(String apiKey, Map<Long, Integer> rateLimits) {
        super(apiKey);
        rateLimits.putAll(rateLimits);
    }

    RiotRequester(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client) {
        super(apiKey, client);
        rateLimits.putAll(rateLimits);
    }

    public Response getRequestRateLimited(String relativeUrl, Region region) throws RiotRequestException {
        final RateLimiter limiter = getRateLimiter(region);
        try {
            limiter.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Response result = super.getRequest(String.format(RIOT_ROOT_URL, region), relativeUrl);
        limiter.release();
        return result;
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(String relativeUrl, Region region) {
        final RateLimiter limiter = getRateLimiter(region);
        return limiter.acquireAsync()
                .thenCompose(v -> super.getRequestAsync(String.format(RIOT_ROOT_URL, region), relativeUrl))
                .thenApply(r -> {
                    limiter.release();
                    return r;
                });
    }

    private RateLimiter getRateLimiter(Region region) {
        return rateLimiters.compute(region, (k, v) -> v == null ? new RateLimiter(rateLimits) : v);
    }
}
