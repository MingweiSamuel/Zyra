package com.mingweisamuel.zyra.enums;

/**
 * Region enumeration. Note that {@link #PBE} can only be used for certain endpoints, and {@link #GARENA},
 * {@link #TENCENT}, and {@link #GLOBAL} are not functional in endpoints.
 */
public enum Region {
    /** Brazil. */
    BR("BR1"),
    /** North-east Europe. */
    EUNE("EUN1"),
    /** West Europe. */
    EUW("EUW1"),
    /** North America. */
    NA("NA1"),
    /** Korea. */
    KR("KR"),
    /** North Latin America. */
    LAN("LA1"),
    /** South Latin America. */
    LAS("LA2"),
    /** Oceania. */
    OCE("OC1"),
    /** Russia. */
    RU("RU"),
    /** Turkey. */
    TR("TR1"),
    /** Japan. */
    JP("JP1"),

    /** Public beta environment. Only functional in certain endpoints. */
    PBE("PBE1"),
    /** Garena publisher - South east asia regions. Not functional in endpoints. */
    GARENA(null),
    /** Tencent publisher - China. Not functional in endpoints. */
    TENCENT(null),
    /** Global. */
    GLOBAL("global");

    /**
     * The Platform ID of the region.
     * @see <a href="https://developer.riotgames.com/docs/regional-endpoints">Riot documentation.</a>
     */
    public final String platform;
    Region(String platform) {
        this.platform = platform;
    }
    public String getSubdomain() {
        return this.platform.toLowerCase();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
