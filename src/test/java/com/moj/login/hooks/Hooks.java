package com.moj.login.hooks;

import com.moj.login.driver.DriverFactory;
import com.moj.login.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();
            ScreenshotUtil.takeScreenshot(scenario, driver);
        }
        DriverFactory.quitDriver();
    }
}

