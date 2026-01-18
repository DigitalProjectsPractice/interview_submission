 # Test Automation Framework – Login Module

## Overview
This project is a Java-based test automation framework built using **Selenium WebDriver**, **Cucumber (BDD)**, **TestNG**, and **Maven**. The framework is designed to validate the login functionality of a web application using behavior-driven development principles, with an emphasis on readability, maintainability and scalability.

The framework supports data-driven testing, reusable step definitions and clear reporting to ensure tests are easy to understand and extend.

---

## Tech Stack
- **Java** – Programming language
- **Selenium WebDriver** – Browser automation
- **Cucumber** – BDD framework
- **TestNG** – Test runner and assertions
- **Maven** – Build and dependency management
- **WebDriverManager** – Browser driver management

---

## Project Structure
```
Login/
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── com.moj.login
│   │   │   │   ├── driver         # Webdriver setup
│   │   │   │   ├── hooks          # Setup and tear down
│   │   │   │   ├── pages          # A class is created for each page with locators
│   │   │   │   ├── runners        # Cucumber runner classes
│   │   │   │   ├── steps          # Step definition implementations
│   │   │   │   └── utils          # utilities
│   │   ├── resources
│   │   │   ├── features           # Cucumber feature files
│   │   │   └── testdata           # CSV or other test data files
├── pom.xml                        # Maven configuration
└── README.md                      # Project documentation
```

---

## Prerequisites
Ensure the following are installed on your machine:
- Java JDK 11 or above
- Maven 3.8+
- Google Chrome (or another supported browser)
- IDE (IntelliJ IDEA / Eclipse recommended)

---

## Setup Instructions

1. **Clone or extract the project**
   ```bash
   git clone <repository-url>
   cd Login
   ```

2. **Import the project into IDE**
   - Open IntelliJ IDEA or Eclipse
   - Import as a **Maven project**
   - Allow dependencies to download

3. **Verify Maven dependencies**
   ```bash
   mvn clean install
   ```

---

## Running the Tests

### Run all tests using Maven
```bash
mvn test
```

### Run tests from IDE
- Navigate to the Cucumber runner class
- Right-click and select **Run**

### Run specific scenarios
- Use **tags** in feature files (e.g., `@smoke`, `@regression`)
- Configure the runner class to include required tags

---

## Example Feature File
```gherkin
Feature: Practice Test Automation Login

  Background:
    Given user is on the login page
    
  Scenario: Successful login validation
    When user logs in using "success" credentials
    And user clicks login
    Then user should land on successful login page
    And success message should be visible
    And logout button should be displayed
```

---

## Design Choices

1. **BDD with Cucumber**
   - Improves collaboration between technical and non-technical stakeholders
   - Test scenarios are readable and business-focused

2. **Page Object Model (POM)**
   - Separates test logic from UI locators
   - Enhances maintainability when UI changes

3. **Data-Driven Testing**
   - Supports CSV-based input for multiple credential combinations
   - Reduces duplication and increases coverage

4. **Hooks and Utilities**
   - Centralized WebDriver setup and teardown
   - Common utilities reused across tests

---

## Reporting
- Default Cucumber reports are generated after execution
- Reports can be enhanced with plugins (e.g., HTML, JSON)

---

## Assumptions
- Application under test is accessible during execution
- Test data is valid and maintained separately from test logic

---

## Improvements with More Time

- Add parallel execution support using TestNG
- Integrate advanced reporting (Allure / Extent Reports)
- Implement CI/CD execution with Jenkins
- Add cross-browser support (Firefox, Edge)
- Introduce environment-based configuration (dev, test, prod)
- Improve logging using Log4j or SLF4J

---

## Author
Test Automation Framework – Login Module

