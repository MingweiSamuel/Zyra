package com.mingweisamuel.zyra.util;

import java.util.function.Supplier;

/**
 * Lazy loading. Creates single instances only when needed. Thread safe.
 */
public class Lazy<T> implements Supplier<T> {

    /** The value. Null if not yet created. */
    protected volatile T value = null;
    /** The supplier. Null if already used. */
    protected volatile Supplier<T> supplier;

    /**
     * Creates a Lazy using SUPPLIER.
     * @param supplier Supplier of the value. Only called once.
     */
    public Lazy(Supplier<T> supplier) {
        if (supplier == null)
            throw new NullPointerException("supplier cannot be null");
        this.supplier = supplier;
    }

    /** @return true if instance has been created. */
    public boolean created() {
        return supplier == null;
    }

    /** @return the instance. Creates it if needed. */
    @Override
    public T get() {
        if (created())
            return value;
        return getInternal();
    }
    /**
     * Helper to avoid synchronizing {@link #get()}.
     * @return the instance.
     */
    protected synchronized T getInternal() {
        if (supplier != null) {
            value = supplier.get();
            supplier = null;
        }
        return value;
    }
}
