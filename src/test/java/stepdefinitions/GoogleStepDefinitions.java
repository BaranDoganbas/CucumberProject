package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();
    AmazonPage amazonPage = new AmazonPage();

    @Given("User is on the google home page")
    public void user_is_on_the_google_home_page() {
//        WRITE THE JAVA CODE
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
    }

    @When("User searches for iPhone")
    public void user_searches_for_i_phone() {
        googlePage.searchBox.sendKeys("iPhone" + Keys.ENTER);
    }

    @Then("verify page title contains iPhone")
    public void verify_page_title_contains_i_phone() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iPhone"));
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @When("User searches for TeaPot")
    public void user_searches_for_tea_pot() {
        googlePage.searchBox.sendKeys("TeaPot" + Keys.ENTER);
    }

    @Then("verify page title contains TeaPot")
    public void verify_page_title_contains_tea_pot() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("TeaPot"));
    }

    @When("User searches for {string} on google")
    public void user_searches_for_on_google(String string) {
        googlePage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("verify page title contains {string}")
    public void verify_page_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }
    @Given("User is on the amazon home page")
    public void user_is_on_the_amazon_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
    }

    @When("user searches for {string} on amazon")
    public void user_searches_for_on_amazon(String string) {
        amazonPage.searchBox.sendKeys(string + Keys.ENTER);
    }
}
