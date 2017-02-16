package com.mingweisamuel.zyra.enums;

/**
 * Helper static class for getting queue names.
 *
 * Be sure to look at the <a href="https://developer.riotgames.com/">Riot API</a> to determine which values need to
 * be accounted for. Each endpoint only uses or accept a subset of these values. Note also this collection is likely
 * non-exhaustive.
 */
public class Queue {
    private Queue() {}

    public static final String RANKED_SOLO_5x5 = "RANKED_SOLO_5x5";
    public static final String RANKED_TEAM_3x3 = "RANKED_TEAM_3x3";
    public static final String RANKED_TEAM_5x5 = "RANKED_TEAM_5x5";
    public static final String TEAM_BUILDER_DRAFT_RANKED_5x5 = "TEAM_BUILDER_DRAFT_RANKED_5x5";
    public static final String TEAM_BUILDER_DRAFT_UNRANKED_5x5 = "TEAM_BUILDER_DRAFT_UNRANKED_5x5";
    public static final String RANKED_FLEX_SR = "RANKED_FLEX_SR";
    public static final String RANKED_FLEX_TT = "RANKED_FLEX_TT";
    public static final String TEAM_BUILDER_RANKED_SOLO = "TEAM_BUILDER_RANKED_SOLO";

    public static final String ARAM_5x5 = "ARAM_5x5";
    public static final String BOT_5x5 = "BOT_5x5";
    public static final String BOT_5x5_BEGINNER = "BOT_5x5_BEGINNER";
    public static final String BOT_5x5_INTERMEDIATE = "BOT_5x5_INTERMEDIATE";
    public static final String BOT_5x5_INTRO = "BOT_5x5_INTRO";
    public static final String BOT_ODIN_5x5 = "BOT_ODIN_5x5";
    public static final String BOT_TT_3x3 = "BOT_TT_3x3";
    public static final String BOT_URF_5x5 = "BOT_URF_5x5";
    public static final String CUSTOM = "CUSTOM";
    public static final String FIRSTBLOOD_1x1 = "FIRSTBLOOD_1x1";
    public static final String FIRSTBLOOD_2x2 = "FIRSTBLOOD_2x2";
    public static final String GROUP_FINDER_5x5 = "GROUP_FINDER_5x5";
    public static final String NIGHTMARE_BOT_5x5_RANK1 = "NIGHTMARE_BOT_5x5_RANK1";
    public static final String NIGHTMARE_BOT_5x5_RANK2 = "NIGHTMARE_BOT_5x5_RANK2";
    public static final String NIGHTMARE_BOT_5x5_RANK5 = "NIGHTMARE_BOT_5x5_RANK5";
    public static final String NORMAL_3x3 = "NORMAL_3x3";
    public static final String NORMAL_5x5_BLIND = "NORMAL_5x5_BLIND";
    public static final String NORMAL_5x5_DRAFT = "NORMAL_5x5_DRAFT";
    public static final String ODIN_5x5_BLIND = "ODIN_5x5_BLIND";
    public static final String ODIN_5x5_DRAFT = "ODIN_5x5_DRAFT";
    public static final String ONEFORALL_5x5 = "ONEFORALL_5x5";
    public static final String RANKED_PREMADE_3x3 = "RANKED_PREMADE_3x3";
    public static final String RANKED_PREMADE_5x5 = "RANKED_PREMADE_5x5";
    public static final String SR_6x6 = "SR_6x6";
    public static final String URF_5x5 = "URF_5x5";
    public static final String BILGEWATER_5x5 = "BILGEWATER_5x5";
    public static final String BILGEWATER_ARAM_5x5 = "BILGEWATER_ARAM_5x5";

    public static final String NONE = "NONE";
    public static final String NORMAL = "NORMAL";
    public static final String BOT = "BOT";
    public static final String ODIN_UNRANKED = "ODIN_UNRANKED";
    public static final String BOT_3x3 = "BOT_3x3";
    public static final String ARAM_UNRANKED_5x5 = "ARAM_UNRANKED_5x5";
    public static final String HEXAKILL = "HEXAKILL";
    public static final String CAP_5x5 = "CAP_5x5";
    public static final String URF = "URF";
    public static final String URF_BOT = "URF_BOT";
    public static final String NIGHTMARE_BOT = "NIGHTMARE_BOT";
    public static final String ASCENSION = "ASCENSION";
    public static final String KING_PORO = "KING_PORO";
    public static final String COUNTER_PICK = "COUNTER_PICK";
    public static final String BILGEWATER = "BILGEWATER";
    public static final String SIEGE = "SIEGE";

    /**
     * Specific values for {@link com.mingweisamuel.zyra.match.MatchDetail#matchType}
     */
    public class MatchType {
        public static final String CUSTOM_GAME = "CUSTOM_GAME";
        public static final String MATCHED_GAME = "MATCHED_GAME";
        public static final String TUTORIAL_GAME = "TUTORIAL_GAME";
    }

    /**
     * Specific values for {@link com.mingweisamuel.zyra.match.MatchDetail#matchMode}
     */
    public class MatchMode {
        public static final String CLASSIC = "CLASSIC";
        public static final String ODIN = "ODIN";
        public static final String ARAM = "ARAM";
        public static final String TUTORIAL = "TUTORIAL";
        public static final String ONEFORALL = "ONEFORALL";
        public static final String ASCENSION = "ASCENSION";
        public static final String FIRSTBLOOD = "FIRSTBLOOD";
        public static final String KINGPORO = "KINGPORO";
        public static final String SIEGE = "SIEGE";
    }

    /**
     * Specific values for {@link com.mingweisamuel.zyra.stats.PlayerStatsSummary#playerStatSummaryType}.
     */
    public class SummaryType {
        public static final String AramUnranked5x5 = "AramUnranked5x5";
        public static final String Ascension = "Ascension";
        public static final String Bilgewater = "Bilgewater";
        public static final String CAP5x5 = "CAP5x5";
        public static final String CoopVsAI = "CoopVsAI";
        public static final String CoopVsAI3x3 = "CoopVsAI3x3";
        public static final String CounterPick = "CounterPick";
        public static final String FirstBlood1x1 = "FirstBlood1x1";
        public static final String FirstBlood2x2 = "FirstBlood2x2";
        public static final String Hexakill = "Hexakill";
        public static final String KingPoro = "KingPoro";
        public static final String NightmareBot = "NightmareBot";
        public static final String OdinUnranked = "OdinUnranked";
        public static final String OneForAll5x5 = "OneForAll5x5";
        public static final String RankedPremade3x3 = "RankedPremade3x3";
        public static final String RankedPremade5x5 = "RankedPremade5x5";
        public static final String RankedSolo5x5 = "RankedSolo5x5";
        public static final String RankedTeam3x3 = "RankedTeam3x3";
        public static final String RankedTeam5x5 = "RankedTeam5x5";
        public static final String SummonersRift6x6 = "SummonersRift6x6";
        public static final String Unranked = "Unranked";
        public static final String Unranked3x3 = "Unranked3x3";
        public static final String URF = "URF";
        public static final String URFBots = "URFBots";
        public static final String Siege = "Siege";
        public static final String RankedFlexSR = "RankedFlexSR";
        public static final String RankedFlexTT = "RankedFlexTT";
    }

}
