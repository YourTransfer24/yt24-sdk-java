package com.yourtransfer24.sdk;

public class YT24VehiclesAPI {

    private final YT24Client client;

    public YT24VehiclesAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /vehicles
     */
    public String list() throws Exception {
        return client.request("GET", "/vehicles", null);
    }

    /**
     * GET /vehicle/{id}
     */
    public String get(int id) throws Exception {
        return client.request("GET", "/vehicle/" + id, null);
    }
}
