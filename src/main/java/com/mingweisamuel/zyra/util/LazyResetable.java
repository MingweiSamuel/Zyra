package com.mingweisamuel.zyra.util;

import java.util.function.Supplier;

/**
 * A Lazy that has reseting functionality.
 */
public class LazyResetable<T> extends Lazy<T> {

    private volatile boolean created = false;

    /**
     * Creates a Lazy using SUPPLIER.
     * @param supplier Supplier of the value. May be called multiple times for retries or resets.
     */
    public LazyResetable(Supplier<T> supplier) {
        super(supplier);
    }

    @Override
    public boolean created() {
        return created;
    }

    @Override
    protected synchronized T getInternal() {
        if (!created) {
            value = supplier.get();
            created = true;
        }
        return value;
    }

    /** Resets the LazyResetable. The original supplier will be called if {@link #get()} is called. */
    public void reset() {
        if (!created())
            return;
        synchronized (this) {
            created = false;
            value = null; // gc
        }
    }
}
