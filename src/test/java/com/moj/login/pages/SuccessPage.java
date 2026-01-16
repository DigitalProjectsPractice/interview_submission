package com.moj.login.pages;

import org.openqa.selenium.By;

import com.moj.login.utils.ApplicationConstants;

public class SuccessPage extends BaseClass {
    private final By successMessage = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
    private final By logoutButton = By.xpath("//a[text()='Log out']");

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public boolean isOnSuccessPage() {
        return driver.getCurrentUrl().equals(ApplicationConstants.SUCCESS_PAGE_URL);
    }

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }
}
