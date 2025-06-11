package Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue = {"Steps", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}
