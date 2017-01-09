package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;

class Api {
    private Api() {}
    static final RiotApi api = RiotApi.builder(System.getenv("API_KEY"))
            .setConcurrentRequestsMax(Integer.parseInt(System.getProperty("testThreadCount")))
            .setRetries(10).build();
}
