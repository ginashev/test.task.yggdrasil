package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        stepNotifications = true,
        features = "src/test/java/resources/features",
        glue = {"stepdefs"},
        tags = "@smoketest",
        plugin = {"json:target/cucumber.json", "pretty", "html:target/cucumber-report/smoketest"}
)

public class TestRunner {


}