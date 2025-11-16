package com.yourtransfer24.sdk;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;
import java.time.Duration;

public class YT24Client {

    private final String apiKey;
    private final String baseUrl;

    private final HttpClient httpClient;

    /**
     * Constructor
     * environment = "sandbox" or "production"
     */
    public YT24Client(String apiKey, String environment) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key is required");
        }

        this.apiKey = apiKey;

        if ("sandbox".equalsIgnoreCase(environment)) {
            this.baseUrl = "https://sandbox.yourtransfer24.com/wp-json/yt24/v1";
        } else {
            this.baseUrl = "https://www.yourtransfer24.com/wp-json/yt24/v1";
        }

        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    /**
     * Generic request handler (GET, POST, PATCH)
     * Returns raw JSON response as String
     */
    public String request(String method, String endpoint, String jsonBody) throws Exception {

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey);

        switch (method.toUpperCase()) {
            case "GET":
                builder.GET();
                break;

            case "POST":
                builder.POST(HttpRequest.BodyPublishers.ofString(jsonBody != null ? jsonBody : "{}"));
                break;

            case "PATCH":
                builder.method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody != null ? jsonBody : "{}"));
                break;

            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }

        HttpRequest request = builder.build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
