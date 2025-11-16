package com.yourtransfer24.sdk;

public class YT24LogsAPI {

    private final YT24Client client;

    public YT24LogsAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /logs?filters
     */
    public String list(String queryParams) throws Exception {
        String endpoint = "/logs";
        if (queryParams != null && !queryParams.isEmpty()) {
            endpoint += "?" + queryParams;
        }
        return client.request("GET", endpoint, null);
    }
}
