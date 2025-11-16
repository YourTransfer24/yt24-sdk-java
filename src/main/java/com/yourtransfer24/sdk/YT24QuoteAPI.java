package com.yourtransfer24.sdk;

public class YT24QuoteAPI {

    private final YT24Client client;

    public YT24QuoteAPI(YT24Client client) {
        this.client = client;
    }

    /**
     * POST /quote
     */
    public String getQuote(String jsonBody) throws Exception {
        return client.request("POST", "/quote", jsonBody);
    }
}
