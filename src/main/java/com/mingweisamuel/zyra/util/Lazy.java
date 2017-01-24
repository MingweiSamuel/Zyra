package com.mingweisamuel.zyra.util;

import java.util.function.Supplier;

/**
 * Lazy loading. Creates single instances only when needed. Thread safe.
 */
public class Lazy<T> {

    /** The value. Null if not yet created. */
    private volatile T value = null;
    /** The supplier. Null if already used. */
    private volatile Supplier<T> supplier;

    /**
     * Creates a Lazy using SUPPLIER.
     * @param supplier Supplier of the value (only called once).
     */
    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /** @return true if instance has been created. */
    public boolean created() {
        return supplier == null;
    }

    /** @return the instance. Creates it if needed. */
    public synchronized T get() {
        if (value == null) {
            value = supplier.get();
            supplier = null; // let GC collect supplier
        }
        return value;
    }
}
