package com.yourtransfer24.sdk;

public class YT24ProfileAPI {

    private final YT24Client client;

    public YT24ProfileAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /profile
     */
    public String getProfile() throws Exception {
        return client.request("GET", "/profile", null);
    }

    /**
     * POST /profile/update
     */
    public String updateProfile(String jsonBody) throws Exception {
        return client.request("POST", "/profile/update", jsonBody);
    }
}
