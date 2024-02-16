package API;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;


public class GetRequest {
    @Test
    public void httpGet()
    {
        Response response= given().when().get().then().extract().response();

        JsonPath jsonPath=response.jsonPath();
        String name= jsonPath.getString("gear[1].id.val");
    }
}
