package tests;

import helper.APIHelper;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ValidateSuccessBody;
import utils.ValidateSuccessRequest;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.SUCCESS_OK;

public class UserApiTest extends BaseTest {

    Response response;
    Map<String, Object> expectedResults = new HashMap<>();


    @Test
    public void validateUserApiResponse() throws Exception {

        response = APIHelper.getUserById(1);

        expectedResults.put("id", 1);
        expectedResults.put("name", "Leanne Graham");
        expectedResults.put("email", "Sincere@april.biz");
        expectedResults.put("address.city", "Gwenborough");
        expectedResults.put("company.name", "Romaguera-Crona");

        ValidateSuccessRequest.validateResponse(
                response,
                SUCCESS_OK,
                "src/test/java/schemas/userSchema.json"
        );

        ValidateSuccessBody.validateResponseBody(
                response,
                expectedResults
        );
    }
}