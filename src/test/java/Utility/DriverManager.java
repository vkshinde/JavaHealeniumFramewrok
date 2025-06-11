package Utility;


import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager{
    private static WebDriver driver;
    private static SelfHealingDriver healingDriver;

    public static SelfHealingDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--allow-file-access-from-files");
            options.addArguments("--disable-web-security");
            driver = new ChromeDriver(options);

        }
        return SelfHealingDriver.create(driver);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

