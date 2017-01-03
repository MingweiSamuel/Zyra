package com.mingweisamuel.zyra.model;

/**
 * Created by Mingw on 2017-01-01.
 */
public class Summoner {
    /** Summoner ID. */
    public long id;
    /** Summoner name. */
    public String name;
    /** ID of the summoner icon associated with the summoner. */
    public int profileIconId;
    /** Date summoner was last modified specified as epoch milliseconds. The following events will update this
     * timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name
     * change. */
    public long revisionDate;
    /** Summoner level associated with the summoner. */
    public long summonerLevel;

    @Override
    public String toString() {
        return String.format("[%d:%s]", id, name);
    }
}
