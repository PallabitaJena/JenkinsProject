package utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class ApiUtilities {

    public boolean validateSchema(Response response,String file)
    {
      response.then()
              .assertThat()
              .body(JsonSchemaValidator.matchesJsonSchema(file));
      return true;
    }
}
