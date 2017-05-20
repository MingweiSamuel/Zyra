package com.mingweisamuel.zyra.entity;

import com.google.common.collect.Lists;
import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.league.LeaguePosition;
import com.mingweisamuel.zyra.masteries.MasteryPages;
import com.mingweisamuel.zyra.match.Matchlist;
import com.mingweisamuel.zyra.match.Player;
import com.mingweisamuel.zyra.runes.RunePages;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.summoner.Summoner;
import com.mingweisamuel.zyra.util.AsyncUtils;
import com.mingweisamuel.zyra.util.LazyRetryable;
import com.mingweisamuel.zyra.util.LazyRetryableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A high-level representation of a Summoner. Thread-safe.
 */
public class SummonerEntity extends Entity {

    //region static constructors
    static SummonerEntity create(EntityApi entityApi, Region region, long summonerId) {
        LazyRetryableFuture<Summoner> summonerFuture = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.summoners.getBySummonerIdAsync(region, summonerId));
        LazyRetryableFuture<Long> summonerIdFuture = LazyRetryableFuture.completedFuture(summonerId);
        LazyRetryableFuture<Long> accountIdFuture = summonerFuture.thenApply(s -> s.accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, long summonerId, long accountId) {
        LazyRetryableFuture<Summoner> summonerFuture = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.summoners.getBySummonerIdAsync(region, summonerId));
        LazyRetryableFuture<Long> summonerIdFuture = LazyRetryableFuture.completedFuture(summonerId);
        LazyRetryableFuture<Long> accountIdFuture = LazyRetryableFuture.completedFuture(accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, long summonerId, long accountId, String name) {
        LazyRetryableFuture<Summoner> summonerFuture = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.summoners.getBySummonerIdAsync(region, summonerId));
        LazyRetryableFuture<Long> summonerIdFuture = LazyRetryableFuture.completedFuture(summonerId);
        LazyRetryableFuture<Long> accountIdFuture = LazyRetryableFuture.completedFuture(accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            LazyRetryableFuture.completedFuture(RiotApi.standardizeName(name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity create(EntityApi entityApi, Region region, Summoner summoner) {
        LazyRetryableFuture<Summoner> summonerFuture = LazyRetryableFuture.completedFuture(summoner);
        LazyRetryableFuture<Long> summonerIdFuture = LazyRetryableFuture.completedFuture(summoner.id);
        LazyRetryableFuture<Long> accountIdFuture = LazyRetryableFuture.completedFuture(summoner.accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            LazyRetryableFuture.completedFuture(RiotApi.standardizeName(summoner.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity createFromAccountId(EntityApi entityApi, Region region, long accountId) {
        LazyRetryableFuture<Summoner> summonerFuture = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.summoners.getByAccountIdAsync(region, accountId));
        LazyRetryableFuture<Long> summonerIdFuture = summonerFuture.thenApply(s -> s.id);
        LazyRetryableFuture<Long> accountIdFuture = LazyRetryableFuture.completedFuture(accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity createFromName(EntityApi entityApi, Region region, String name) {
        LazyRetryableFuture<Summoner> summonerFuture = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.summoners.getBySummonerNameAsync(region, name));
        LazyRetryableFuture<Long> summonerIdFuture = summonerFuture.thenApply(s -> s.id);
        LazyRetryableFuture<Long> accountIdFuture = summonerFuture.thenApply(s -> s.accountId);
        LazyRetryableFuture<String> standardizedNameFuture =
            LazyRetryableFuture.completedFuture(RiotApi.standardizeName(name));
        return new SummonerEntity(entityApi, region, summonerFuture, summonerIdFuture,
            accountIdFuture, standardizedNameFuture);
    }
    static SummonerEntity createFromPlayer(EntityApi entityApi, Player player) {
        Region region = Region.parse(player.currentPlatformId);
        return create(entityApi, region, player.summonerId, player.currentAccountId, player.summonerName);
    }
    //endregion

    /** Unique summoner ID, used in most endpoints. */
    private final LazyRetryableFuture<Long> summonerId;
    /** Unique Riot account ID, used to obtain matchlist. */
    private final LazyRetryableFuture<Long> accountId;
    /** Summoner name standardized, {@link com.mingweisamuel.zyra.RiotApi#standardizeName(String)}. */
    private final LazyRetryableFuture<String> standardizedName;

    /** General summoner info. */
    private final LazyRetryableFuture<Summoner> summonerInfo;
    /** Summoner champion mastery information. */
    private final LazyRetryableFuture<List<ChampionMastery>> championMasteries;
    /** League position (rank). */
    private final LazyRetryableFuture<List<LeaguePosition>> leaguePositions;
    /** Mastery pages. */
    private final LazyRetryableFuture<MasteryPages> masteryPages;
    /** Rune pages. */
    private final LazyRetryableFuture<RunePages> runePages;
    /** Current game information. */
    private final LazyRetryableFuture<CurrentGameInfo> currentGameInfo;
    /** Recent match list information. */
    private final LazyRetryableFuture<Matchlist> recentMatchlist;

    /**
     * Creates an uninitialized SummonerEntity. This constructor should not be used directly.
     * Instead use {@link #create(EntityApi, Region, long)}, {@link #createFromAccountId(EntityApi, Region, long)},
     * or {@link #createFromName(EntityApi, Region, String)}.
     *
     * @param entityApi EntityApi reference. {@link #entityApi}.
     * @param region Region this summoner exists in. {@link #region}.
     * @param summonerId
     * @param accountId
     * @param standardizedName
     */
    private SummonerEntity(EntityApi entityApi, Region region, LazyRetryableFuture<Summoner> summonerInfo,
            LazyRetryableFuture<Long> summonerId, LazyRetryableFuture<Long> accountId,
            LazyRetryableFuture<String> standardizedName) {
        super(entityApi, region);
        this.summonerInfo = summonerInfo;
        this.summonerId = summonerId;
        this.accountId = accountId;
        this.standardizedName = standardizedName;

        this.championMasteries = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.championMasteries.getAllChampionMasteriesAsync(region, summonerId.getSync()));
        this.leaguePositions = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.leagues.getAllLeaguePositionsForSummonerAsync(region, summonerId.getSync()));
        this.masteryPages = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.masteries.getMasteryPagesBySummonerIdAsync(region, summonerId.getSync()));
        this.runePages = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.runes.getRunePagesBySummonerIdAsync(region, summonerId.getSync()));
        this.currentGameInfo = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.spectator.getCurrentGameInfoBySummonerAsync(region, summonerId.getSync()));
        this.recentMatchlist = new LazyRetryableFuture<>(() ->
            entityApi.riotApi.matches.getRecentMatchlistAsync(region, accountId.getSync()));
    }

    // region IDs
    public boolean hasLoadedSummonerId() {
        return summonerId.created();
    }
    public CompletableFuture<Long> getSummonerIdAsync() {
        return summonerId.get();
    }
    public long getSummonerId() {
        return summonerId.getSync();
    }

    public boolean hasLoadedAccountId() {
        return accountId.created();
    }
    public CompletableFuture<Long> getAccountIdAsync() {
        return accountId.get();
    }
    public long getAccountId() {
        return accountId.getSync();
    }

    public CompletableFuture<String> getStandardizedNameAsync() {
        return standardizedName.get();
    }
    public String getStandardizedName() {
        return standardizedName.getSync();
    }
    //endregion

    //region summonerInfo
    public CompletableFuture<Summoner> getSummonerInfoAsync() {
        return summonerInfo.get();
    }
    public Summoner getSummonerInfo() {
        return summonerInfo.getSync();
    }
    //endregion

    //region championMasteries
    public CompletableFuture<List<ChampionMastery>> getChampionMasteriesAsync() {
        return championMasteries.get();
    }
    public List<ChampionMastery> getChampionMasteries() {
        return championMasteries.getSync();
    }
    //endregion

    //region leaguePosition
    public CompletableFuture<List<LeaguePosition>> getLeaguePositionsAsync() {
        return leaguePositions.get();
    }
    public List<LeaguePosition> getLeaguePositions() {
        return leaguePositions.getSync();
    }
    //endregion

    //region masteryPages
    public CompletableFuture<MasteryPages> getMasteryPagesAsync() {
        return masteryPages.get();
    }
    public MasteryPages getMasteryPages() {
        return masteryPages.getSync();
    }
    //endregion

    //region runePages
    public CompletableFuture<RunePages> getRunePagesAsync() {
        return runePages.get();
    }
    public RunePages getRunePages() {
        return runePages.getSync();
    }
    //endregion

    //region currentGameInfo
    public CompletableFuture<CurrentGameInfo> getCurrentGameInfoAsync() {
        return currentGameInfo.get();
    }
    public CurrentGameInfo getCurrentGameInfo() {
        return currentGameInfo.getSync();
    }
    //endregion

    //region match
    public CompletableFuture<Matchlist> getRecentMatchlistAsync() {
        return recentMatchlist.get();
    }
    public Matchlist getRecentMatchlist() {
        return recentMatchlist.getSync();
    }

    public CompletableFuture<List<MatchEntity>> getRecentMatchEntitiesAsync() {
        return getRecentMatchlistAsync().thenApply(this::getRecentMatchEntitiesHelper);
    }
    public List<MatchEntity> getRecentMatchEntities() {
        return getRecentMatchEntitiesHelper(getRecentMatchlist());
    }
    private List<MatchEntity> getRecentMatchEntitiesHelper(Matchlist ml) {
        return Lists.transform(ml.matches, m -> entityApi.getMatch(region, m.gameId));
    }
    //endregion
}
