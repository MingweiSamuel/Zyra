package com.mingweisamuel.zyra.util;

@FunctionalInterface
public interface TokenBucketFactory {

    TokenBucket get(long timespan, int totalLimit, float concurrentInstanceFactor, float overheadFactor);
}
