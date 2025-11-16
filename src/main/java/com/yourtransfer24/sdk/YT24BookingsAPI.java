package com.yourtransfer24.sdk;

public class YT24BookingsAPI {

    private final YT24Client client;

    public YT24BookingsAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * GET /bookings   (cursor pagination)
     */
    public String list(String queryParams) throws Exception {
        String endpoint = "/bookings";
        if (queryParams != null && !queryParams.isEmpty()) {
            endpoint += "?" + queryParams;
        }
        return client.request("GET", endpoint, null);
    }

    /**
     * GET /booking/{id}
     */
    public String get(int id) throws Exception {
        return client.request("GET", "/booking/" + id, null);
    }

    /**
     * POST /booking/create
     */
    public String create(String jsonBody) throws Exception {
        return client.request("POST", "/booking/create", jsonBody);
    }

    /**
     * POST /booking-status/{id}
     */
    public String updateStatus(int id, String jsonBody) throws Exception {
        return client.request("POST", "/booking-status/" + id, jsonBody);
    }

    /**
     * POST /booking-confirm/{id}
     */
    public String confirm(int id) throws Exception {
        return client.request("POST", "/booking-confirm/" + id, "{}");
    }
}
