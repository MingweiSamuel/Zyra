package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.LazyResetableFuture;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Small tests for {@link com.mingweisamuel.zyra.util.LazyResetableFuture}.
 */
public class FutureTest {

    @Rule
    public final Timeout timeout = Timeout.seconds(10);

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

    @Test
    public void testIsDone() {
        LazyResetableFuture<String> f1 = new LazyResetableFuture<>(() -> CompletableFuture.completedFuture("foo"));
        assertFalse(f1.created());
        assertFalse(f1.isDone());
        assertEquals("foo", f1.join());
        assertTrue(f1.created());
        assertTrue(f1.isDone());
    }

    @Test
    public void testIsDoneAsync() {
        LazyResetableFuture<String> f1 = new LazyResetableFuture<>(() -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                fail();
            }
            return "foo";
        }));
        assertFalse(f1.created());
        assertFalse(f1.isDone());

        f1.get();
        assertTrue(f1.created());
        assertFalse(f1.isDone());

        f1.join();
        assertTrue(f1.created());
        assertTrue(f1.isDone());

        f1.reset();
        assertFalse(f1.created());
        assertFalse(f1.isDone());
    }

    @Test
    @Ignore
    public void testCompletableFutureNonlinear() {
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
        assertEquals("foo bar", f2.join());
        CompletableFuture<String> f3 = f1.thenApply(s -> s + " baz");
        assertEquals("foo baz", f3.join());
    }

    @Test
    @Ignore
    public void testCompletableFutureChaining() {
        final AtomicInteger n = new AtomicInteger(0);
        CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                fail();
            }
            return null;
        });
        f1.thenApply(v -> n.getAndIncrement());

        assertEquals(0, n.get());
        f1.join();
        assertEquals(1, n.get());
    }

    @Test
    public void testResetableFutureChaining() {
        final AtomicInteger n = new AtomicInteger(0);
        LazyResetableFuture<Void> f1 = new LazyResetableFuture<>(() -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                fail();
            }
            return null;
        }));
        // LazyResetableFutures are lazy. Never gets run.
        f1.thenApply(v -> n.getAndIncrement());

        assertEquals(0, n.get());
        f1.join();
        // 0 instead of 1
        assertEquals(0, n.get());
    }
}
