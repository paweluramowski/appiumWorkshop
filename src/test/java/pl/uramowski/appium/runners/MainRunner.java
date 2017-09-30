package pl.uramowski.appium.runners;

import com.thoughtworks.selenium.SeleniumException;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MainRunner extends AbstractTestNGCucumberTests {

    public static AppiumDriver appiumDriver;
    private final String APP_PACKAGE = "io.appium.android.apis";
    private String APK_PATH = "apps/apiDemos.apk";
    private String APP_WAIT_ACTIVITY = "io.appium.android.apis.ApiDemos";

    public MainRunner() {}

    public void setUp(final String deviceId) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", APK_PATH);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("browserName", deviceId);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appWaitActivity", APP_WAIT_ACTIVITY);
        // to use app pre-installed on the phone uncomment lines below
        // capabilities.setCapability("fullReset", false);
        // capabilities.setCapability("noReset", true);
        capabilities.setCapability("clearSystemFiles", true);
        System.out.println("initialising AndroidDriver");
        try {
            appiumDriver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SeleniumException("Appium driver did not start, check node's log :(");
        }
    }
}