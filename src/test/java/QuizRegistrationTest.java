import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.WallGet;
import org.testng.annotations.Test;
import utils.VkApiUtils;

public class QuizRegistrationTest {

    private static final ISettingsFile TEST_DATA_FILE = new JsonSettingsFile("testData.json");
    private static final String OWNER_ID = TEST_DATA_FILE.getValue("/ownerId").toString();
    private static final int POST_ID = Integer.parseInt(TEST_DATA_FILE.getValue("/postId").toString());
    private static final String MESSAGE = TEST_DATA_FILE.getValue("/message").toString();
    private static final String TOKEN = TEST_DATA_FILE.getValue("/token").toString();

    @Test(description = "Testing for registration")
    public void RegistrationTest() {
        VkApiUtils vkApiUtils = new VkApiUtils();

        int idPost = 0;
        while (POST_ID > idPost) {
            WallGet wallGets = vkApiUtils.getIdLastPost(OWNER_ID, TOKEN);
            for (int i = 0; i < wallGets.response.items.size(); i++) {
                if (idPost < wallGets.response.items.get(i).id) {
                    idPost = wallGets.response.items.get(i).id;
                }
            }
            Logger.getInstance().info("idPost is " + idPost);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        vkApiUtils.createCommentOnWall(OWNER_ID, Integer.toString(idPost), MESSAGE, TOKEN);
    }
}
