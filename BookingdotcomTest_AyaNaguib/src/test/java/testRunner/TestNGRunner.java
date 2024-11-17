package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "org.example"},
        tags = "@TestBooking",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
