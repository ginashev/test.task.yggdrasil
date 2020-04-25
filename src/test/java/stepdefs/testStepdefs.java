package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.Parameters;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;


public class testStepdefs extends Base {
    static String sessId;
    private static Logger log = LoggerFactory.getLogger(Base.class);
    Parameters parameters = new Parameters();

    @Given("^Logs in into system as anonymous player$")
    public void logsInIntoSystemAsAnonymousPlayer() {
        System.out.println(parameters.getLoginParameters().toString());
        JsonPath getSessionId = given()
                .spec(requestSpec)
                .params(parameters.getLoginParameters())
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .jsonPath();
        sessId = getSessionId.getString("data.sessid");
        log.info("sessid = " + sessId);
    }


    @Then("^send spin request until user win any money$")
    public void sendSpinRequestUntilUserWinAnyMoney() {
        System.out.println(parameters.getGameParametersWithSessionID(sessId).toString());
        double win = 0;
        while (win == 0) {
            JsonPath getWin = given()
                    .params(parameters.getGameParametersWithSessionID(sessId))
                    .spec(requestSpec)
                    .when()
                    .get()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .and()
                    .extract()
                    .jsonPath();
            win = Double.parseDouble(getWin.getString("data.wager.bets[0].eventdata.wonCoins"));
            log.info("win = " + win);
        }
    }
}
