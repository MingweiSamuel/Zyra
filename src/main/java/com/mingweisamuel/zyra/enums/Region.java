package com.mingweisamuel.zyra.enums;

/**
 * Region enumeration.
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
    /** Global. */
    GLOBAL(null);

    /**
     * The Platform ID of the region.
     * @see <a href="https://developer.riotgames.com/docs/regional-endpoints">Riot documentation.</a>
     */
    public final String platform;
    Region(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
