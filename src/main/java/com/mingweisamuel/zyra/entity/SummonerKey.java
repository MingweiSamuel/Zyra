package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;

/**
 * TODO javadoc
 */
class SummonerKey {
    public final Region region;
    public final long summonerId;

    SummonerKey(Region region, long summonerId) {
        this.region = region;
        this.summonerId = summonerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SummonerKey that = (SummonerKey) o;

        return summonerId == that.summonerId && region == that.region;
    }

    @Override
    public int hashCode() {
        return 31 * region.hashCode() + (int) (summonerId ^ (summonerId >>> 32));
    }
}
