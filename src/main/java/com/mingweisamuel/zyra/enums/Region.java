package com.mingweisamuel.zyra.enums;

/**
 * Region enumeration. Note that {@link #PBE} can only be used for certain endpoints, and {@link #GARENA},
 * {@link #TENCENT}, and {@link #GLOBAL} are not functional in endpoints.
 */
public enum Region {
    /** Brazil. */
    BR("BR1", true),
    /** North-east Europe. */
    EUNE("EUN1", true),
    /** West Europe. */
    EUW("EUW1", true),
    /** North America. */
    NA("NA1", true),
    /** Korea. */
    KR("KR", true),
    /** North Latin America. */
    LAN("LA1", true),
    /** South Latin America. */
    LAS("LA2", true),
    /** Oceania. */
    OCE("OC1", true),
    /** Russia. */
    RU("RU", true),
    /** Turkey. */
    TR("TR1", true),
    /** Japan. */
    JP("JP1", true),

    /** Public beta environment. Only functional in certain endpoints. */
    PBE("PBE1", true),
    /** Garena publisher - South east asia regions. Not functional in endpoints. */
    GARENA(null, false),
    /** Tencent publisher - China. Not functional in endpoints. */
    TENCENT(null, false),
    /** Global. */
    GLOBAL("global", false);

    public final boolean isSupported;
    /**
     * The Platform ID of the region.
     * @see <a href="https://developer.riotgames.com/docs/regional-endpoints">Riot documentation.</a>
     */
    public final String platform;
    Region(String platform, boolean isSupported) {
        this.platform = platform;
        this.isSupported = isSupported;
    }
    public String getSubdomain() {
        if (this.platform == null)
            return null;
        return this.platform.toLowerCase();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    /**
     * Parses a region or platform string. Returns null if no matching region was found.
     *
     * @param value The region or platform to look for. If {@code null}, returns {@code null}.
     * @return The Region if found, {@code null} otherwise.
     */
    public static Region parse(String value) {
        if (value == null)
            return null;
        value = value.toLowerCase();
        for (Region region : Region.values()) {
            if (value.equals(region.toString()))
                return region;
            if (value.equals(region.getSubdomain())) // subdomain may be null.
                return region;
        }
        return null;
    }
}
