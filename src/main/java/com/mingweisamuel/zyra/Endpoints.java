package com.mingweisamuel.zyra;

/**
 * Base class for Enpoints classes.
 */
public abstract class Endpoints {

    protected final RiotApi riotApi;

    public Endpoints(RiotApi riotApi) {
        this.riotApi = riotApi;
    }
}
