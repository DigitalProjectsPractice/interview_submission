package com.moj.login.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.moj.login.steps", "com.moj.login.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html", "junit:target/cucumber.xml"},
    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
