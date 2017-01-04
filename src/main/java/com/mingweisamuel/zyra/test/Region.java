package com.mingweisamuel.zyra.test;

/**
 * Created by Mingw on 2017-01-01.
 */
public enum Region {
    /** Brazil. */
    BR,
    /** North-east Europe. */
    EUNE,
    /** West Europe. */
    EUW,
    /** North America. */
    NA,
    /** Korea. */
    KR,
    /** North Latin America. */
    LAN,
    /** South Latin America. */
    LAS,
    /** Oceania. */
    OCE,
    /** Russia. */
    RU,
    /** Turkey. */
    TR,
    /** Japan. */
    JP,
    /** Global. */
    GLOBAL;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
