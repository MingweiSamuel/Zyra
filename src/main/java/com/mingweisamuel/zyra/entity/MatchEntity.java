package com.mingweisamuel.zyra.entity;

import com.google.common.collect.Lists;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.TeamId;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchFrame;
import com.mingweisamuel.zyra.match.MatchParticipantFrame;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.match.Participant;
import com.mingweisamuel.zyra.match.ParticipantIdentity;
import com.mingweisamuel.zyra.match.Player;
import com.mingweisamuel.zyra.match.TeamStats;
import com.mingweisamuel.zyra.util.LazyResetableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * A high-level representation of a match. Thread-safe.
 */
public class MatchEntity extends Entity {

    static MatchEntity create(EntityApi entityApi, Region region, long matchId, Long forAccountId) {
        return new MatchEntity(entityApi, region, matchId, forAccountId);
    }

    /** This match's unique id. Set from initialization. */
    private final long matchId;
    /** Account ID for non-public (unranked) match participant identification. */
    private final Long forAccountId;

    /** The match's general information.  */
    private final LazyResetableFuture<Match> matchInfo;
    /** The match's timeline. */
    private final LazyResetableFuture<MatchTimeline> timeline;

    /** The match's participant entities. */
    private final LazyResetableFuture<List<ParticipantEntity>> participants;

    /** The match's team entities. */
    private final LazyResetableFuture<List<TeamEntity>> teams;

    private MatchEntity(EntityApi entityApi, Region region, long matchId, Long forAccountId) {
        super(entityApi, region);
        this.matchId = matchId;
        this.forAccountId = forAccountId;

        matchInfo = new LazyResetableFuture<>(() -> entityApi.riotApi.matches.getMatchAsync(region, matchId));
        timeline = new LazyResetableFuture<>(() -> entityApi.riotApi.matches.getMatchTimelineAsync(region, matchId));
        participants = matchInfo.thenApply(m -> new ArrayList<>(Lists.transform(
            m.participantIdentities, pid -> new ParticipantEntity(
                pid.participantId, m, pid.player != null ? entityApi.getSummonerFromPlayer(pid.player) : null))));
        teams = matchInfo.thenApply(m -> new ArrayList<>(Lists.transform(m.teams, TeamEntity::new)));
    }

    /** Returns the unique match id. Does not need to wait for any tasks to complete. */
    public long getMatchId() {
        return matchId;
    }

    /**
     * Returns the account ID supplied at construction, used for non-public (unranked) match participant
     * identification.
     * @return NULL if no account ID was originally supplied.
     */
    public Long getForAccountId() {
        return forAccountId;
    }

    //region info methods
    public CompletableFuture<Match> getInfoAsync() {
        return matchInfo.get();
    }
    public Match getInfo() {
        return matchInfo.join();
    }
    //endregion

    //region timeline methods
    public CompletableFuture<MatchTimeline> getTimelineAsync() {
        return timeline.get();
    }
    public MatchTimeline getTimeline() {
        return timeline.join();
    }
    //endregion

    //region summoner methods
    public CompletableFuture<List<ParticipantEntity>> getParticipantsAsync() {
        return participants.get();
    }
    public List<ParticipantEntity> getParticipants() {
        return participants.join();
    }

    /**
     * Gets a CompletableFuture of the Participant corresponding to the given SummonerEntity. Will return {@code null}
     * if the summoner was not found. This may occur in unranked games where identity information is not available.
     * @param summonerEntity Summoner to find.
     * @return CompletableFuture of ParticipantEntity, or of {@code null} if not found.
     */
    public CompletableFuture<ParticipantEntity> getParticipantAsync(SummonerEntity summonerEntity) {
        return getParticipantsAsync().thenApply(l -> l.stream().filter(
            p -> summonerEntity.equals(p.getSummonerEntity())).findAny().orElse(null));
    }
    /**
     * Gets the Participant corresponding to the given SummonerEntity. Will return {@code null} if the summoner was
     * not found. This usually occurs in unranked games where identity information is not available and forAccountId
     * was not provided..
     * @param summonerEntity Summoner to find.
     * @return ParticipantEntity, or {@code null} if not found.
     */
    public ParticipantEntity getParticipant(SummonerEntity summonerEntity) {
        return getParticipantAsync(summonerEntity).join();
    }


    public CompletableFuture<List<TeamEntity>> getTeamsAsync() {
        return teams.get();
    }
    public List<TeamEntity> getTeams() {
        return teams.join();
    }
    //endregion

    //region TeamEntity
    /**
     * An entity representation of a team in a single match.
     */
    public class TeamEntity extends Entity {

        private final TeamStats teamStats;

        private TeamEntity(TeamStats teamStats) {
            super(MatchEntity.this.entityApi, MatchEntity.this.region);
            this.teamStats = teamStats;
        }

        public int getTeamId() {
            return teamStats.teamId;
        }

        public TeamStats getTeamStats() {
            return teamStats;
        }

        public boolean isWinner() {
            return TeamId.WIN.equals(teamStats.win);
        }

        public List<ParticipantEntity> getParticipants() {
            return MatchEntity.this.getParticipants().stream()
                .filter(p -> this.getTeamId() == p.getTeamId()).collect(Collectors.toList());
        }
    }
    //endregion

    //region ParticipantEntity
    /**
     * A entity representation of a participantInfo in a single match. May or may not be associated with a SummonerEntity.
     */
    public class ParticipantEntity extends Entity {

        private final int participantId;
        private final SummonerEntity summonerEntity;

        private final Participant participantInfo;

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
         * Gets the summoner entity who played as this participantInfo.<br><br>
         *
         * May return cached SummonerEntity instance as described in {@link EntityApi#getSummonerFromPlayer(Player)}.
         *
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
        /** @return The participant's teamId. See {@link com.mingweisamuel.zyra.enums.TeamId}. */
        public int getTeamId() {
            return participantInfo.teamId;
        }
        /** @return The participant's TeamEntity. */
        public TeamEntity getTeam() {
            return MatchEntity.this.getTeams().stream()
                .filter(t -> this.getTeamId() == t.getTeamId()).findAny().orElse(null);
        }

        /**
         * @return A CompletableFuture for this participant's timeline, which is a map from timestamps (long) to
         * MatchParticipantFrames. The map is sorted in chronological order (ascending timestamps).
         */
        public CompletableFuture<SortedMap<Long, MatchParticipantFrame>> getTimelineAsync() {
            return timeline.get();
        }
        /**
         * @return This participant's timeline, which is a map from timestamps (long) to MatchParticipantFrames.
         * The map is sorted in chronological order (ascending timestamps).<br>
         * May block while waiting for data.
         */
        public SortedMap<Long, MatchParticipantFrame> getTimeline() {
            return timeline.join();
        }
    }
    //endregion

    //region equals hashCode
    /**
     * Returns true if this MatchEntity has the same match ID and is from the same region as OTHER.
     * @param other Object to compare to.
     * @return True if equal.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        MatchEntity that = (MatchEntity) other;

        if (matchId != that.matchId) return false;
        return region.equals(that.region);
    }

    @Override
    public int hashCode() {
        int result = (int) (matchId ^ (matchId >>> 32));
        result = 31 * result + region.hashCode();
        return result;
    }
    //endregion
}
