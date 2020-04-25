package helpers;

import data.Headers;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.util.Map;


public class Common {
    static String basePath = "game.web/service?";
    ConfigFileReader configFileReader = new ConfigFileReader();
    public RestServer server = new RestServer(configFileReader.getProtocol(), configFileReader.getHostName()); //protocol ? scheme
    Headers headers = new Headers();
    RequestSpecification requestSpec = RestAssured.given()
            .baseUri(server.getHost())
            .basePath(basePath)
            .headers(headers.getHeaders());

    public JsonPath getJsonPathFromRequest(Map<String, String> parameters) {
        return RestAssured.given()
                .spec(requestSpec)
                .params(parameters)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .jsonPath();
    }
}
