package seleniumjavacucumber.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import seleniumjavacucumber.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "seleniumjavacucumber/steps", plugin = { "pretty",
        "html:target/cucumber-reports/reports.html" })

public class Runner {
    @AfterClass
    public static void driverQuit() {
        BasePage.driverQuit();
    }

}
