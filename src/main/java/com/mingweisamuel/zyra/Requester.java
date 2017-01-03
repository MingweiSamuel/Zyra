package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.util.RiotRequestException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Requester for sending requests to the wherever.
 */
public class Requester {

    /** The query parameter name used to specify the api key in requests. */
    private static final String API_KEY_PARAMETER = "api_key";

    /** Riot API key. */
    private final String apiKey;
    /** Client used to send requests. */
    private final AsyncHttpClient client;

    /** Creates a requester with APIKEY and new DefaultAsyncHttpClient. */
    Requester(String apiKey) {
        this(apiKey, new DefaultAsyncHttpClient());
    }

    /** Creates a requester with APIKEY and specified CLIENT. */
    Requester(String apiKey, AsyncHttpClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    /**
     * Sends a get request to rootUrl + relativeUrl (synchronous).
     * @return The response
     * */
    public Response getRequest(String rootUrl, String relativeUrl) throws RiotRequestException {
        String url = String.format("https://%s%s", rootUrl, relativeUrl);
        try {
            for (int i = 0; i < 3; i++) {
                Response response = client.prepareGet(url).addQueryParam(API_KEY_PARAMETER, apiKey)
                        .execute().get();
                if (response.getStatusCode() == 200)
                    return response;
                if (response.getStatusCode() != 429)
                    break;
            }
        } catch (ExecutionException e) {
            throw new RiotRequestException("Request failed: " + url, e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new RiotRequestException("Request failed after retries: " + url);
    }

    /**
     * Sends a get request to rootUrl + relativeUrl asynchronously.
     * @return a CompletableFuture of the response
     */
    public CompletableFuture<Response> getRequestAsync(String rootUrl, String relativeUrl) {
        return client.prepareGet(String.format("https://%s%s", rootUrl, relativeUrl))
                .addQueryParam(API_KEY_PARAMETER, apiKey)
                .execute().toCompletableFuture();
    }
}
