package stepdefs;

import helpers.ConfigFileReader;
import helpers.Headers;
import helpers.RestServer;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Base {
    static String basePath = "game.web/service?";
    ConfigFileReader configFileReader = new ConfigFileReader();
    Headers headers = new Headers();
    public RestServer server = new RestServer(configFileReader.getProtocol(), configFileReader.getHostName()); //protocol ? scheme

    RequestSpecification requestSpec = given()
            .baseUri(server.getHost())
            .basePath(basePath)
            .headers(headers.getHeaders());
}
