package Pages;


import Utility.TestContext;
import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;

public class LoginPage extends TestContext{


    By usernameField = By.xpath("//input[contains(@id, 'user_')]");
    By passwordField = By.xpath("//input[contains(@id, 'pass_')]");
    By loginButton = By.xpath("//button[contains(@id, 'btn_')]");




    public void enterUsername(String username) {

        driver.findElement(usernameField).sendKeys(username);
        basePage.attachLogsToScenario(username, "Username");
    }

    public void enterPassword(String password) {
        basePage.attachLogsToScenario(password, "Password");
        driver.findElement(passwordField).sendKeys(password);
        basePage.takeScreenshot();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void openLogin_page(String filePath) {
        driver.get(filePath);
        basePage.takeScreenshot();
    }
}
