package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {


    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_hxuXyQ", "bhTz7L75m3GvunumqVxa")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
