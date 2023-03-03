package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtil excelUtil;
    List<Map<String, String>> excelDatalari;

    //    Bu method login sayfasina gitmek icin kullanilacak
    public void login() {
//        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        home page login'e tikla
        homePage = new HomePage();
        loginPage = new LoginPage();

//        ------SADECE ILK GIRIS-------
//        loginLink butonu sadece ilk giriste sayfada gorunur
//        Ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NoSuchElementException alinir
//        Biz bu exception'i try-catch kullanarak yakalariz ve test case calismaya devam eder
        try {
            homePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
        } catch (Exception e) {
        }

//        -------SONRAKI GIRISLER-------
        try {
//            Kullanici id'ye tikla           -> try catch
            homePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla            -> try catch
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
//            OK'e tikla                      -> try catch
            homePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page Login linkine tikla   -> try catch
            homePage.loginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
    }

    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String string) throws IOException {
        String path = "src/test/resources/testdata/mysmoketestdata.xlsx";
//                     ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH
        String sheetName = "customer_info";
//        DATALARI EXCEL UTILS METHOD'LARINI KULLANARAK BURAYA ALACAGIZ
        excelUtil = new ExcelUtil(path, sheetName);
//        Excel data'larini getDataList method'u ile cekelim
        excelDatalari = excelUtil.getDataList();
//        LOOP KULLANARAK DATALARI TEK TEK TEST CASE'DE KULLAN
        for (Map<String, String> data : excelDatalari) {
            login();// Her Loop'da Login Sayfasina Goturecek
            ReusableMethods.waitFor(1);
//            Submit user name
            loginPage.username.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
//            Submit password
            loginPage.password.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
//            Click login button
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(homePage.userID);
            ReusableMethods.waitFor(1);
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(data.get("username"));
        }
    }

    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
            ReusableMethods.getScreenshot("screenshot");
    }
}
