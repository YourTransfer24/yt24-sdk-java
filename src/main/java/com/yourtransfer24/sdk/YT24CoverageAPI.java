package com.yourtransfer24.sdk;

public class YT24CoverageAPI {

    private final YT24Client client;

    public YT24CoverageAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /coverage
     */
    public String list() throws Exception {
        return client.request("GET", "/coverage", null);
    }
}
