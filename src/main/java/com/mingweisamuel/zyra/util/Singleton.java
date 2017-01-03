package com.mingweisamuel.zyra.util;

import java.util.function.Supplier;

/**
 * For creating single instances only when needed. Thread safe.
 */
public class Singleton<T> {
    /** The value. Null if not yet created. */
    private volatile T value = null;
    /** The supplier. Null if already used. */
    private volatile Supplier<T> supplier;
    /** Creates a Singleton using SUPPLIER. */
    public Singleton(Supplier<T> supplier) {
        this.supplier = supplier;
    }
    /** Gets the instance. Creates it if needed. */
    public synchronized T get() {
        if (value == null) {
            value = supplier.get();
            supplier = null; // let GC collect supplier
        }
        return value;
    }
}
