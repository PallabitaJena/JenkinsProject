package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;

import javax.print.attribute.standard.RequestingUserName;
import java.io.*;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    private RequestSpecBuilder rspedBuild;
    private static PrintStream printer;
    private static RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;
    private ResponseSpecBuilder respSpec;
    private static ResponseSpecification resp;
    private static RequestSpecification request;

    public boolean validateSchema(Response response,String file)
    {
      response.then()
              .assertThat()
              .body(JsonSchemaValidator.matchesJsonSchema(file));
      return true;
    }

  public RequestSpecification requestBuilder()
  {
      if(rspedBuild ==null)
      {
          try
          {
              printer= new PrintStream(new FileOutputStream("logger.txt"),true);
          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          }
        rspedBuild= new RequestSpecBuilder();
      }
      if(checkProxyRequired())
      {
          RestAssured.proxy("Host",Integer.parseInt("Port"),"Scheme");
      }
      requestSpec=rspedBuild.addFilter(RequestLoggingFilter.logRequestTo(printer))
              .setBaseUri("")
              .setAccept(ContentType.JSON)
              .setUrlEncodingEnabled(true)
              .setConfig(RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().dontReuseHttpClientInstance()
                      .setParam("http.connection.timeout",10)
                      .setParam("http.connection.request.timeout",10)
                      .setParam("http.connection.manager.timeout",10))).build();

      return given().relaxedHTTPSValidation().spec(requestSpec).when();

  }
  public static BufferedReader executeCommand(String[] commands) throws IOException {
      return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(commands).getInputStream()));
  }
  public static boolean checkProxyRequired()
  {
      boolean flag= false;
      try{
          if((System.getProperty("os.name").toLowerCase()).indexOf("win") >=0)
          {
              BufferedReader r= executeCommand(new String[]{"cmd.exe","/c","ipconfig"});

              StringBuilder response=new StringBuilder("");
              String line;
              while((line =r.readLine())!=null)
              {
                  response.append(line.trim().replace(" ",""));
              }

              if(response.toString().contains("office proxy"))
              {
                  flag=true;
              }
          }
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      return flag;
  }
  public ResponseSpecification ResponseBuilder()
  {
      respSpec= new ResponseSpecBuilder();
      responseSpec=respSpec.build();
      return responseSpec;
  }

  public Response httpGet()
  {
      request= this.requestBuilder();
      resp=this.ResponseBuilder();
      Response response=null;

      response= given().when().get().then().extract().response();
      return response;
  }
}
