package com.mingweisamuel.zyra.util;

import java.util.function.Supplier;

/**
 * A Lazy that has retrying and reseting functionality.
 * TODO
 */
public class LazyRetryable<T> extends Lazy<T> {

    private volatile boolean created = false;

    /**
     * Creates a Lazy using SUPPLIER.
     * @param supplier Supplier of the value. May be called multiple times for retries or resets.
     */
    public LazyRetryable(Supplier<T> supplier) {
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
        }
        return value;
    }
}
