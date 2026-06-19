package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static utils.Endpoints.BASE_URL;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
