package utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class ApiUtilities {

    public void validateSchema(Response response,String file)
    {
      response.then()
              .assertThat()
              .body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
