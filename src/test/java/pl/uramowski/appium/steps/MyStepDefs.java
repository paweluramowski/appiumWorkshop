package pl.uramowski.appium.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pl.uramowski.appium.screens.APIDemosMainScreen;

import static pl.uramowski.appium.runners.MainRunner.appiumDriver;

public class MyStepDefs {

    @Given("^I have my test app opened$")
    public void iLaunchMyTestApp() throws Throwable {
        appiumDriver.launchApp();
    }

    @Then("^I see main page is displayed$")
    public void iSeeMainPageIsDisplayed() throws Throwable {
        APIDemosMainScreen apiDemosMainScreen = new APIDemosMainScreen(appiumDriver);
        apiDemosMainScreen.await();
    }
}
