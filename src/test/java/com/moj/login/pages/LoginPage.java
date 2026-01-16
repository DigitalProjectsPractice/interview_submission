package com.moj.login.pages;

import com.moj.login.utils.ApplicationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.xpath("//button[@id='submit']");
    private final By errorMessage = By.id("error");

    public void openLoginPage() {
        driver.get(ApplicationConstants.LOGIN_PAGE_URL);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed() ? error.getText() : "";
    }
}
