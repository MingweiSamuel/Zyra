package com.mingweisamuel.zyra.util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Requester for sending requests to the wherever.
 */
public class Requester implements Closeable {

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
     * Creates a requester with APIKEY and specified CLIENT.
     */
    public Requester(String apiKey, AsyncHttpClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    /**
     * Sends a get request to rootUrl + relativeUrl asynchronously.
     *
     * @param rootUrl
     * @param relativeUrl
     * @return a CompletableFuture of the response
     */
    public CompletableFuture<Response> getRequestAsync(String rootUrl, String relativeUrl, List<Param> params) {
        return client.prepareGet(String.format("https://%s%s", rootUrl, relativeUrl))
                .addQueryParam(API_KEY_PARAMETER, apiKey)
                .addQueryParams(params)
                .execute().toCompletableFuture();
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
