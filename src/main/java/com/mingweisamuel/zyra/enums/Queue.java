package com.mingweisamuel.zyra.enums;

/**
 * Helper static class for getting queue names.
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

    /** {@link com.mingweisamuel.zyra.stats.PlayerStatsSummary#playerStatSummaryType} */
    public static class SummaryType {
        private SummaryType() {}

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
