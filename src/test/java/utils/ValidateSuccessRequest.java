package utils;

import io.restassured.response.Response;
import org.testng.Assert;
import java.io.File;


public class ValidateSuccessRequest {

    public static void validateResponse(
            Response response,
            int expectedStatusCode,
            String schemaPath) throws Exception {

        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Status Code Validation Failed");

        SchemaValidator.validate(response.getBody().asString(), schemaPath);

    }
}
