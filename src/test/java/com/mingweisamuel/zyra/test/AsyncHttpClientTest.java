package com.mingweisamuel.zyra.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.test.model.Summoner;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * Created by Mingw on 2017-01-01.
 */
public class AsyncHttpClientTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        for (int i = 0; i < 20; i++) {
            client.prepareGet("https://www.google.com").execute().toCompletableFuture()
                    .thenAccept(r -> System.out.println(r.getResponseBody()));
        }
    }

    @Test
    public void test2() throws IOException {
        for (int i = 0; i < 20; i++) {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println(result.toString());
        }
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        Type mapType = new TypeToken<Map<String, Summoner>>() {}.getType();
        AsyncHttpClient httpClient = new DefaultAsyncHttpClient();
        Gson gson = new Gson();
        CompletableFuture[] tasks = IntStream.range(0, 20).mapToObj(i ->
                httpClient.prepareGet("https://na.api.pvp.net/api/lol/na/v2.2/match/2378165490")
                    .addQueryParam("includeTimeline", "true")
                    .addQueryParam("api_key", "86cddb9d-e5e4-4a1e-b7eb-24d74685ef1b")
                    .execute().toCompletableFuture()
                    .thenApply(Response::getResponseBody)
                    .thenAccept(g -> System.out.println(i + ": " +
                            g.toString().substring(0, Math.min(g.toString().length(), 80)))))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(tasks).get();
    }
}
