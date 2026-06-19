package helper;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIHelper {

    public static Response getUserById(int id) {
        return given()
                .when()
                .get("/users/" + id)
                .then()
                .extract()
                .response();
    }
}
