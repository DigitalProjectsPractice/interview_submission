package com.moj.login.steps;

import com.moj.login.pages.LoginPage;
import com.moj.login.pages.SuccessPage;
import com.moj.login.utils.CsvUtils;
import com.moj.login.utils.LoginData;
import com.moj.login.utils.ScreenshotUtil;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();
    private final SuccessPage successPage = new SuccessPage();
    private Scenario scenarioContext;
    private Map<String, List<LoginData>> loginDataMap;

    @Before
    public void user_loads_test_data_from_csv(Scenario scenario) {
        this.scenarioContext = scenario;
        loginDataMap = new HashMap<>();
        List<String[]> rows = CsvUtils.readCsv("src/test/resources/testdata/login-data.csv");
        for (String[] row : rows) {
            String result = row[0];
            String username = row.length > 1 ? row[1] : "";
            String password = row.length > 2 ? row[2] : "";
            LoginData data = LoginData.builder()
                    .result(result)
                    .username(username)
                    .password(password)
                    .build();
            loginDataMap.computeIfAbsent(result, k -> new ArrayList<>()).add(data);
        }
        scenarioContext.log("Loaded login data from CSV");
    }

    @Given("user is on the login page")
    public void user_is_on__the_login_page() {
        scenarioContext.log("Navigating to login page");
        loginPage.openLoginPage();
    }

    @When("user logs in using {string} credentials")
    public void user_logs_in_using_credentials(String resultType) {
        scenarioContext.log("Logging in using credentials for result type: " + resultType);
        LoginData login = loginDataMap.get(resultType).get(0);
        loginPage.enterUsername(login.getUsername());
        loginPage.enterPassword(login.getPassword());
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        scenarioContext.log("Entering username: " + username + ", password: " + password);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks submit")
    public void user_clicks_submit() {
        scenarioContext.log("Clicking submit button");
        loginPage.clickSubmit();
    }

    @When("user clicks login")
    public void user_clicks_login() {
        scenarioContext.log("Clicking login button");
        loginPage.clickSubmit();
    }

    @Then("user should land on successful login page")
    public void user_should_land_on_successful_login_page() {
        scenarioContext.log("Validating user landed on successful login page");
        Assert.assertTrue(successPage.isOnSuccessPage());
    }

    @Then("success message should be visible")
    public void success_message_should_be_visible() {
        scenarioContext.log("Validating success message is visible");
        Assert.assertTrue(successPage.isSuccessMessageDisplayed());
    }

    @Then("logout button should be displayed")
    public void logout_button_should_be_displayed() {
        scenarioContext.log("Validating logout button is displayed");
        Assert.assertTrue(successPage.isLogoutButtonDisplayed());
    }

    @Then("error message should be shown")
    public void error_message_should_be_shown() {
        scenarioContext.log("Validating error message is shown");
        String errorMsg = loginPage.getErrorMessage();
        scenarioContext.log("Error message found: " + errorMsg);
        boolean errorVisible = errorMsg != null && !errorMsg.isEmpty();
        if (errorVisible) {
            scenarioContext.log("Taking screenshot");
            ScreenshotUtil.takeScreenshot(scenarioContext, loginPage.getDriver());
        }
        Assert.assertTrue(errorVisible, "Error message should be visible");
    }
}
