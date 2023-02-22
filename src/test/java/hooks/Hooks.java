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
        if (scenario.isFailed()) {//capturing the screenshot when a scenario fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario" + scenario.getName() + "");
            Driver.closeDriver();
        }
    }


    //    This Before hooks ONLY RUNS for @smoke_tests TAGGED SCENARIOs
//    @Before(value = "@smoke_tests")
    @Before("@smoke_tests")
    public void setUpSmoothScenarios() {
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }
//    This After hooks ONLY RUNS for @smoke_tests TAGGED SCENARIOS
    @After("@smoke_tests")
    public void tearDownSmokeScenarios(){
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }

}
