package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.dto.MasteryPage;
import com.mingweisamuel.zyra.dto.MasteryPages;
import com.mingweisamuel.zyra.dto.RunePage;
import com.mingweisamuel.zyra.dto.RunePages;
import com.mingweisamuel.zyra.dto.Summoner;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.SummonerEndpoints}.
 */
public class ApiSummonerTest {
    
    private static final Set<Long> summonerIds = new HashSet<>(Arrays.asList(
            56853224L,21877410L,22144337L,69009277L,40722728L,28319157L,77159092L,45341132L,36650694L,82149339L,
            33381010L,51381034L,19087764L,60544800L,59380413L,50920934L,52298810L,38263264L,25330484L,25115353L,
            80279104L,47002237L,39088002L,28988159L,24174663L,41902528L,61991531L,41942578L,38316966L,48358548L,
            36532962L,77621036L,66703275L,34422839L,19558497L,76133004L,43518394L,23978044L,39275635L,67009764L,
            26704801L,37229205L,65483088L,46610073L,448992L,40373423L,71110898L,37151932L,53387998L,75930405L,
            20619548L,34592061L,20614245L,43201319L,44947412L,50849603L,28569540L,23853107L,50002051L,38288206L,
            68133220L,41654196L,45053228L,32911612L,21946137L,36710689L,19109411L,77761192L,22907209L,54710096L,
            37948506L,38199969L,55326303L,20177635L,47705010L,33379920L,52661545L,19277451L,59307730L,36929980L,
            61932370L,57750327L,46060450L,25125819L,47705457L,47340397L,44610275L,41196565L,70290109L,20605383L,
            79812034L,38300968L,47084844L,41324196L,22462478L,40915194L,21951345L,23477008L,56397611L,46184404L,
            32650574L,42858177L,20511587L,51494785L,25169287L,22234910L,49801055L,46376702L,21915708L,23950678L,
            28970718L,25037723L,32399661L,27861874L,34101529L,60637481L,65399283L,31669196L,44703152L,40559366L));
    private static final Set<String> summonerNames = new HashSet<>(Arrays.asList(
            "1mìnhtaochaphet","rafamundez","afgsfg","spookymemes","worr","hwasin","magicalboy","deliciousasada",
            "darvyy","secretlyasian","meepmyselfandi","cogslee","critznscriptz","deadpoolsaiyan","vongolassky",
            "apizzaguy","lucasisazombie","creezlo","bansensei","bombizaway","forest203","krackzboi","dubtownusa",
            "kwamena4","kennytime44","mach0man","edwing","dmob18","handied","awsomered5","reihko","made4dance",
            "slogar561","siryodaa","porks","pabloflexcobar","iamriley","a55holebeaman","dim2a","mastlower",
            "killerpoisonxz","dinoobsaur","thezealousking","manboobs","craz3yman","flaysfordayz","newtocarrying",
            "ianafeeder","ripset","apotatoechip","hanwei11","hismaster","letshopeshewas16","cradar","blue3night",
            "voidzix","šnöw","dtanhero","tobewitheredrm","snowboots","supacash","thotslayer","lugnutsk","shadowvapour",
            "makeyomamagowoo","presdjtrump","marty726","leagueofrandy","terannical","tgisaturday","hobobaseek",
            "joyfull","dgr33n","midsdivineking","mistagamenwatch","sailor","twr3ck","sktt1bangu","godsusedcondom",
            "sunoo","r43dtdevilkill","davesteezy","heisenberg","wangasaurous","fucc","chetmaytrua","dimoltobene",
            "maxlegendalan","alaron94","ashbeeq","theorcaman69","falfrius","nikstykal","sentientpotato","persies",
            "bennykillsany","imhereguys","bybbye","carnakable","mxthief","weieu","hemroidz","itzbacon","ldemiguisel",
            "leitharian","cheffayette","otturbear","crxn","rulezoverall","agekage","peacepark","ferbensojo","brokevin",
            "rycebowl","n00bski","axo","sssangelbeats","ubathetroll","matt2chainz","harleyquinnie"));

    @Test
    public void get() throws ExecutionException {
        checkGet(api.summoners.get(Region.NA, summonerIds));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.summoners.getAsync(Region.NA, summonerIds).thenAccept(this::checkGet).get();
    }
    private void checkGet(Map<Long, Summoner> summoners) {
        assertEquals(summonerIds, summoners.keySet());
        assertEquals(summonerNames.size(), summoners.size());
        Set<String> expected = new HashSet<>(summonerNames);
        List<String> unexpected = new LinkedList<>();
        for (Summoner summoner : summoners.values()) {
            String name = RiotApi.standardizeName(summoner.name);
            if (!expected.remove(name))
                unexpected.add(name);
        }
        assertTrue(String.format("Too many unexpected names.%nMissing: %s%nUnexpected: %s", expected, unexpected),
                unexpected.size() < 10);
    }

    @Test
    public void getByName() throws ExecutionException {
        checkGetByName(api.summoners.getByName(Region.NA, summonerNames));
    }
    @Test
    public void getByNameAsync() throws ExecutionException, InterruptedException {
        api.summoners.getByNameAsync(Region.NA, summonerNames).thenAccept(this::checkGetByName).get();
    }
    private void checkGetByName(Map<String, Summoner> summoners) {
        assertTrue(summonerNames.containsAll(summoners.keySet()));
        for(Map.Entry<String, Summoner> kvp : summoners.entrySet())
            assertEquals(kvp.getKey(), RiotApi.standardizeName(kvp.getValue().name));
        int missing = summonerNames.size() - summoners.size();
        assertTrue("Too many summoners missing.", missing < 10);
    }

    @Test
    public void getMasteries() throws ExecutionException {
        checkGetMasteries(api.summoners.getMasteries(Region.NA, Collections.singletonList(51405L)));
    }
    @Test
    public void getMasteriesAsync() throws ExecutionException, InterruptedException {
        api.summoners.getMasteriesAsync(Region.NA, Collections.singletonList(51405L))
            .thenAccept(this::checkGetMasteries).get();
    }
    private void checkGetMasteries(Map<Long, MasteryPages> result) {
        long expectedId = 34621190;
        for (MasteryPage page : result.get(51405L).pages) {
            assertFalse(page.name.isEmpty());
            assertEquals(expectedId++, page.id);
        }
    }

    @Test
    public void getName() throws ExecutionException {
        checkGetName(api.summoners.getNames(Region.NA, Arrays.asList(69009277L, 76723437L)));
    }
    @Test
    public void getNameAsync() throws ExecutionException, InterruptedException {
        api.summoners.getNamesAsync(Region.NA, Arrays.asList(69009277L, 76723437L))
                .thenAccept(this::checkGetName).get();
    }
    private void checkGetName(Map<Long, String> results) {
        Set<String> expected = new HashSet<>(Arrays.asList("LugnutsK", "0x5A79"));
        for (String name : results.values())
            assertTrue(expected.remove(name));
        assertTrue(expected.isEmpty());
    }

    @Test
    public void getRunes() throws ExecutionException {
        checkGetRunes(api.summoners.getRunes(Region.NA, Collections.singletonList(51405L)));
    }
    @Test
    public void getRunesAsync() throws ExecutionException, InterruptedException {
        api.summoners.getRunesAsync(Region.NA, Collections.singletonList(51405L))
                .thenAccept(this::checkGetRunes).get();
    }
    private void checkGetRunes(Map<Long, RunePages> result) {
        Set<Long> expected = new HashSet<>(Arrays.asList(
                2706294L, 2706295L, 5526340L, 28433182L, 28433184L, 28433185L, 28433186L, 28433187L, 28433188L,
                41178176L, 55520448L, 55520449L, 55520450L, 55520451L, 55520452L, 55520453L, 55520454L, 55520455L,
                55520456L, 55520457L));
        for (RunePage page : result.get(51405L).pages) {
            assertFalse(page.name, page.name.isEmpty());
            assertTrue("" + page.id, expected.remove(page.id));
        }
        assertTrue(expected.toString(), expected.isEmpty());
    }
}
