package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.util.AsyncUtils;

import java.util.concurrent.CompletableFuture;

/**
 * TODO
 */
public interface SummonerLoadable {

    /** Asynchronously loads basic summoner info if not already loaded.
     * @return A CompletableFuture completing when the data is finished loading. Will be complete immediately data is
     * already loaded. */
    CompletableFuture<Void> loadBasicAsync();
    /** Loads basic summoner info, blocking until it is loaded. Returns immediately if data is already loaded. */
    default void loadBasic() { AsyncUtils.get(loadBasicAsync()); }

    /** Asynchronously loads summoner runes if not already loaded.
     * @return A CompletableFuture completing when the data is finished loading. Will complete immediately if data is
     * already loaded. */
    CompletableFuture<Void> loadRunesAsync();
    /** Loads summoner runes, blocking until it is loaded. Returns immediately if data is already loaded. */
    default void loadRunes() { AsyncUtils.get(loadRunesAsync()); }

    /** Asynchronously loads summoner masteries if not already loaded.
     * @return A CompletableFuture completing when the data is finished loading. Will complete immediately if data is
     * already loaded. */
    CompletableFuture<Void> loadMasteriesAsync();
    /** Loads summoner masteries, blocking until it is loaded. Returns immediately if data is already loaded. */
    default void loadMasteries() { AsyncUtils.get(loadMasteriesAsync()); }

    /** Asynchronously loads summoner league (rank) if not already loaded.
     * @return A CompletableFuture completing when the data is finished loading. Will complete immediately if data is
     * already loaded. */
    CompletableFuture<Void> loadLeagueAsync();
    /** Loads summoner league (rank), blocking until it is loaded. Returns immediately if data is already loaded. */
    default void loadLeague() { AsyncUtils.get(loadLeagueAsync()); }

}
