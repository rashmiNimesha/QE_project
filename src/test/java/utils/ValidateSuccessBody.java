package utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class ValidateSuccessBody {

    public static void validateResponseBody(
            Response response,
            Map<String, Object> expectedResults) {

        expectedResults.forEach((jsonPath, expectedValue) -> {

            Object actualValue =
                    response.jsonPath().get(jsonPath);

            Assert.assertEquals(
                    actualValue,
                    expectedValue,
                    "Mismatch found for : " + jsonPath);
        });
    }
}
