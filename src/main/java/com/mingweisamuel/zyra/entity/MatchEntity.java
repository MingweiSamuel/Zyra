package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.match.Participant;
import com.mingweisamuel.zyra.match.ParticipantIdentity;
import com.mingweisamuel.zyra.match.TeamStats;
import com.mingweisamuel.zyra.util.AsyncUtils;
import com.mingweisamuel.zyra.util.LazyRetryableFuture;

import java.util.ArrayList;
import java.util.List;
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
    private final LazyRetryableFuture<Match> matchInfo;
    /** The match's timeline. */
    private final LazyRetryableFuture<MatchTimeline> timeline;

    /** The match's participant entities. */
    private final LazyRetryableFuture<List<ParticipantEntity>> participants;

    private MatchEntity(EntityApi entityApi, Region region, long matchId) {
        super(entityApi, region);
        this.matchId = matchId;

        matchInfo = new LazyRetryableFuture<>(() -> entityApi.riotApi.matches.getMatchAsync(region, matchId));
        timeline = new LazyRetryableFuture<>(() -> entityApi.riotApi.matches.getMatchTimelineAsync(region, matchId));
        participants = matchInfo.thenApply(m -> {
            List<ParticipantEntity> result = new ArrayList<>(m.participantIdentities.size());
            for (ParticipantIdentity pid : m.participantIdentities)
                result.add(new ParticipantEntity(pid.participantId,
                    pid.player != null ? entityApi.getSummonerFromPlayer(pid.player) : null));
            return result;
        });
    }

    /** Returns the unique match id. Does not need to wait for any tasks to complete. */
    public long getMatchId() {
        return matchId;
    }

    //region info
    public CompletableFuture<Match> getInfoAsync() {
        validate();
        return matchInfo.get();
    }
    public Match getInfo() {
        validate();
        return AsyncUtils.complete(getInfoAsync());
    }
    //endregion

    //region timeline
    public CompletableFuture<MatchTimeline> getTimelineAsync() {
        validate();
        return timeline.get();
    }
    public MatchTimeline getTimeline() {
        validate();
        return AsyncUtils.complete(getTimelineAsync());
    }
    //endregion

    //region summoners
    public CompletableFuture<List<ParticipantEntity>> getParticipantsAsync() {
        validate();
        return participants.get();
    }
    public List<ParticipantEntity> getParticipants() {
        validate();
        return AsyncUtils.complete(getParticipantsAsync());
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
     * A entity representation of a participant in a single match. May or may not be associated with a SummonerEntity.
     */
    public class ParticipantEntity extends Entity {

        private final int participantId;
        private final SummonerEntity summonerEntity;

        private final Participant participant;

        private ParticipantEntity(int participantId) {
            this(participantId, null);
        }
        private ParticipantEntity(int participantId, SummonerEntity summonerEntity) {
            super(MatchEntity.this.entityApi, summonerEntity == null ? MatchEntity.this.region : summonerEntity.region);
            this.participantId = participantId;
            this.summonerEntity = summonerEntity;

            for (Participant participant : MatchEntity.this.getInfo().participants) {
                if (this.participantId == participant.participantId) {
                    this.participant = participant;
                    return;
                }
            }
            throw new IllegalStateException("Failed to find participant: " + participantId);
        }

        public int getParticipantId() {
            return participantId;
        }

        /**
         * Gets the summoner entity who played as this participant.
         * @return The summoner entity. May be {@code null} if summoner entity doesn't exist. This occurs when
         *      matches do not include identity information which usually means the match was unranked.
         */
        public SummonerEntity getSummonerEntity() {
            return summonerEntity;
        }

        // Does not need async because info must've been pulled for ParticipantEntities to exist. */
        public Participant getParticipant() {
            return participant;
        }
        public int getTeamId() {
            return participant.teamId;
        }
        public boolean isWinner() {
            for (TeamStats team : MatchEntity.this.getInfo().teams) {
                if (participant.teamId == team.teamId) {

                }
            }
            throw new IllegalStateException("Team for participant not found.");
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
