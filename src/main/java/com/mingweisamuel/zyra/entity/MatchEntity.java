package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.util.AsyncUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A high-level representation of a match. Thread-safe.
 */
public class MatchEntity extends Entity {

    static MatchEntity create(EntityApi entityApi, Region region, long matchId) {
        return new MatchEntity(entityApi, region, matchId);
    }

    /** This match's unique id. */
    private final long matchId;

    /** The match's general information. {@code null} if info hasn't been requested. */
    private final AtomicReference<CompletableFuture<Match>> matchInfo = new AtomicReference<>(null);
    /** The match's timeline. {@code null} if info hasn't been requested. */
    private final AtomicReference<CompletableFuture<MatchTimeline>> timeline = new AtomicReference<>(null);

    private MatchEntity(EntityApi entityApi, Region region, long matchId) {
        super(entityApi, region);
        this.matchId = matchId;
    }

    /** Returns the unique match id. Does not need to wait for any tasks to complete. */
    public long getMatchId() {
        return matchId;
    }

    public CompletableFuture<Match> getInfoAsync() {
        validate();
        return matchInfo.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.matches.getMatchAsync(region, matchId);
        });
    }
    public Match getInfo() {
        validate();
        return AsyncUtils.complete(getInfoAsync());
    }

    public CompletableFuture<MatchTimeline> getTimelineAsync() {
        validate();
        return timeline.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.matches.getMatchTimelineAsync(region, matchId);
        });
    }
    public MatchTimeline getTimeline() {
        validate();
        return AsyncUtils.complete(getTimelineAsync());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchEntity that = (MatchEntity) o;

        return matchId == that.matchId;
    }

    @Override
    public int hashCode() {
        return (int) (matchId ^ (matchId >>> 32));
    }
}
