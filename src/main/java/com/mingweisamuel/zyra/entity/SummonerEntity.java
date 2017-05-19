package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.league.LeaguePosition;
import com.mingweisamuel.zyra.masteries.MasteryPages;
import com.mingweisamuel.zyra.runes.RunePages;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.summoner.Summoner;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A high-level representation of a Summoner. Thread-safe.
 */
public class SummonerEntity extends Entity {

    static SummonerEntity create(EntityApi entityApi, Region region, long summonerId) {
        SummonerEntity entity = new SummonerEntity(entityApi, region);
        entity.summonerId.set(CompletableFuture.completedFuture(summonerId));

        initializeSummoner(entity, entityApi.riotApi.summoners.getBySummonerIdAsync(region, summonerId));

        return entity;
    }
    static SummonerEntity create(EntityApi entityApi, Region region, long summonerId, long accountId) {
        SummonerEntity entity = new SummonerEntity(entityApi, region);
        entity.summonerId.set(CompletableFuture.completedFuture(summonerId));
        entity.accountId.set(CompletableFuture.completedFuture(accountId));
        return entity;
    }
    static SummonerEntity createFromAccountId(EntityApi entityApi, Region region, long accountId) {
        SummonerEntity entity = new SummonerEntity(entityApi, region);
        entity.accountId.set(CompletableFuture.completedFuture(accountId));

        initializeSummoner(entity, entityApi.riotApi.summoners.getByAccountIdAsync(region, accountId));

        return entity;
    }
    static SummonerEntity createFromName(final EntityApi entityApi, final Region region, final String name) {
        SummonerEntity entity = new SummonerEntity(entityApi, region);
        entity.standardizedName.set(CompletableFuture.completedFuture(RiotApi.standardizeName(name)));

        initializeSummoner(entity, entityApi.riotApi.summoners.getBySummonerNameAsync(region, name));

        return entity;
    }

    private static void initializeSummoner(
            final SummonerEntity entity, final CompletableFuture<Summoner> summonerFuture) {

        final CompletableFuture<Long> summonerIdFuture = summonerFuture.thenApply(s -> s.id);
        final CompletableFuture<Long> accountIdFuture = summonerFuture.thenApply(s -> s.accountId);
        final CompletableFuture<String> standardizedNameFuture =
            summonerFuture.thenApply(s -> RiotApi.standardizeName(s.name));

        entity.summonerId.compareAndSet(null, summonerIdFuture);
        entity.accountId.compareAndSet(null, accountIdFuture);
        entity.standardizedName.compareAndSet(null, standardizedNameFuture);
        entity.summonerInfo.set(summonerFuture);

        // Resets fields on failure
        summonerFuture.exceptionally(e -> {
            entity.summonerId.compareAndSet(summonerIdFuture, null);
            entity.accountId.compareAndSet(accountIdFuture, null);
            entity.summonerInfo.compareAndSet(summonerFuture, null);
            entity.standardizedName.compareAndSet(standardizedNameFuture, null);
            entity.invalid = true;
            entity.exception = e;
            return null;
        });
    }

    /*
     * CompletableFutures are null if no data has been requested.
     * Non-null Futures indicated data has been requested.
     */

    /** Unique summoner ID, used in most endpoints. */
    private final AtomicReference<CompletableFuture<Long>> summonerId = new AtomicReference<>(null);
    /** Unique Riot account ID, used to obtain matchlist. */
    private final AtomicReference<CompletableFuture<Long>> accountId = new AtomicReference<>(null);
    /** Summoner name standardized, {@link com.mingweisamuel.zyra.RiotApi#standardizeName(String)}. */
    private final AtomicReference<CompletableFuture<String>> standardizedName = new AtomicReference<>(null);

    /** General summoner info. */
    private final AtomicReference<CompletableFuture<Summoner>> summonerInfo = new AtomicReference<>(null);

    /** Summoner champion mastery information. */
    private final AtomicReference<CompletableFuture<List<ChampionMastery>>> championMasteries =
        new AtomicReference<>(null);

    /** League position (rank). */
    private final AtomicReference<CompletableFuture<List<LeaguePosition>>> leaguePositions =
        new AtomicReference<>(null);

    /** Mastery pages. */
    private final AtomicReference<CompletableFuture<MasteryPages>> masteryPages = new AtomicReference<>(null);

    /** Rune pages. */
    private final AtomicReference<CompletableFuture<RunePages>> runePages = new AtomicReference<>(null);

    /** Current game information. */
    private final AtomicReference<CompletableFuture<CurrentGameInfo>> currentGameInfo = new AtomicReference<>(null);

    /**
     * Creates an uninitialized SummonerEntity. This constructor should not be used directly.
     * Instead use {@link #create(EntityApi, Region, long)}, {@link #createFromAccountId(EntityApi, Region, long)},
     * or {@link #createFromName(EntityApi, Region, String)}.
     *
     * @param entityApi EntityApi reference. {@link #entityApi}.
     * @param region Region this summoner exists in. {@link #region}.
     */
    private SummonerEntity(EntityApi entityApi, Region region) {
        super(entityApi, region);
    }

    // region IDs
    public CompletableFuture<Long> getSummonerIdAsync() {
        validate();
        return summonerId.get();
    }
    public long getSummonerId() {
        validate();
        return EntityApi.complete(getSummonerIdAsync());
    }

    public CompletableFuture<Long> getAccountIdAsync() {
        validate();
        return accountId.get();
    }
    public long getAccountId() {
        validate();
        return EntityApi.complete(getAccountIdAsync());
    }

    public CompletableFuture<String> getStandardizedNameAsync() {
        validate();
        return standardizedName.updateAndGet(f -> {
            if (f != null)
                return f;
            return getSummonerInfoAsync().thenApply(s -> RiotApi.standardizeName(s.name));
        });
    }
    public String getStandardizedName() {
        validate();
        return EntityApi.complete(getStandardizedNameAsync());
    }
    //endregion

    //region summonerInfo
    public CompletableFuture<Summoner> getSummonerInfoAsync() {
        validate();
        return summonerInfo.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.summoners.getBySummonerIdAsync(region, EntityApi.complete(summonerId.get()));
        });
    }
    public Summoner getSummonerInfo() {
        validate();
        return EntityApi.complete(getSummonerInfoAsync());
    }
    //endregion

    //region championMasteries
    public CompletableFuture<List<ChampionMastery>> getChampionMasteriesAsync() {
        validate();
        return championMasteries.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.championMasteries.getAllChampionMasteriesAsync(
                region, EntityApi.complete(summonerId.get()));
        });
    }
    public List<ChampionMastery> getChampionMasteries() {
        validate();
        return EntityApi.complete(getChampionMasteriesAsync());
    }
    //endregion

    //region leaguePosition
    public CompletableFuture<List<LeaguePosition>> getLeaguePositionsAsync() {
        validate();
        return leaguePositions.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.leagues.getAllLeaguePositionsForSummonerAsync(
                region, EntityApi.complete(summonerId.get()));
        });
    }
    public List<LeaguePosition> getLeaguePositions() {
        validate();
        return EntityApi.complete(getLeaguePositionsAsync());
    }
    //endregion

    //region masteryPages
    public CompletableFuture<MasteryPages> getMasteryPagesAsync() {
        validate();
        return masteryPages.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.masteries.getMasteryPagesBySummonerIdAsync(
                region, EntityApi.complete(summonerId.get()));
        });
    }
    public MasteryPages getMasteryPages() {
        validate();
        return EntityApi.complete(getMasteryPagesAsync());
    }
    //endregion

    //region runePages
    public CompletableFuture<RunePages> getRunePagesAsync() {
        validate();
        return runePages.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.runes.getRunePagesBySummonerIdAsync(region, EntityApi.complete(summonerId.get()));
        });
    }
    public RunePages getRunePages() {
        validate();
        return EntityApi.complete(getRunePagesAsync());
    }
    //endregion

    //region currentGameInfo
    public CompletableFuture<CurrentGameInfo> getCurrentGameInfoAsync() {
        validate();
        return currentGameInfo.updateAndGet(f -> {
            if (f != null)
                return f;
            return entityApi.riotApi.spectator.getCurrentGameInfoBySummonerAsync(
                region, EntityApi.complete(summonerId.get()));
        });
    }
    public CurrentGameInfo getCurrentGameInfo() {
        validate();
        return EntityApi.complete(getCurrentGameInfoAsync());
    }
    //endregion
}
