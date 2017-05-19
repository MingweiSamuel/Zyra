package com.mingweisamuel.zyra.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Static utility methods for working with async endpoints.
 */
public class AsyncUtils {
    private AsyncUtils() {}

    public static <T> T complete(CompletableFuture<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
