package Utility;

import Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
    public static SelfHealingDriver driver;
    public static Scenario scenario;

    public TestContext() {
        WebDriverManager.chromedriver().setup();

    }


    public static void setDriver(SelfHealingDriver driver){
//        WebDriver baseDriver = new ChromeDriver();
        TestContext.driver = driver;

    }
    public WebDriver getDriver() {
        return driver;
    }
    public LoginPage loginPage = null;
    public BasePage basePage = new BasePage(driver);
}
