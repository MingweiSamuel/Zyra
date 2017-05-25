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
 * A Lazy specifically for CompletableFutures with reset functionality. Adds the {@link #join()} method for
 * convenience.<br><br>
 *
 * Note: Methods implementing {@link CompletionStage} keep a reference to the original LazyResetableFuture so they
 * should be used with caution to avoid memory leaks.
 */
public final class LazyResetableFuture<T> extends LazyResetable<CompletableFuture<T>> implements CompletionStage<T> {

    /**
     * Creates a completed LazyResetableFuture.
     * @param value The resulting value.
     * @param <T> Value's type.
     * @return A completed LazyResetableFuture.
     */
    public static <T> LazyResetableFuture<T> completedFuture(T value) {
        return new LazyResetableFuture<>(() -> CompletableFuture.completedFuture(value));
    }

    /**
     * Creates a LazyResetableFuture with a future that has already been started.
     * @param future The future.
     * @param <T> Value's type.
     * @return A started LazyResetableFuture.
     */
    public static <T> LazyResetableFuture<T> startedFuture(CompletableFuture<T> future) {
        return new LazyResetableFuture<T>(() -> future);
    }

    /**
     * Creates a LazyResetableFuture using SUPPLIER.
     * @param supplier Supplier of the value. May be called multiple times on failure.
     */
    public LazyResetableFuture(Supplier<CompletableFuture<T>> supplier) {
        super(supplier);
    }

    /**
     * Synchronously returns the result of the inner CompletableFuture. May throw exceptions.
     * @return The inner value.
     */
    public T join() {
        return get().join();
    }

    /**
     * Returns whether the value has been received. This means the CompletableFuture has been both created and
     * completed.
     * @return {@code true} if completed and data is available. {@code false} otherwise.
     */
    public boolean isDone() {
        return created() && get().isDone();
    }

    //region CompletionStage methods
    @Override
    public <U> LazyResetableFuture<U> thenApply(Function<? super T, ? extends U> fn) {
        return new LazyResetableFuture<>(() -> get().thenApply(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn) {
        return new LazyResetableFuture<>(() -> get().thenApplyAsync(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenApplyAsync(fn, executor));
    }
    @Override
    public LazyResetableFuture<Void> thenAccept(Consumer<? super T> action) {
        return new LazyResetableFuture<>(() -> get().thenAccept(action));
    }
    @Override
    public LazyResetableFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return new LazyResetableFuture<>(() -> get().thenAcceptAsync(action));
    }
    @Override
    public LazyResetableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenAcceptAsync(action, executor));
    }
    @Override
    public LazyResetableFuture<Void> thenRun(Runnable action) {
        return new LazyResetableFuture<>(() -> get().thenRun(action));
    }
    @Override
    public LazyResetableFuture<Void> thenRunAsync(Runnable action) {
        return new LazyResetableFuture<>(() -> get().thenRunAsync(action));
    }
    @Override
    public LazyResetableFuture<Void> thenRunAsync(Runnable action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenRunAsync(action, executor));
    }
    @Override
    public <U, V> LazyResetableFuture<V> thenCombine(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return new LazyResetableFuture<>(() -> get().thenCombine(other, fn));
    }
    @Override
    public <U, V> LazyResetableFuture<V> thenCombineAsync(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn) {
        return new LazyResetableFuture<>(() -> get().thenCombineAsync(other, fn));
    }
    @Override
    public <U, V> LazyResetableFuture<V> thenCombineAsync(
            CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenCombineAsync(other, fn, executor));
    }
    @Override
    public <U> LazyResetableFuture<Void> thenAcceptBoth(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return new LazyResetableFuture<>(() -> get().thenAcceptBoth(other, action));
    }
    @Override
    public <U> LazyResetableFuture<Void> thenAcceptBothAsync(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action) {
        return new LazyResetableFuture<>(() -> get().thenAcceptBothAsync(other, action));
    }
    @Override
    public <U> LazyResetableFuture<Void> thenAcceptBothAsync(
            CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenAcceptBothAsync(other, action, executor));
    }
    @Override
    public LazyResetableFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return new LazyResetableFuture<>(() -> get().runAfterBoth(other, action));
    }
    @Override
    public LazyResetableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return new LazyResetableFuture<>(() -> get().runAfterBothAsync(other, action));
    }
    @Override
    public LazyResetableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().runAfterBothAsync(other, action, executor));
    }
    @Override
    public <U> LazyResetableFuture<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return new LazyResetableFuture<>(() -> get().applyToEither(other, fn));
    }
    @Override
    public <U> LazyResetableFuture<U> applyToEitherAsync(
            CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return new LazyResetableFuture<>(() -> get().applyToEitherAsync(other, fn));
    }
    @Override
    public <U> LazyResetableFuture<U> applyToEitherAsync(
            CompletionStage<? extends T> other, Function<? super T, U> fn, Executor executor) {
        return new LazyResetableFuture<>(() -> get().applyToEitherAsync(other, fn, executor));
    }
    @Override
    public LazyResetableFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return new LazyResetableFuture<>(() -> get().acceptEither(other, action));
    }
    @Override
    public LazyResetableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action) {
        return new LazyResetableFuture<>(() -> get().acceptEitherAsync(other, action));
    }
    @Override
    public LazyResetableFuture<Void> acceptEitherAsync(
            CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().acceptEitherAsync(other, action, executor));
    }
    @Override
    public LazyResetableFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return new LazyResetableFuture<>(() -> get().runAfterEither(other, action));
    }
    @Override
    public LazyResetableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return new LazyResetableFuture<>(() -> get().runAfterEitherAsync(other, action));
    }
    @Override
    public LazyResetableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().runAfterEitherAsync(other, action, executor));
    }
    @Override
    public <U> LazyResetableFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn) {
        return new LazyResetableFuture<>(() -> get().thenCompose(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn) {
        return new LazyResetableFuture<>(() -> get().thenComposeAsync(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> thenComposeAsync(
            Function<? super T, ? extends CompletionStage<U>> fn, Executor executor) {
        return new LazyResetableFuture<>(() -> get().thenComposeAsync(fn, executor));
    }
    @Override
    public LazyResetableFuture<T> exceptionally(Function<Throwable, ? extends T> fn) {
        return new LazyResetableFuture<>(() -> get().exceptionally(fn));
    }
    @Override
    public LazyResetableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
        return new LazyResetableFuture<>(() -> get().whenComplete(action));
    }
    @Override
    public LazyResetableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
        return new LazyResetableFuture<>(() -> get().whenCompleteAsync(action));
    }
    @Override
    public LazyResetableFuture<T> whenCompleteAsync(
            BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        return new LazyResetableFuture<>(() -> get().whenCompleteAsync(action, executor));
    }
    @Override
    public <U> LazyResetableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn) {
        return new LazyResetableFuture<>(() -> get().handle(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn) {
        return new LazyResetableFuture<>(() -> get().handleAsync(fn));
    }
    @Override
    public <U> LazyResetableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor executor) {
        return new LazyResetableFuture<>(() -> get().handleAsync(fn, executor));
    }
    @Override
    public CompletableFuture<T> toCompletableFuture() {
        return this.get();
    }
    //endregion
}
