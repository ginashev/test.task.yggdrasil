package stepdefs;


import data.Parameters;
import helpers.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class testStepdefs {
    static String sessId;
    private static Logger log = LoggerFactory.getLogger(testStepdefs.class);
    Common common = new Common();
    Parameters parameters = new Parameters();

    @Given("^Logs in into system as anonymous player$")
    public void logsInIntoSystemAsAnonymousPlayer() {
        JsonPath getSessionId = common.getJsonPathFromRequest(parameters.getLoginParametersForAnonymousPlayer());
        sessId = getSessionId.getString("data.sessid");
        log.info("sessid = " + sessId);
    }

    @Then("^send spin request until player win any money$")
    public void sendSpinRequestUntilPlayerWinAnyMoney() {
        double win = 0;
        while (win == 0) {
            JsonPath getWin = common.getJsonPathFromRequest(parameters.getGameParametersWithSessionID(sessId));
            win = Double.parseDouble(getWin.getString("data.wager.bets[0].eventdata.wonCoins"));
            log.info("win = " + win);
        }
    }
}
