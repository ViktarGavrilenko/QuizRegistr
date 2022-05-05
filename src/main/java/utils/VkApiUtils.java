package utils;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.WallGet;

import java.net.http.HttpResponse;

import static utils.ApiUtils.sendGet;

public class VkApiUtils {
    private static final ISettingsFile CONFIG_FILE = new JsonSettingsFile("configData.json");
    private static final String WALL_GET = CONFIG_FILE.getValue("/wallGet").toString();
    private static final String WALL_CREATE_COMMENT = CONFIG_FILE.getValue("/wallCreateComment").toString();

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String NOT_DESERIALIZE = "Could not deserialize: ";

    public WallGet getIdLastPost(String ownerId, String token) {
        String apiRequest = String.format(WALL_GET, ownerId, token);
        HttpResponse<String> response = sendGet(apiRequest);
        try {
            return MAPPER.readValue(response.body(), WallGet.class);
        } catch (JsonProcessingException e) {
            Logger.getInstance().error(NOT_DESERIALIZE + e);
            throw new IllegalArgumentException(NOT_DESERIALIZE, e);
        }
    }

    public void createCommentOnWall(String ownerId, String post_id, String message, String token) {
        String apiRequest = String.format(WALL_CREATE_COMMENT, ownerId, post_id, message, token);
        sendGet(apiRequest);
    }

}