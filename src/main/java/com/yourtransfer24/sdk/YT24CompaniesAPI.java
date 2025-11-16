package com.yourtransfer24.sdk;

public class YT24CompaniesAPI {

    private final YT24Client client;

    public YT24CompaniesAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /companies
     */
    public String list() throws Exception {
        return client.request("GET", "/companies", null);
    }

    /**
     * GET /company/{id}
     */
    public String get(int id) throws Exception {
        return client.request("GET", "/company/" + id, null);
    }
}
