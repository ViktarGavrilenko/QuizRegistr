package utils;

import aquality.selenium.core.logging.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtils {
    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String GET_REQUEST_ERROR = "GET request error ";

    public static HttpResponse<String> sendGet(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "HttpClient")
                .build();

        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            Logger.getInstance().error(GET_REQUEST_ERROR + e);
            throw new IllegalArgumentException(GET_REQUEST_ERROR, e);
        }
    }
}