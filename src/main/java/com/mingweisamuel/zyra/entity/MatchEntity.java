package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.TeamId;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchFrame;
import com.mingweisamuel.zyra.match.MatchParticipantFrame;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.match.Participant;
import com.mingweisamuel.zyra.match.ParticipantIdentity;
import com.mingweisamuel.zyra.match.TeamStats;
import com.mingweisamuel.zyra.util.LazyResetableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

/**
 * A high-level representation of a match. Thread-safe.
 */
public class MatchEntity extends Entity {

    static MatchEntity create(EntityApi entityApi, Region region, long matchId) {
        return new MatchEntity(entityApi, region, matchId);
    }

    /** This match's unique id. Set from initialization. */
    private final long matchId;

    /** The match's general information.  */
    private final LazyResetableFuture<Match> matchInfo;
    /** The match's timeline. */
    private final LazyResetableFuture<MatchTimeline> timeline;

    /** The match's participantInfo entities. */
    private final LazyResetableFuture<List<ParticipantEntity>> participants;

    private MatchEntity(EntityApi entityApi, Region region, long matchId) {
        super(entityApi, region);
        this.matchId = matchId;

        matchInfo = new LazyResetableFuture<>(() -> entityApi.riotApi.matches.getMatchAsync(region, matchId));
        timeline = new LazyResetableFuture<>(() -> entityApi.riotApi.matches.getMatchTimelineAsync(region, matchId));
        participants = matchInfo.thenApply(m -> {
            List<ParticipantEntity> result = new ArrayList<>(m.participantIdentities.size());
            for (ParticipantIdentity pid : m.participantIdentities) {
                result.add(new ParticipantEntity(pid.participantId, m,
                    pid.player != null ? entityApi.getSummonerFromPlayer(pid.player) : null));
            }
            return result;
        });
    }

    /** Returns the unique match id. Does not need to wait for any tasks to complete. */
    public long getMatchId() {
        return matchId;
    }

    //region info
    public CompletableFuture<Match> getInfoAsync() {
        return matchInfo.get();
    }
    public Match getInfo() {
        return matchInfo.join();
    }
    //endregion

    //region timeline
    public CompletableFuture<MatchTimeline> getTimelineAsync() {
        return timeline.get();
    }
    public MatchTimeline getTimeline() {
        return timeline.join();
    }
    //endregion

    //region summoners
    public CompletableFuture<List<ParticipantEntity>> getParticipantsAsync() {
        return participants.get();
    }
    public List<ParticipantEntity> getParticipants() {
        return participants.join();
    }

    /**
     * See {@link com.mingweisamuel.zyra.enums.TeamId}.
     * @param teamId Team id.
     * @return List of participants on team. Empty list if bad teamId.
     */
    public CompletableFuture<List<ParticipantEntity>> getParticipantsOnTeam(int teamId) {
        return getParticipantsAsync().thenApply(participants -> {
            List<ParticipantEntity> result = new ArrayList<>(participants.size() / 2);
            for (ParticipantEntity participant : participants)
                if (participant.getTeamId() == teamId)
                    result.add(participant);
            return result;
        });
    }

    public CompletableFuture<ParticipantIdentity> getParticipantFromSummoner(SummonerEntity summoner) {
        return null; // TODO
    }
    //endregion

    /**
     * A entity representation of a participantInfo in a single match. May or may not be associated with a SummonerEntity.
     */
    public class ParticipantEntity extends Entity {

        private final int participantId;
        private final SummonerEntity summonerEntity;

        private final Participant participantInfo;

        private final TeamStats teamStats;

        private final LazyResetableFuture<SortedMap<Long, MatchParticipantFrame>> timeline;

        /**
         * Creates a participant entity.
         * @param participantId The participant id. Required.
         * @param matchInfo Match information. Calling {@code MatchEntity.this.matchInfo.join()} will deadlock.
         * @param summonerEntity Summoner entity, can be null if {@link ParticipantIdentity#player} not provided by api.
         */
        private ParticipantEntity(int participantId, Match matchInfo, SummonerEntity summonerEntity) {
            super(MatchEntity.this.entityApi, summonerEntity == null ? MatchEntity.this.region : summonerEntity.region);

            this.participantId = participantId;
            this.summonerEntity = summonerEntity;

            // doesn't need async because getInfo() must already have been pulled.
            this.participantInfo = matchInfo.participants.stream()
                .filter(p -> this.participantId == p.participantId).findAny()
                .orElseThrow(() -> new IllegalStateException("Participant with id not found: " + participantId));
            this.teamStats = matchInfo.teams.stream()
                .filter(t -> participantInfo.teamId == t.teamId).findAny()
                .orElseThrow(() -> new IllegalStateException("TeamStats for teamId not found: " + participantInfo.teamId));

            //noinspection ConstantConditions
            this.timeline = MatchEntity.this.timeline
                .thenApply(timeline -> {
                    SortedMap<Long, MatchParticipantFrame> result = new TreeMap<>();
                    for (MatchFrame frame : timeline.frames)
                        result.put(frame.timestamp, frame.participantFrames.get(participantId));
                    return result;
                });
        }

        /** @return The participant's unique id for the match. */
        public int getParticipantId() {
            return participantId;
        }

        /**
         * Gets the summoner entity who played as this participantInfo.
         * @return The summoner entity. May be {@code null} if summoner entity doesn't exist. This occurs when
         *      matches do not include identity information which usually means the match was unranked.
         */
        public SummonerEntity getSummonerEntity() {
            return summonerEntity;
        }

        /** @return The participant information. */
        public Participant getParticipantInfo() {
            return participantInfo;
        }
        /** @return The participantInfo's teamId. See {@link com.mingweisamuel.zyra.enums.TeamId}. */
        public int getTeamId() {
            return participantInfo.teamId;
        }
        /** @return The participantInfo's team's stats. */
        public TeamStats getTeamStats() {
            return teamStats;
        }
        /** @return {@code true} if the participantInfo won, {@code false} if the participantInfo lost. */
        public boolean isWinner() {
            return TeamId.WIN.equals(teamStats.win);
        }

        /** @return A CompletableFuture for this participantInfo's timeline, which is a list of MatchParticipantFrames. */
        public CompletableFuture<SortedMap<Long, MatchParticipantFrame>> getTimelineAsync() {
            return timeline.get();
        }
        /**
         * @return This participantInfo's timeline, which is a map from timestamps (long) to MatchParticipantFrames.
         * The list is sorted in chronological order (ascending timestamps).<br>
         * May block while waiting for data.
         */
        public SortedMap<Long, MatchParticipantFrame> getTimeline() {
            return timeline.join();
        }
    }

    //region equals hashCode
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
    //endregion
}
