package com.mingweisamuel.zyra.util;

@FunctionalInterface
public interface TemporalBucketFactory {

    TemporalBucket get(long timespan, int totalLimit);
}
