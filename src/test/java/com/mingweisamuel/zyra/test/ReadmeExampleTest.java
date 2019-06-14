package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.championMasteryV4.ChampionMastery;
import com.mingweisamuel.zyra.entity.MatchEntity;
import com.mingweisamuel.zyra.entity.SummonerEntity;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summonerV4.Summoner;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Testing the README.md examples.
 */
@Ignore("Disabled Static Data Tests.")
public class ReadmeExampleTest extends EntityTest {

    @Test
    public void summonerChampionMasteryStandardTest() {

//        // get champion data (ignoring version, data) by champion encId
//        ChampionList champList = api.staticData.getChampionList(Region.NA, null, true);
//        Map<String, Champion> champs = champList.data;

        // get summoners by name
        List<Summoner> summoners = Arrays.asList(
            api.summonersV4.getBySummonerName(Region.NA, "c9 Sneaky"),
            api.summonersV4.getBySummonerName(Region.NA, "double LIFT"));

        for (Summoner summoner : summoners) {
            System.out.println(summoner.name + "'s Top 10 Champs:");
            // get top 10 champs by mastery for each summoner
            List<ChampionMastery> masteries =
                api.championMasteriesV4.getAllChampionMasteries(Region.NA, summoner.id);

            for (int i = 0; i < 10; i++) {
                ChampionMastery mastery = masteries.get(i);
                // get champion for this mastery
                //Champion champ = champs.get("" + mastery.championId);
                // print i, champ name, champ mastery points, and champ level
                System.out.printf("%3d) %-16s %,7d (%d)%n", i + 1, mastery.championId,
                    mastery.championPoints, mastery.championLevel);
            }
            System.out.println();
        }
    }

    @Test
    public void summonerChampionMasteryEntityTest() {

//        // get champion data (ignoring version, data) by champion encId
//        ChampionList champList =
//            api.staticData.getChampionList(Region.NA, null, true);
//        Map<String, Champion> champs = champList.data;


        List<SummonerEntity> summoners = Arrays.asList(
            eApi.getSummonerByName(Region.NA, "c9 Sneaky"),
            eApi.getSummonerByName(Region.NA, "double LIFT"));

        // Pre-load summoner info (name) and champion masteries. Pre-loading
        // information allows requests to be sent in parallel.
        summoners.forEach(SummonerEntity::getSummonerInfoAsync);
        summoners.forEach(SummonerEntity::getChampionMasteriesAsync);

        summoners.forEach(summoner -> {
            System.out.println(summoner.getSummonerInfo().name + "'s Top 10 Champs:");

            for (int i = 0; i < 10; i++) {
                ChampionMastery mastery = summoner.getChampionMasteries().get(i);
//                Champion champ = champs.get("" + mastery.championId);
                System.out.printf("%3d) %-16s %,7d (%d)%n", i + 1, mastery.championId,
                    mastery.championPoints, mastery.championLevel);
            }
            System.out.println();
        });
    }

    @Test
    public void summonerMatchHistoryEntityTest() {

//        // get champion data (ignoring version, data) by champion encId
//        ChampionList champList =
//            api.staticData.getChampionList(Region.NA, null, true);
//        Map<String, Champion> champs = champList.data;

        SummonerEntity summoner = eApi.getSummonerByName(Region.NA, "imaqtpie");

        // pre-load info for recent each matches
        summoner.getMatchQueryEntitiesAsync().thenAccept(l -> l.forEach(MatchEntity::getInfoAsync));

        System.out.println(summoner.getSummonerInfo().name + "'s Recent Ranked Matches:");
        int count = 1;
        for (int i = 0; i < summoner.getMatchQueryEntities().size(); i++) {

            MatchEntity match = summoner.getMatchQueryEntities().get(i);
            MatchEntity.ParticipantEntity participant = match.getParticipant(summoner);
            if (participant == null) // unranked game -> no encId info
                continue;

            System.out.printf("%3d) %-16s %-4s (%2.0fm)%n", count++,
                participant.getParticipantInfo().championId,
//                champs.get("" + participant.getParticipantInfo().championId).name,
                participant.getTeam().isWinner() ? "Win" : "Loss",
                match.getInfo().gameDuration / 60.0);
        }
    }
}
