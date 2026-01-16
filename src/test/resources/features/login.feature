Feature: Practice Test Automation Login

  Background:
    Given user is on the login page


  # Successful login validation
  Scenario: Successful login validation
    When user logs in using "success" credentials
    And user clicks login
    Then user should land on successful login page
    And success message should be visible
    And logout button should be displayed

  # Invalid password scenario
  Scenario: Invalid password
    When user logs in using "failure" credentials
    And user clicks login
    Then error message should be shown

  # Empty credentials scenario
  Scenario: Empty credentials
    When user logs in using "empty" credentials
    And user clicks login
    Then error message should be shown
