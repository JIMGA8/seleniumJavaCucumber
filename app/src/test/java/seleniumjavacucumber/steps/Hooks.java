package seleniumjavacucumber.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import seleniumjavacucumber.pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("scenario fallido, referirse a la imagen adjunta");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screnshot del error");
        }
    }

}
