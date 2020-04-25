package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = {"stepdefs"},
        tags = "@smoketest",
        plugin = {"json:target/cucumber.json", "pretty", "html:target/cucumber-report/smoketest"}
)

public class TestRunner {


}