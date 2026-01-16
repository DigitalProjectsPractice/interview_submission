package com.moj.login.pages;

import com.moj.login.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected WebDriver driver;

    public BaseClass() {
        this.driver = DriverFactory.getDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
