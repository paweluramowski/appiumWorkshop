package pl.uramowski.appium.runners;

import cucumber.api.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/resources/features/",
        glue = "pl/uramowski/appium/steps",
        format = {"pretty", "json:target/test-report.json"})
public class Device_HT23TW116860_Runner extends MainRunner {

    @BeforeClass
    public void setUp(ITestContext context) throws Exception {
        super.setUp("HT23TW116860");
    }
}
