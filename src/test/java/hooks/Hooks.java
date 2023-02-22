package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
    Hooks is used to run before and after each SCENARIO or SCENARIO OUTLINE
     */
    @Before
    public void setUpScenario() {
//        System.out.println("Before Method");
    }
    @After
    public void tearDownScenario(Scenario scenario) {
//        System.out.println("After Method");
        if (scenario.isFailed()){//capturing the screenshot when a scenario fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario");
            Driver.closeDriver();
        }
    }

}
