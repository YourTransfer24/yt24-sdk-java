package com.yourtransfer24.sdk;

public class YT24AvailabilityAPI {

    private final YT24Client client;

    public YT24AvailabilityAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * POST /availability/check
     */
    public String check(String jsonBody) throws Exception {
        return client.request("POST", "/availability/check", jsonBody);
    }
}
