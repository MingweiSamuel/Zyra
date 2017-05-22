package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.LazyResetableFuture;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Small tests for {@link com.mingweisamuel.zyra.util.LazyResetableFuture}.
 */
public class FutureTest {

    @Rule
    public final Timeout timeout = Timeout.seconds(30);

    @Test
    public void testCompletableFutureNonlinear() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                fail();
            }
            return "foo";
        });
        CompletableFuture<String> f2 = f1.thenApply(s -> s + " bar");
        assertEquals("foo bar", f2.get());
        CompletableFuture<String> f3 = f1.thenApply(s -> s + " baz");
        assertEquals("foo baz", f3.get());
    }

    @Test
    public void testResetableFutureBasic1() {
        LazyResetableFuture<String> f1 = LazyResetableFuture.completedFuture("foo");
        LazyResetableFuture<String> f2 = f1.thenApply(s -> s + " bar");
        assertEquals("foo bar", f2.join());
    }

    @Test
    public void testResetableFutureBasic2() {
        LazyResetableFuture<String> f1 = LazyResetableFuture.completedFuture("foo");
        LazyResetableFuture<String> f2 = f1.thenApply(s -> s + " bar");
        assertEquals("foo", f1.join());
        assertEquals("foo bar", f2.join());
    }

    @Test
    public void testResetableFutureBasicAsync() {
        LazyResetableFuture<String> f1 = new LazyResetableFuture<>(() -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                fail();
            }
            return "foo";
        }));
        LazyResetableFuture<String> f2 = f1.thenApply(s -> s + " bar");
        assertEquals("foo bar", f2.join());
    }
}
