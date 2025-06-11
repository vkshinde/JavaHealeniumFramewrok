package Utility;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.*;


public class Hooks {

    protected static SelfHealingDriver driver;
    private final TestContext testContext = new TestContext();


    @BeforeAll
    public static void initializeTestSuite() {
        System.out.println("==== Initializing Test Suite ====");
    }

    @Before
    public void setupTest(Scenario scenario) {
        driver = DriverManager.getDriver();
        TestContext.setDriver(driver);
        TestContext.scenario = scenario;
        System.out.println("Starting a new test scenario...");
    }

    @After
    public void cleanupTest() {
        System.out.println("Scenario execution completed.");
        DriverManager.quitDriver();
    }

    @AfterAll
    public static void finalizeTestSuite() {
        System.out.println("==== Test Suite Execution Completed ====");
    }
}
