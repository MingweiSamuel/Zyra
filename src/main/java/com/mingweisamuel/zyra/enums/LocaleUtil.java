package com.mingweisamuel.zyra.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * This class contains static String fields corresponding to (hopefully) every supported locale in the
 * {@link com.mingweisamuel.zyra.LolStaticDataEndpoints} and other endpoints.
 */
public class LocaleUtil {
    private LocaleUtil() {}

    public static final String en_US = "en_US";
    public static final String cs_CZ = "cs_CZ";
    public static final String de_DE = "de_DE";
    public static final String el_GR = "el_GR";
    public static final String en_AU = "en_AU";
    public static final String en_GB = "en_GB";
    public static final String en_PH = "en_PH";
    public static final String en_PL = "en_PL";
    public static final String en_SG = "en_SG";
    public static final String es_AR = "es_AR";
    public static final String es_ES = "es_ES";
    public static final String es_MX = "es_MX";
    public static final String fr_FR = "fr_FR";
    public static final String hu_HU = "hu_HU";
    public static final String id_ID = "id_ID";
    public static final String it_IT = "it_IT";
    public static final String ja_JP = "ja_JP";
    public static final String ko_KR = "ko_KR";
    public static final String ms_MY = "ms_MY";
    public static final String pl_PL = "pl_PL";
    public static final String pt_BR = "pt_BR";
    public static final String ro_RO = "ro_RO";
    public static final String ru_RU = "ru_RU";
    public static final String th_TH = "th_TH";
    public static final String tr_TR = "tr_TR";
    public static final String vn_VN = "vn_VN";
    public static final String zh_CN = "zh_CN";
    public static final String zh_MY = "zh_MY";
    public static final String zh_TW = "zh_TW";

    public static final Set<String> validLocales = new HashSet<>(Arrays.asList(
            en_US, cs_CZ, de_DE, el_GR, en_AU, en_GB, en_PH, en_PL, en_SG, es_AR, es_ES, es_MX, fr_FR, hu_HU, id_ID,
            it_IT, ja_JP, ko_KR, ms_MY, pl_PL, pt_BR, ro_RO, ru_RU, th_TH, tr_TR, vn_VN, zh_CN, zh_MY, zh_TW));

    public static boolean isSupportedLocale(Locale locale) {
        return isSupportedLocale(locale.toString());
    }

    public static boolean isSupportedLocale(String string) {
        return validLocales.contains(string);
    }
}
