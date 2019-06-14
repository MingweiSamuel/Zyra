package com.mingweisamuel.zyra.entity;

import com.google.common.collect.Lists;
import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.championMasteryV4.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.leagueV4.LeaguePosition;
import com.mingweisamuel.zyra.matchV4.Matchlist;
import com.mingweisamuel.zyra.spectatorV4.CurrentGameInfo;
import com.mingweisamuel.zyra.summonerV4.Summoner;
import com.mingweisamuel.zyra.util.LazyResetableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * A high-level representation of a Summoner. Thread-safe.
 */
public class SummonerEntity extends Entity {

    //region static constructors
    static SummonerEntity create(EntityApi entityApi, Region region, String summonerIdEnc) {
        LazyResetableFuture<Summoner> summonerFuture = new LazyResetableFuture<>(() ->
            entityApi.riotApi.summonersV4.getBySummonerIdAsync(region, summonerIdEnc));
        LazyResetableFuture<String> summonerIdFuture = LazyResetableFuture.completedFuture(summonerIdEnc);
        LazyResetableFuture<String> accountIdFuture = summonerFuture.thenApply(s -> s.accountId);
        LazyResetableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, String summonerIdEnc, String accountIdEnc) {
        LazyResetableFuture<Summoner> summonerFuture = new LazyResetableFuture<>(() ->
            entityApi.riotApi.summonersV4.getBySummonerIdAsync(region, summonerIdEnc));
        LazyResetableFuture<String> summonerIdFuture = LazyResetableFuture.completedFuture(summonerIdEnc);
        LazyResetableFuture<String> accountIdFuture = LazyResetableFuture.completedFuture(accountIdEnc);
        LazyResetableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, String summonerIdEnc, String accountIdEnc, String name) {
        LazyResetableFuture<Summoner> summonerFuture = new LazyResetableFuture<>(() ->
            entityApi.riotApi.summonersV4.getBySummonerIdAsync(region, summonerIdEnc));
        LazyResetableFuture<String> summonerIdFuture = LazyResetableFuture.completedFuture(summonerIdEnc);
        LazyResetableFuture<String> accountIdFuture = LazyResetableFuture.completedFuture(accountIdEnc);
        LazyResetableFuture<String> standardizedNameFuture =
            LazyResetableFuture.completedFuture(RiotApi.standardizeName(name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, Summoner summoner) {
        LazyResetableFuture<Summoner> summonerFuture = LazyResetableFuture.completedFuture(summoner);
        LazyResetableFuture<String> summonerIdFuture = LazyResetableFuture.completedFuture(summoner.id);
        LazyResetableFuture<String> accountIdFuture = LazyResetableFuture.completedFuture(summoner.accountId);
        LazyResetableFuture<String> standardizedNameFuture =
            LazyResetableFuture.completedFuture(RiotApi.standardizeName(summoner.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity createFromAccountId(EntityApi entityApi, Region region, String accountIdEnc) {
        LazyResetableFuture<Summoner> summonerFuture = new LazyResetableFuture<>(() ->
            entityApi.riotApi.summonersV4.getByAccountIdAsync(region, accountIdEnc));
        LazyResetableFuture<String> summonerIdFuture = summonerFuture.thenApply(s -> s.id);
        LazyResetableFuture<String> accountIdFuture = LazyResetableFuture.completedFuture(accountIdEnc);
        LazyResetableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity createFromName(EntityApi entityApi, Region region, String name) {
        LazyResetableFuture<Summoner> summonerFuture = new LazyResetableFuture<>(() ->
            entityApi.riotApi.summonersV4.getBySummonerNameAsync(region, name));
        LazyResetableFuture<String> summonerIdFuture = summonerFuture.thenApply(s -> s.id);
        LazyResetableFuture<String> accountIdFuture = summonerFuture.thenApply(s -> s.accountId);
        LazyResetableFuture<String> standardizedNameFuture =
            LazyResetableFuture.completedFuture(RiotApi.standardizeName(name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    //endregion

    /** Unique summoner ID, used in most endpoints. */
    private final LazyResetableFuture<String> summonerIdEnc;
    /** Unique Riot account ID, used to obtain matchlist. */
    private final LazyResetableFuture<String> accountIdEnc;
    /** Summoner name standardized, {@link com.mingweisamuel.zyra.RiotApi#standardizeName(String)}. */
    private final LazyResetableFuture<String> standardizedName;

    /** General summoner info. */
    private final LazyResetableFuture<Summoner> summonerInfo;
    /** Summoner champion mastery information. */
    private final LazyResetableFuture<List<ChampionMastery>> championMasteries;
    /** League position (rank). */
    private final LazyResetableFuture<List<LeaguePosition>> leaguePositions;
    /** Current game information. */
    private final LazyResetableFuture<CurrentGameInfo> currentGameInfo;

    /** Lock on updating the query parameters. */
    private final Object queryLock = new Object();
    private volatile boolean queryDirty = true;
    private volatile List<Integer> queryQueues = null;
    private volatile Long queryBeginTime = null;
    private volatile Long queryEndTime = null;
    private volatile List<Integer> queryChampions = null;
    private volatile List<Integer> querySeasons = null;
    private volatile Integer queryBeginIndex = null;
    private volatile Integer queryEndIndex = null;
    /**
     * Summoner matchlist information, based on the query parameters above. Each summoner instance caches a single
     * matchlist query. Sending additional queries will overwrite the previous.
     */
    private final LazyResetableFuture<Matchlist> queryMatchlist;

    /**
     * Creates an uninitialized SummonerEntity. This constructor should not be used directly.
     * Instead use {@link #create(EntityApi, Region, String)}, {@link #createFromAccountId(EntityApi, Region, String)},
     * or {@link #createFromName(EntityApi, Region, String)}.
     *
     * @param entityApi EntityApi reference. {@link #entityApi}.
     * @param region Region this summoner exists in. {@link #region}.
     * @param summonerIdEnc
     * @param accountIdEnc
     * @param standardizedName
     */
    private SummonerEntity(EntityApi entityApi, Region region, LazyResetableFuture<Summoner> summonerInfo,
                           LazyResetableFuture<String> summonerIdEnc, LazyResetableFuture<String> accountIdEnc,
                           LazyResetableFuture<String> standardizedName) {
        super(entityApi, region);
        this.summonerInfo = summonerInfo;
        this.summonerIdEnc = summonerIdEnc;
        this.accountIdEnc = accountIdEnc;
        this.standardizedName = standardizedName;

        this.championMasteries = new LazyResetableFuture<>(() ->
            entityApi.riotApi.championMasteriesV4.getAllChampionMasteriesAsync(region, summonerIdEnc.join()));
        this.leaguePositions = new LazyResetableFuture<>(() ->
            entityApi.riotApi.leaguesV4.getAllLeaguePositionsForSummonerAsync(region, summonerIdEnc.join()));
        this.currentGameInfo = new LazyResetableFuture<>(() ->
            entityApi.riotApi.spectatorV4.getCurrentGameInfoBySummonerAsync(region, summonerIdEnc.join()));
        this.queryMatchlist = new LazyResetableFuture<>(() ->
            entityApi.riotApi.matchesV4.getMatchlistAsync(region, accountIdEnc.join(), queryChampions, queryQueues,
                querySeasons, queryBeginTime, queryEndTime, queryBeginIndex, queryEndIndex));
    }

    // region IDs
    public boolean loadedSummonerId() {
        return summonerIdEnc.created();
    }
    public CompletableFuture<String> getSummonerIdAsync() {
        return summonerIdEnc.get();
    }
    public String getSummonerIdEnc() {
        return summonerIdEnc.join();
    }

    public boolean loadedAccountId() {
        return accountIdEnc.created();
    }
    public CompletableFuture<String> getAccountIdAsync() {
        return accountIdEnc.get();
    }
    public String getAccountIdEnc() {
        return accountIdEnc.join();
    }

    public CompletableFuture<String> getStandardizedNameAsync() {
        return standardizedName.get();
    }
    public String getStandardizedName() {
        return standardizedName.join();
    }
    //endregion

    //region summonerInfo
    public boolean loadedSummonerInfo() {
        return summonerInfo.isDone();
    }
    public CompletableFuture<Summoner> getSummonerInfoAsync() {
        return summonerInfo.get();
    }
    public Summoner getSummonerInfo() {
        return summonerInfo.join();
    }
    public void resetSummonerInfo() {
        summonerInfo.reset();
    }
    //endregion

    //region championMasteries
    public boolean loadedChampionMasteries() {
        return championMasteries.isDone();
    }
    public CompletableFuture<List<ChampionMastery>> getChampionMasteriesAsync() {
        return championMasteries.get();
    }
    public List<ChampionMastery> getChampionMasteries() {
        return championMasteries.join();
    }
    public void resetChampionMasteries() {
        championMasteries.reset();
    }
    //endregion

    //region leaguePosition
    public boolean loadedLeaguePositions() {
        return leaguePositions.isDone();
    }
    public CompletableFuture<List<LeaguePosition>> getLeaguePositionsAsync() {
        return leaguePositions.get();
    }
    public List<LeaguePosition> getLeaguePositions() {
        return leaguePositions.join();
    }
    public void resetLeaguePositions() {
        leaguePositions.reset();
    }
    //endregion

    //region currentGameInfo
    public boolean loadedCurrentGameInfo() {
        return currentGameInfo.isDone();
    }
    public CompletableFuture<CurrentGameInfo> getCurrentGameInfoAsync() {
        return currentGameInfo.get();
    }
    public CurrentGameInfo getCurrentGameInfo() {
        return currentGameInfo.join();
    }
    public void resetCurrentGameInfo() {
        currentGameInfo.reset();
    }
    //endregion

    //region matches query
    /**
     * Checks if the query is dirty. Returning true means that the match query parameters have been updated and a new
     * request must be sent to obtain the matchlists. False means that a call to {@link #getMatchQuery} or
     * {@link #getMatchQueryEntities} will return immediately.
     * @return Whether the query is dirty.
     */
    public boolean isMatchQueryDirty() {
        return queryDirty;
    }

    /**
     * Removes all query restrictions and marks the match query dirty.
     */
    public void resetMatchQuery() {
        synchronized (queryLock) {
            queryQueues = null;
            queryBeginTime = null;
            queryEndTime = null;
            queryChampions = null;
            querySeasons = null;
            queryBeginIndex = null;
            queryEndIndex = null;
        }
    }

    /**
     * Method for setting all query parameters at once.
     * @param queues
     * @param beginTime
     * @param endTime
     * @param champions
     * @param seasons
     * @param beginIndex
     * @param endIndex
     * @return Whether the query is dirty.
     */
    public boolean setMatchQueryAll(List<Integer> queues, Long beginTime, Long endTime, List<Integer> champions,
        List<Integer> seasons, Integer beginIndex, Integer endIndex) {

        synchronized (queryLock) {
            setMatchQueryQueues(queues);
            setMatchQueryTimeRange(beginTime, endTime);
            setMatchQueryChampions(champions);
            setMatchQuerySeasons(seasons);
            setMatchQueryIndexRange(beginIndex, endIndex);
            return queryDirty;
        }
    }

    /**
     * Sets the queues parameter for a match query.
     * @param queues Queue encId list, or null to remove.
     * @return Whether the query is dirty.
     */
    public boolean setMatchQueryQueues(List<Integer> queues) {
        synchronized (queryLock) {
            if (queryDirty || !Objects.equals(queryQueues, queues)) {
                queryQueues = queues;
                queryDirty = true;
            }
            return queryDirty;
        }
    }

    /**
     * Sets the begin and end time for a match query. Both bounds are inclusive.<br>
     * {@code setMatchQueryTimeRange(null, null)} will remove the time restriction.
     * @param beginTime Begin time in epoch milliseconds, or null to remove.
     * @param endTime End time in epoch milliseconds, or null to remove.
     * @return Whether the query is dirty.
     * @throws IllegalArgumentException If beginTime is greater than endTime.
     */
    public boolean setMatchQueryTimeRange(Long beginTime, Long endTime) {
        if (beginTime != null && endTime != null && beginTime > endTime) {
            throw new IllegalArgumentException(
                "Begin time (" + beginTime + ") must be less than or equal to end time (" + endTime + ").");
        }
        //noinspection Duplicates
        synchronized (queryLock) {
            if (queryDirty || !Objects.equals(queryBeginTime, beginTime)) {
                queryBeginTime = beginTime;
                queryDirty = true;
            }
            if (queryDirty || !Objects.equals(queryEndTime, endTime)) {
                queryEndTime = endTime;
                queryDirty = true;
            }
            return queryDirty;
        }
    }

    /**
     * Sets the champions for a match query.
     * @param champions Champions that summoner played in queried matches, or null to remove.
     * @return Whether the query is dirty.
     */
    public boolean setMatchQueryChampions(List<Integer> champions) {
        synchronized (queryLock) {
            if (queryDirty || !Objects.equals(queryChampions, champions)) {
                queryChampions = champions;
                queryDirty = true;
            }
            return queryDirty;
        }
    }

    /**
     * Sets the seasons for a match query.
     * @param seasons Seasons to return matches from.
     * @return Whether the query is dirty.
     */
    public boolean setMatchQuerySeasons(List<Integer> seasons) {
        synchronized (queryLock) {
            if (queryDirty || !Objects.equals(querySeasons, seasons)) {
                querySeasons = seasons;
                queryDirty = true;
            }
            return queryDirty;
        }
    }

    /**
     * Sets the begin and end indices for a match query. Range bounds are inclusive (probably).<br>
     * {@code setMatchQueryIndexRange(null, null)} will remove the index restriction.
     * @param beginIndex Begin index, or null to remove.
     * @param endIndex End index, or null to remove.
     * @return Whether the query is dirty.
     * @throws IllegalArgumentException If beginIndex is greater than endIndex.
     */
    public boolean setMatchQueryIndexRange(Integer beginIndex, Integer endIndex) {
        if (beginIndex != null && endIndex != null && beginIndex > endIndex) {
            throw new IllegalArgumentException(
                "Begin index (" + beginIndex + ") must be less than or equal to end index (" + endIndex + ").");
        }
        //noinspection Duplicates
        synchronized (queryLock) {
            if (queryDirty || !Objects.equals(queryBeginIndex, beginIndex)) {
                queryBeginIndex = beginIndex;
                queryDirty = true;
            }
            if (queryDirty || !Objects.equals(queryEndIndex, endIndex)) {
                queryEndIndex = endIndex;
                queryDirty = true;
            }
            return queryDirty;
        }
    }

    /**
     * @return Whether the match query is not dirty and has been loaded.
     */
    public boolean loadedMatchQuery() {
        return !queryDirty && queryMatchlist.isDone();
    }

    /**
     * Queries matches with the parameters set by {@code setMatchQuery***} methods. Only sends a new request if the
     * query is marked dirty (parameters have been updated).
     * @return A CompletableFuture of the Matchlist.
     */
    public CompletableFuture<Matchlist> getMatchQueryAsync() {
        synchronized (queryLock) {
            if (queryDirty)
                queryMatchlist.reset();
            queryDirty = false;
            return queryMatchlist.get();
        }
    }
    /**
     * Queries matches with the parameters set by {@code setMatchQuery***} methods. Only sends a new request if the
     * query is marked dirty (parameters have been updated).
     * @return The Matchlist.
     */
    public Matchlist getMatchQuery() {
        return getMatchQueryAsync().join();
    }

    /**
     * Queries matches with the parameters set by {@code setMatchQuery***} methods. Only sends a new request if the
     * query is marked dirty (parameters have been updated).<br><br>
     *
     * May returned cached instances as described in {@link EntityApi#getMatch}.
     *
     * @return A CompletableFuture of the List of MatchEntities.
     */
    public CompletableFuture<List<MatchEntity>> getMatchQueryEntitiesAsync() {
        return getMatchQueryAsync().thenApply(this::matchlistToMatches);
    }
    /**
     * Queries matches with the parameters set by {@code setMatchQuery***} methods. Only sends a new request if the
     * query is marked dirty (parameters have been updated).<br><br>
     *
     * May returned cached instances as described in {@link EntityApi#getMatch}.
     *
     * @return The List of MatchEntities.
     */
    public List<MatchEntity> getMatchQueryEntities() {
        return matchlistToMatches(getMatchQuery());
    }
    //endregion

    private List<MatchEntity> matchlistToMatches(Matchlist ml) {
        return new ArrayList<>(
            ml.matches.stream().map(m -> entityApi.getMatch(region, m.gameId, accountIdEnc.join()))
                .collect(Collectors.toList()));
    }

    //region equals hashCode

    /**
     * Checks that this SummonerEntity is from the same region and has the same summoner ID as OTHER. Will load the
     * summoner IDs if needed.
     * @param other Object to compare to.
     * @return True if equal.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        SummonerEntity entity = (SummonerEntity) other;

        if (getSummonerIdEnc() != entity.getSummonerIdEnc()) return false;
        return getRegion() == entity.getRegion();
    }

    /**
     * Returns a hashed-sized version of this SummonerEntitiy's summoner ID with the summoner region. Will load the
     * summoner ID if needed.
     * @return Summoner ID hash.
     */
    @Override
    public int hashCode() {
        return 31 * getSummonerIdEnc().hashCode() + region.hashCode();
    }

    //endregion
}
