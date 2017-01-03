package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.model.Summoner;
import com.mingweisamuel.zyra.util.RiotRequestException;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.api.LoadPolicy;
import org.junit.Test;
import org.junit.runner.Description;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Mingw on 2017-01-01.
 */
public class RiotApiTest {

    public static final RiotApi riotApi = new RiotApi("86cddb9d-e5e4-4a1e-b7eb-24d74685ef1b", 3_000, 180_000);

    // 23902591 is in there a bunch of times
    public static final List<Long> SUMMONER_IDS = Arrays.asList(
            23902591L, 19676775L, 22653737L, 21759506L, 22209505L, 29299341L, 19101354L, 22166284L, 31730794L,
            39974593L, 23902591L, 22790011L, 65450936L, 67592203L, 39637575L, 31272097L, 23460015L, 38627529L,
            23902591L, 44027682L, 20148263L, 61138162L, 52450898L, 31944743L, 22926530L, 45019487L, 19395392L,
            23902591L, 30916825L, 34141832L, 46886818L, 30994519L, 39241634L, 28169062L, 57726999L, 50925946L,
            41522929L, 31718213L, 23902591L, 24301336L, 28876579L, 21465943L, 20359176L, 18984263L, 22061503L,
            76817435L, 28900842L, 23902591L, 49777173L, 43748875L, 25537355L, 25284531L, 43748877L, 26203312L,
            33839074L, 23902591L, 59036943L, 23214917L, 42900539L, 34010653L, 19018526L, 33031228L, 45777129L,
            23902591L, 20458413L, 39682802L, 50859594L, 25518612L, 43240226L, 63932884L, 21405713L, 27551513L,
            23041221L, 23902591L, 44864177L, 22922241L, 19766814L, 24754815L, 67857142L, 24549825L, 60420048L,
            32961021L, 23902591L, 39533020L, 19294507L, 63897880L, 33420487L, 40101562L, 41146842L, 61277247L);
    public static final List<Long> SUMMONER_IDS_NA = Arrays.asList(
            56853224L, 21877410L, 22144337L, 69009277L, 40722728L, 28319157L, 77159092L, 45341132L, 36650694L,
            82149339L, 33381010L, 51381034L, 19087764L, 60544800L, 59380413L, 50920934L, 52298810L, 38263264L,
            25330484L, 25115353L, 80279104L, 47002237L, 39088002L, 28988159L, 24174663L, 41902528L, 61991531L,
            41942578L, 38316966L, 48358548L, 36532962L, 77621036L, 66703275L, 34422839L, 19558497L, 76133004L,
            43518394L, 23978044L, 39275635L, 67009764L, 26704801L, 37229205L, 65483088L, 46610073L, 448992L,
            40373423L, 71110898L, 37151932L, 53387998L, 75930405L, 20619548L, 34592061L, 20614245L, 43201319L,
            44947412L, 50849603L, 28569540L, 23853107L, 50002051L, 38288206L, 68133220L, 41654196L, 45053228L,
            32911612L, 21946137L, 36710689L, 19109411L, 77761192L, 22907209L, 54710096L, 37948506L, 38199969L,
            55326303L, 20177635L, 47705010L, 33379920L, 52661545L, 19277451L, 59307730L, 36929980L, 61932370L,
            57750327L, 46060450L, 25125819L, 47705457L, 47340397L, 44610275L, 41196565L, 70290109L, 20605383L,
            79812034L, 38300968L, 47084844L, 41324196L, 22462478L, 40915194L, 21951345L, 23477008L, 56397611L,
            46184404L, 32650574L, 42858177L, 20511587L, 51494785L, 25169287L, 22234910L, 49801055L, 46376702L,
            21915708L, 23950678L, 28970718L, 25037723L, 32399661L, 27861874L, 34101529L, 60637481L, 65399283L,
            31669196L, 44703152L, 40559366L, 28621660L, 75093486L, 39285011L, 400709L, 38699527L, 20885819L,
            20317444L, 22111938L, 23744534L, 20388231L, 46335433L, 53888492L, 49801203L, 40402138L, 73500340L,
            35351972L, 24087242L, 50696957L, 41994456L, 46295517L, 59513358L, 43492737L, 32801742L, 50659955L,
            48357053L, 64980052L, 35356700L, 32369310L, 21791152L, 19936581L, 59648632L, 51704376L, 21791152L,
            51773003L, 72581269L, 52437556L, 37292543L, 45696440L, 76730784L, 78009297L, 53262982L, 47690838L,
            20933246L, 56882721L, 59748800L, 47768697L, 65543134L, 25065754L, 66283580L, 23374451L, 36763947L,
            34787425L, 60317023L, 42109668L, 43916081L, 22840789L, 53109942L, 22004021L, 35230674L, 24331103L,
            52367720L, 81109183L, 44663262L, 46256845L, 27893802L, 23605266L, 51615000L, 47776675L, 39926778L,
            44735146L, 25284484L, 51630907L, 65433694L, 51678789L, 41943342L, 27771825L, 35559955L, 69259488L,
            26154025L, 21749757L, 79821400L, 35439341L, 48064725L, 34095086L, 73879663L, 53434184L, 33062292L,
            49909407L, 23162807L, 39882129L, 37927419L, 422327L, 69902298L, 28790379L, 69479562L, 43562329L,
            67871725L, 66030459L, 46295311L, 48077461L, 29522533L, 31801312L, 71400744L, 45655111L, 24922726L,
            70059928L, 22686010L, 79239769L, 52511066L, 19569917L, 26177164L, 34894959L, 47210310L, 24293244L,
            26469433L, 59480058L, 47639865L, 34451293L, 70001003L, 47647593L, 36962460L, 43968171L, 32277442L,
            30156620L, 20570121L, 24320684L, 66910424L, 43866454L, 32764312L, 31563365L, 19338136L, 39749809L,
            44212194L, 52220255L, 66279639L, 65720338L, 46343692L, 56993403L, 37307396L, 65079653L, 49729612L,
            50801725L, 37272250L, 47598826L, 68823488L, 60193615L, 81763768L, 69472977L, 23972451L, 26319844L,
            29657875L, 69131983L, 28610732L, 47653049L, 43536262L, 69553446L, 35561929L, 28500098L, 38670147L,
            20705419L, 40396914L, 52761317L, 32649285L, 50655765L, 26376186L, 22361852L, 76681125L, 36394660L,
            71632897L, 48457918L, 40843262L, 74409868L, 24704307L, 21674425L, 47580955L, 65639816L, 37820033L,
            30753035L, 49345888L, 80069965L, 29181318L, 53059183L, 23580389L, 71632897L, 28531960L, 42251771L,
            30904141L, 47703997L, 38774677L, 59151129L, 51901079L, 27361858L, 20315905L, 20814420L, 81199273L,
            23684183L, 46054663L, 50800579L, 35397652L, 50977603L, 21122539L, 22349167L, 40759679L, 53950501L,
            62643169L, 22414895L, 48506375L, 48561270L, 81142233L, 50904659L, 64529236L, 20634880L, 34239970L,
            61189081L, 39887134L, 31957781L, 40904275L, 21953080L, 53777151L, 34211255L, 26116989L, 20054527L,
            37367244L, 43637891L, 74779258L, 29202796L, 41342787L, 71919281L, 20196959L, 20505645L, 30245681L,
            24473358L, 19881206L, 80940418L, 71021529L, 23951672L, 57320975L, 58963633L, 61231283L, 23714929L,
            19286817L, 20759936L, 66994011L, 49003663L, 30036105L, 21153960L, 45784236L, 21616932L, 43136150L,
            26241995L, 47160670L, 41330393L, 19444096L, 24220863L, 38672152L, 23348689L, 39520249L, 70009939L,
            23347389L, 58454736L, 43162079L, 50445518L, 53371182L, 47503884L, 65004940L, 49310258L, 77560157L,
            32949131L, 63169113L, 30551785L, 76182107L, 34227109L, 32770848L, 51096963L, 35331917L, 69800181L,
            35314032L, 25955159L, 53457829L, 28907087L, 25089089L, 24478890L, 40444609L, 43214043L, 24616036L);
    public static final Map<Long, String> expectedNames = new HashMap<>();
    static {
        expectedNames.put(34141832L, "d3gvsdo");
        expectedNames.put(38627529L, "ThaKinetic");
        expectedNames.put(24754815L, "ZalokaR");
        expectedNames.put(39533020L, "EnchantedSpike");
        expectedNames.put(41522929L, "Press RR");
        expectedNames.put(19101354L, "JamboJambo");
        expectedNames.put(59036943L, "Sliten");
        expectedNames.put(32961021L, "0A Vex");
        expectedNames.put(67592203L, "VForKalista");
        expectedNames.put(19294507L, "Senék");
        expectedNames.put(30916825L, "chat off");
        expectedNames.put(31730794L, "T0mbs");
        expectedNames.put(30994519L, "Monkeyvillage");
        expectedNames.put(76817435L, "Guztavo");
        expectedNames.put(43748875L, "Zero Ten Special");
        expectedNames.put(21465943L, "Rückenschmerzen");
        expectedNames.put(25518612L, "mydona");
        expectedNames.put(23902591L, "Hüxün");
        expectedNames.put(20148263L, "Vødkah");
        expectedNames.put(20458413L, "Bobsteal");
        expectedNames.put(43748877L, "joy with a gun ");
        expectedNames.put(61277247L, "MacaroniCake");
        expectedNames.put(23041221L, "Les Brusk");
        expectedNames.put(39637575L, "mikele1997");
        expectedNames.put(34010653L, "flex l0rd");
        expectedNames.put(63932884L, "xMebo");
        expectedNames.put(28876579L, "El Bananero");
        expectedNames.put(44864177L, "Luxuriate");
        expectedNames.put(22926530L, "Paxwell");
        expectedNames.put(22790011L, "besni leptir");
        expectedNames.put(39974593L, "uNluckY WallAce");
        expectedNames.put(31718213L, "pfulius");
        expectedNames.put(23214917L, "Leodraken");
        expectedNames.put(41146842L, "A Girl is No One");
        expectedNames.put(39682802L, "Q174");
        expectedNames.put(43240226L, "CJzor1337");
        expectedNames.put(29299341L, "D4rKAn1mA");
        expectedNames.put(25284531L, "knoxiebbz");
        expectedNames.put(22209505L, "The 4th Legend");
        expectedNames.put(19766814L, "EvilTimeBug");
        expectedNames.put(42900539L, "FluffyCup");
        expectedNames.put(24549825L, "BlazingNova");
        expectedNames.put(33420487L, "BoostedAnimaaal");
        expectedNames.put(19018526L, "chillerjon");
        expectedNames.put(44027682L, "Level 7 Fiora");
        expectedNames.put(27551513L, "Sandman226");
        expectedNames.put(20359176L, "Jadi");
        expectedNames.put(26203312L, "Klygron");
        expectedNames.put(31944743L, "Septic Finger");
        expectedNames.put(50859594L, "gniK Kledgendary");
        expectedNames.put(33031228L, "Unreformed Matti");
        expectedNames.put(60420048L, "Nyan Kat");
        expectedNames.put(23460015L, "Ironíc");
        expectedNames.put(19676775L, "Huikkeli");
        expectedNames.put(28169062L, "iEvoile");
        expectedNames.put(25537355L, "Always Moaning");
        expectedNames.put(28900842L, "KebapRocker");
        expectedNames.put(45777129L, "Pruttologen");
        expectedNames.put(61138162L, "Vayne Only xD");
        expectedNames.put(21405713L, "ButWhyMe");
        expectedNames.put(63897880L, "ißeast");
        expectedNames.put(40101562L, "Šerious Lee");
        expectedNames.put(22922241L, "999999");
        expectedNames.put(65450936L, "InSoAlWeTrust");
        expectedNames.put(21759506L, "Masvell");
        expectedNames.put(22166284L, "MamBoBamos");
        expectedNames.put(49777173L, "Potion Shop");
        expectedNames.put(18984263L, "Wyburn");
        expectedNames.put(33839074L, "TiltedAids");
        expectedNames.put(19395392L, "KingBronko");
        expectedNames.put(57726999L, "Cthlulu");
        expectedNames.put(46886818L, "vipkossEUW");
        expectedNames.put(24301336L, "127 II StPO");
        expectedNames.put(22061503L, "The Vegan God");
        expectedNames.put(22653737L, "poppego");
        expectedNames.put(45019487L, "Matsyboy");
        expectedNames.put(52450898L, "PF Chang Himself");
        expectedNames.put(50925946L, "LelushLamperysh");
        expectedNames.put(39241634L, "Synergizing");
        expectedNames.put(31272097L, "Rikudö");
        expectedNames.put(67857142L, "cutice");
    }

    @Test
    public void getSummmoner_Orianna() {
        RiotAPI.setLoadPolicy(LoadPolicy.LAZY);
        RiotAPI.setRegion(com.robrua.orianna.type.core.common.Region.NA);
        RiotAPI.setAPIKey("86cddb9d-e5e4-4a1e-b7eb-24d74685ef1b");

        com.robrua.orianna.type.core.summoner.Summoner summoner = RiotAPI.getSummonerByID(69009277L);
        assertEquals("LugnutsK", summoner.getName());
    }

    @Test
    public void getSummonersOrianna() {
        RiotAPI.setLoadPolicy(LoadPolicy.LAZY);
        RiotAPI.setRegion(com.robrua.orianna.type.core.common.Region.NA);
        RiotAPI.setAPIKey("86cddb9d-e5e4-4a1e-b7eb-24d74685ef1b");

        List<com.robrua.orianna.type.core.summoner.Summoner> summoners =
                RiotAPI.getSummonersByID(SUMMONER_IDS_NA);

//        assertEquals(expectedNames.size(), summoners.size());
//        for (com.robrua.orianna.type.core.summoner.Summoner summoner : summoners) {
//            assertEquals(expectedNames.get(summoner.getID()), summoner.getName());
//        }
    }

    @Test
    public void getSummoners_() throws RiotRequestException {
        Map<Long, Summoner> summoners = riotApi.getSummoners(Region.NA, SUMMONER_IDS_NA);
//        assertEquals("Wrong number of summoners fetched", expectedNames.size(), summoners.size());
//        for (Map.Entry<Long, Summoner> kvp : summoners.entrySet()) {
//            assertEquals("Summoner wrong name. Id: " + kvp.getKey(),
//                    expectedNames.get(kvp.getKey()), kvp.getValue().name);
//        }
    }

    @Test
    public void getSummoners() throws RiotRequestException {
        Map<Long, Summoner> summoners = riotApi.getSummoners(Region.NA, SUMMONER_IDS_NA);
//        assertEquals("Wrong number of summoners fetched", expectedNames.size(), summoners.size());
//        for (Map.Entry<Long, Summoner> kvp : summoners.entrySet()) {
//            assertEquals("Summoner wrong name. Id: " + kvp.getKey(),
//                    expectedNames.get(kvp.getKey()), kvp.getValue().name);
//        }
    }

    @Test
    public void getSummonersAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Map<Long, Summoner>> task = riotApi.getSummonersAsync(Region.NA, SUMMONER_IDS_NA);
        task.thenAccept(summoners -> {
//            assertEquals("Wrong number of summoners fetched", expectedNames.size(), summoners.size());
//            for (Map.Entry<Long, Summoner> kvp : summoners.entrySet()) {
//                assertEquals("Summoner wrong name. Id: " + kvp.getKey(),
//                        expectedNames.get(kvp.getKey()), kvp.getValue().name);
//            }
        }).get();
    }
}
