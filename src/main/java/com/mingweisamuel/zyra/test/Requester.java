package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.test.util.RiotResponseException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Requester for sending requests to the wherever.
 */
class Requester {

    /**
     * The query parameter name used to specify the api key in requests.
     */
    private static final String API_KEY_PARAMETER = "api_key";

    /**
     * Riot API key.
     */
    private final String apiKey;
    /**
     * Client used to send requests.
     */
    private final AsyncHttpClient client;

    /**
     * Creates a requester with APIKEY and new DefaultAsyncHttpClient.
     */
    Requester(String apiKey) {
        this(apiKey, new DefaultAsyncHttpClient());
    }

    /**
     * Creates a requester with APIKEY and specified CLIENT.
     */
    Requester(String apiKey, AsyncHttpClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    /**
     * Sends a get request to rootUrl + relativeUrl (synchronous).
     *
     * @param rootUrl
     * @param relativeUrl
     * @return The response
     */
    public Response getRequest(String rootUrl, String relativeUrl) throws RiotResponseException {
        String url = String.format("https://%s%s", rootUrl, relativeUrl);
        try {
            return client.prepareGet(url).addQueryParam(API_KEY_PARAMETER, apiKey)
                    .execute().get();
        } catch (ExecutionException e) {
            throw new RiotResponseException("Request failed: " + url, e, null);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException();
        }
    }

    /**
     * Sends a get request to rootUrl + relativeUrl asynchronously.
     *
     * @param rootUrl
     * @param relativeUrl
     * @return a CompletableFuture of the response
     */
    public CompletableFuture<Response> getRequestAsync(String rootUrl, String relativeUrl) {
        return client.prepareGet(String.format("https://%s%s", rootUrl, relativeUrl))
                .addQueryParam(API_KEY_PARAMETER, apiKey)
                .execute().toCompletableFuture();
    }
}
