package com.mingweisamuel.zyra.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A Lazy specifically for CompletableFutures with retry functionality.
 * TODO. Currently the supplier is not retained.
 *
 * Note: Methods implementing {@link CompletionStage} keep a reference to the original LazyRetryableFuture so they
 * should be used with caution to avoid memory leaks.
 */
public final class LazyRetryableFuture<T> extends LazyRetryable<CompletableFuture<T>> implements CompletionStage<T> {

    /**
     * Creates a completed LazyRetryableFuture.
     * @param value
     * @param <T>
     * @return
     */
    public static <T> LazyRetryableFuture<T> completedFuture(T value) {
        return new LazyRetryableFuture<>(() -> CompletableFuture.completedFuture(value));
    }

    /**
     * Creates a LazyRetryableFuture using SUPPLIER.
     * @param supplier Supplier of the value. May be called multiple times on failure.
     */
    public LazyRetryableFuture(Supplier<CompletableFuture<T>> supplier) {
        super(supplier);
    }

    /**
     * Synchronously returns the result of the inner CompletableFuture. May throw exceptions TODO.
     * @return The inner value.
     */
    public T getSync() {
        return AsyncUtils.complete(get());
    }

    //region overrides
    @Override
    public <U> LazyRetryableFuture<U> thenApply(Function<? super T, ? extends U> fn) {
        return new LazyRetryableFuture<>(() -> get().thenApply(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn) {
        return new LazyRetryableFuture<>(() -> get().thenApplyAsync(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenApplyAsync(fn, executor));
    }
    @Override
    public LazyRetryableFuture<Void> thenAccept(Consumer<? super T> action) {
        return new LazyRetryableFuture<>(() -> get().thenAccept(action));
    }
    @Override
    public LazyRetryableFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return new LazyRetryableFuture<>(() -> get().thenAcceptAsync(action));
    }
    @Override
    public LazyRetryableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenAcceptAsync(action, executor));
    }
    @Override
    public LazyRetryableFuture<Void> thenRun(Runnable action) {
        return new LazyRetryableFuture<>(() -> get().thenRun(action));
    }
    @Override
    public LazyRetryableFuture<Void> thenRunAsync(Runnable action) {
        return new LazyRetryableFuture<>(() -> get().thenRunAsync(action));
    }
    @Override
    public LazyRetryableFuture<Void> thenRunAsync(Runnable action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenRunAsync(action, executor));
    }
    @Override
    public <U, V> LazyRetryableFuture<V> thenCombine(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return new LazyRetryableFuture<>(() -> get().thenCombine(other, fn));
    }
    @Override
    public <U, V> LazyRetryableFuture<V> thenCombineAsync(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return new LazyRetryableFuture<>(() -> get().thenCombineAsync(other, fn));
    }
    @Override
    public <U, V> LazyRetryableFuture<V> thenCombineAsync(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenCombineAsync(other, fn, executor));
    }
    @Override
    public <U> LazyRetryableFuture<Void> thenAcceptBoth(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return new LazyRetryableFuture<>(() -> get().thenAcceptBoth(other, action));
    }
    @Override
    public <U> LazyRetryableFuture<Void> thenAcceptBothAsync(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return new LazyRetryableFuture<>(() -> get().thenAcceptBothAsync(other, action));
    }
    @Override
    public <U> LazyRetryableFuture<Void> thenAcceptBothAsync(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenAcceptBothAsync(other, action, executor));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return new LazyRetryableFuture<>(() -> get().runAfterBoth(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return new LazyRetryableFuture<>(() -> get().runAfterBothAsync(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().runAfterBothAsync(other, action, executor));
    }
    @Override
    public <U> LazyRetryableFuture<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return new LazyRetryableFuture<>(() -> get().applyToEither(other, fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> applyToEitherAsync(
            CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return new LazyRetryableFuture<>(() -> get().applyToEitherAsync(other, fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> applyToEitherAsync(
            CompletionStage<? extends T> other, Function<? super T, U> fn, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().applyToEitherAsync(other, fn, executor));
    }
    @Override
    public LazyRetryableFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return new LazyRetryableFuture<>(() -> get().acceptEither(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return new LazyRetryableFuture<>(() -> get().acceptEitherAsync(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> acceptEitherAsync(
            CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().acceptEitherAsync(other, action, executor));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return new LazyRetryableFuture<>(() -> get().runAfterEither(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return new LazyRetryableFuture<>(() -> get().runAfterEitherAsync(other, action));
    }
    @Override
    public LazyRetryableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().runAfterEitherAsync(other, action, executor));
    }
    @Override
    public <U> LazyRetryableFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn) {
        return new LazyRetryableFuture<>(() -> get().thenCompose(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn) {
        return new LazyRetryableFuture<>(() -> get().thenComposeAsync(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> thenComposeAsync(
            Function<? super T, ? extends CompletionStage<U>> fn, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().thenComposeAsync(fn, executor));
    }
    @Override
    public LazyRetryableFuture<T> exceptionally(Function<Throwable, ? extends T> fn) {
        return new LazyRetryableFuture<>(() -> get().exceptionally(fn));
    }
    @Override
    public LazyRetryableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
        return new LazyRetryableFuture<>(() -> get().whenComplete(action));
    }
    @Override
    public LazyRetryableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
        return new LazyRetryableFuture<>(() -> get().whenCompleteAsync(action));
    }
    @Override
    public LazyRetryableFuture<T> whenCompleteAsync(
            BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().whenCompleteAsync(action, executor));
    }
    @Override
    public <U> LazyRetryableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn) {
        return new LazyRetryableFuture<>(() -> get().handle(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn) {
        return new LazyRetryableFuture<>(() -> get().handleAsync(fn));
    }
    @Override
    public <U> LazyRetryableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor) {
        return new LazyRetryableFuture<>(() -> get().handleAsync(fn, executor));
    }
    @Override
    public CompletableFuture<T> toCompletableFuture() {
        return this.get();
    }
    //endregion
}
