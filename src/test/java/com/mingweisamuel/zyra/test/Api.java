package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;

public class Api {
    private Api() {}
    public static final RiotApi api = RiotApi.build(System.getenv("API_KEY"))
            .setConcurrentRequestsMax(Integer.parseInt(System.getProperty("testThreadCount")))
            .setRetries(10).build();
}
