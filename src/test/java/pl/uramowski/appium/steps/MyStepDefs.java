package pl.uramowski.appium.steps;

import cucumber.api.java.en.Given;

import static pl.uramowski.appium.runners.MainRunner.appiumDriver;

public class MyStepDefs {

    @Given("^I have my test app opened$")
    public void iLaunchMyTestApp() throws Throwable {
        appiumDriver.launchApp();
    }

}
