package Steps;

import Utility.TestContext;
import io.cucumber.java.en.*;
import Pages.LoginPage;
import Utility.DriverManager;
import java.io.File;

import java.io.File;

public class LoginSteps extends TestContext{
    public LoginSteps(){
        loginPage = new LoginPage();
    }


    @Given("User is on the login page")
    public void user_is_on_login_page() {

        String filePath = "src/test/java/demoHtml/Login.html";
        File file = new File("src/test/java/demoHtml/Login.html");
        String html_page = file.getAbsolutePath();

        loginPage.openLogin_page("file:///"+html_page);
    }

    @When("User enters {string} and {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User clicks the login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in() {
        // Add assertion logic
        DriverManager.quitDriver();
    }
}
