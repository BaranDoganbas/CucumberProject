package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user enters customer_email and customer_password")
    public void user_enters_customer_email_and_customer_password(DataTable credentials) {
////        1. GET DATA AS LIST OF STRING
//        List<String> customerData = credentials.row(1);//row index starts at 0
////        System.out.println(customerData.get(0));
////        System.out.println(customerData.get(1));
////        System.out.println(credentials.row(1).get(0));//2nd row 1st column
////        System.out.println(credentials.row(1).get(1));//2nd row 2nd column
//        loginPage.username.sendKeys(customerData.get(0));
//        loginPage.password.sendKeys(customerData.get(1));
//        loginPage.loginButton.click();

//        2. GET DATA AS LIST<MAP<STRING,STRING>>
        List<Map<String, String>> customerData = credentials.asMaps(String.class, String.class);
//        System.out.println(customerData);
        customerData.forEach(each -> loginPage.username.sendKeys(each.get("username")));
        customerData.forEach(each -> loginPage.password.sendKeys(each.get("password")));
        loginPage.loginButton.click();
    }

    @Then("verify the application login is successful")
    public void verify_the_application_login_is_successful() {
        Assert.assertTrue(homePage.userID.isDisplayed());
    }

    @Then("verify the next page url contains login keyword")
    public void verify_the_next_page_url_contains_login_keyword() {
        ReusableMethods.waitFor(3);
//        BELOW ASSERTION FAILS
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
}