package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DataTablesPage;
import utilities.Driver;

public class DataTablesStepDefinitions {
    DataTablesPage dataTablesPage = new DataTablesPage();

    @Given("user is on {string} page")
    public void user_is_on_page(String string) {
        Driver.getDriver().get(string);
    }

    @Given("user clicks on the New button")
    public void user_clicks_on_the_new_button() {
        dataTablesPage.newButton.click();
    }

    @Given("user enters the first name {string}")
    public void user_enters_the_first_name(String string) {
        dataTablesPage.firstNameField.sendKeys(string);
    }

    @Given("user enters the last name {string}")
    public void user_enters_the_last_name(String string) {
        dataTablesPage.lastNameField.sendKeys(string);
    }

    @Given("user enters the position {string}")
    public void user_enters_the_position(String string) {
        dataTablesPage.positionField.sendKeys(string);
    }

    @Given("user enters the office {string}")
    public void user_enters_the_office(String string) {
        dataTablesPage.officeField.sendKeys(string);
    }

    @Given("user enters the extension {string}")
    public void user_enters_the_extension(String string) {
        dataTablesPage.extensionField.sendKeys(string);
    }

    @Given("user enters the start date {string}")
    public void user_enters_the_start_date(String string) {
        dataTablesPage.startDateField.sendKeys(string);
    }

    @Given("user enters the salary {string}")
    public void user_enters_the_salary(String string) {
        dataTablesPage.salaryField.sendKeys(string);
    }

    @Given("click on create button")
    public void click_on_create_button() {
        dataTablesPage.createButton.click();
    }

    @Given("search for the first name {string}")
    public void search_for_the_first_name(String string) {
        dataTablesPage.searchBox.sendKeys(string);
    }

    @Then("verify the name field contains the first name {string}")
    public void verify_the_name_field_contains_the_first_name(String string) {
        Assert.assertTrue(dataTablesPage.nameColumn.getText().contains(string));
    }
}
