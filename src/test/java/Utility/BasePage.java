package Utility;

import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    protected SelfHealingDriver driver;  // Keep only the driver reference

    public BasePage(SelfHealingDriver driver) {
        this.driver = driver;
    }

    public void attachLogsToScenario(String message, String message_name) {
        TestContext.scenario.attach(message, "text/plain", message_name);
    }

    public void takeScreenshot() {
        try {
            WebDriver delegateDriver = driver.getDelegate();

            File srcFile = ((TakesScreenshot) delegateDriver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "screenshots/screenshot_" + timestamp + ".png";

            byte[] screenshot = ((TakesScreenshot) delegateDriver).getScreenshotAs(OutputType.BYTES);

            TestContext.scenario.attach(screenshot, "image/png", "Screenshot on Failure");

            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(filePath));

            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

}
