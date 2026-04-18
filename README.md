# Magento E-Commerce Test Automation Project

[![CI](https://github.com/USERNAME/REPO_NAME/actions/workflows/ci.yml/badge.svg)](https://github.com/USERNAME/REPO_NAME/actions/workflows/ci.yml)
[![Docker Tests](https://github.com/USERNAME/REPO_NAME/actions/workflows/docker-tests.yml/badge.svg)](https://github.com/USERNAME/REPO_NAME/actions/workflows/docker-tests.yml)
[![Tests](https://img.shields.io/badge/tests-4-brightgreen)](https://github.com/USERNAME/REPO_NAME/actions)

This project automates critical workflows on the [Magento Demo Site](https://magento.softwaretestingboard.com) using the [SHAFT Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) - a powerful test automation framework built on Selenium, TestNG, and Java.

---

## Objective

Ensure the quality and reliability of an e-commerce platform by automating key user scenarios:

- Product search (valid and invalid cases)
- Add to cart functionality
- Complete checkout flow

---

## Tech Stack

| Tool | Version | Description |
|------|---------|-------------|
| Java | 21 | Programming language |
| SHAFT Engine | 9.2.20250530 | Test automation framework (Selenium + TestNG) |
| Maven | 3.9.9+ | Build and dependency management |
| TestNG | 3.5.3 | Test execution and reporting framework |
| Allure | 2.34.0 | Reporting and result visualization |
| AspectJ Weaver | 1.9.24 | Used by SHAFT for listeners |

---

## Project Structure

```
magento-ecommerce-testing/
+-- src/
¦   +-- main/
¦   ¦   +-- java/pages/                      # Page Objects
¦   ¦   ¦   +-- AddProductPage.java
¦   ¦   ¦   +-- CheckoutPage.java
¦   ¦   ¦   +-- HomePage.java
¦   ¦   ¦   +-- LoginPage.java
¦   ¦   +-- resources/properties/             # SHAFT configuration
¦   ¦       +-- default/                    # Default properties
¦   ¦       ¦   +-- TestNG.properties
¦   ¦       ¦   +-- customWebdriverCapabilities.properties
¦   ¦       ¦   +-- ...
¦   ¦       +-- TestNG.properties
¦   ¦       +-- ...
¦   +-- test/
¦       +-- java/tests/                     # Test classes
¦       ¦   +-- AddToCartTest.java
¦       ¦   +-- CheckoutTest.java
¦       ¦   +-- ProductSearchTest.java
¦       ¦   +-- BaseTest.java
¦       +-- resources/
¦           +-- testDataFiles/
¦               +-- testData.json
+-- testng.xml                              # Test suite configuration
+-- pom.xml                                 # Maven dependencies
+-- generate_allure_report.bat              # Allure report generator (Windows)
+-- README.md                               # Project documentation
```

---

## Test Coverage

| Test Class | Test Method | Description |
|------------|-------------|-------------|
| `ProductSearchTest` | `searchForExistingItem` | Validates search returns relevant results for valid keywords |
| `ProductSearchTest` | `searchForInvalidProductItem` | Validates search returns no results message for invalid keywords |
| `AddToCartTest` | `successfulAddItemToCart` | Verifies cart functionality with product size and color selection |
| `CheckoutTest` | `checkoutUsingValidData` | Tests complete checkout flow with valid shipping and payment data |

---

## Prerequisites

Before running the tests, ensure you have:

- **Java 21** - [Download here](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.9.9+** - [Download here](https://maven.apache.org/download.cgi)
- **Git** - [Download here](https://git-scm.com/downloads)

Verify your installation:
```bash
java -version
mvn -version
git --version
```

---

## How to Run

### Option 1: Using Command Line

**Windows (Command Prompt):**
```bash
# Clone the repository
git clone <repository-url>
cd magento-ecommerce-testing

# Run all tests
mvn clean test

# Run with specific test suite
mvn clean test -DsuiteXmlFile=testng.xml

# Run specific test class
mvn test -Dtest=AddToCartTest
```

**Windows (PowerShell):**
```powershell
# Run all tests
mvn clean test

# Run with specific test suite
mvn clean test --% -DsuiteXmlFile=testng.xml
```

### Option 2: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Wait for Maven to sync dependencies
3. Right-click on `testng.xml` ? Run

---

## Generating Reports

### Allure Report

After test execution, generate the Allure report:

**Windows:**
```bash
# Using the provided batch script
.\generate_allure_report.bat

# Or manually (requires Allure CLI)
allure serve target/allure-results
allure generate target/allure-results -o target/allure-report
```

Report will be available at `target/allure-report/index.html`

### Surefire Reports

TestNG reports are automatically generated in:
- `target/surefire-reports/index.html`
- `target/surefire-reports/testng-results.xml`

---

## Configuration

### Test Data

Test data is stored in `src/test/resources/testDataFiles/testData.json`:

```json
{
  "validSearchQuery": "hoodie",
  "invalidSearchQuery": "asd",
  "invalidSearchMessage": "Your search returned no results.",
  "successfulAddedToCartMessage": "You added Radiant Tee to your ",
  "errorMessageAddingItem": "The requested qty is not available",
  "email": "920fbb975bc5@drmail.in",
  "password": "123456789Mm",
  "successfulPurchase": "Thank you for your purchase!",
  "color-blue": "Blue",
  "size-l": "L",
  "street": "St",
  "city": "M",
  "postcode": "12345",
  "phoneNumber": "0"
}
```

Modify this file to update test inputs without changing code.

### SHAFT Engine Configuration

SHAFT Engine configuration files are located in:
- `src/main/resources/properties/`
- `src/main/resources/properties/default/`

Key configuration files:
- `TestNG.properties` - TestNG execution settings (parallel mode, thread count, etc.)
- `customWebdriverCapabilities.properties` - Custom WebDriver capabilities for cloud execution

**Note:** Do not commit sensitive credentials to version control.

---

## Troubleshooting

| Issue | Cause | Solution |
|-------|-------|----------|
| `NoSuchSessionException: invalid session id` | Browser session expired during test execution | Check network connectivity to https://magento.softwaretestingboard.com |
| `NullPointerException` in tests | Page objects not properly initialized or test data missing | Ensure all required fields exist in testData.json |
| Compilation errors | Missing dependencies | Run `mvn clean compile` to download dependencies |
| Allure report not generating | Allure CLI not installed | Install Allure: `npm install -g allure-commandline` or `scoop install allure` |
| Tests fail with timeout | Slow network or site response | Increase timeout in SHAFT properties or check site availability |

---

## CI/CD Integration

### GitHub Actions Example

```yaml
name: Run Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: windows-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
          
      - name: Run Tests
        run: mvn clean test
        
      - name: Upload Allure Report
        uses: actions/upload-artifact@v3
        if: always()
        with:
          name: allure-report
          path: target/allure-results
```

### Jenkins Pipeline Example

```groovy
pipeline {
    agent any
    tools {
        maven 'Maven-3.9.9'
        jdk 'JDK-21'
    }
    stages {
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Generate Report') {
            steps {
                bat 'generate_allure_report.bat'
            }
        }
    }
}
```

---

## Dependencies

Key dependencies (from pom.xml):

| Dependency | Version |
|------------|---------|
| SHAFT_ENGINE | 9.2.20250530 |
| TestNG (via Surefire) | 3.5.3 |
| AspectJ Weaver | 1.9.24 |
| Maven Compiler Plugin | 3.14.0 |
| Maven Surefire Plugin | 3.5.3 |

---

## References

- [SHAFT Engine Documentation](https://shafthq.github.io/)
- [SHAFT Engine GitHub](https://github.com/ShaftHQ/SHAFT_ENGINE)
- [SHAFT Engine Releases](https://github.com/ShaftHQ/SHAFT_ENGINE/releases)
- [TestNG Documentation](https://testng.org/doc/)
- [Allure Framework](https://docs.qameta.io/allure/)
- [Magento Demo Site](https://magento.softwaretestingboard.com)

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-test`)
3. Commit your changes (`git commit -am 'Add new test'`)
4. Push to the branch (`git push origin feature/new-test`)
5. Open a Pull Request

---

## License

This project is for educational and testing purposes only.

---

**Project Version:** 1.0-SNAPSHOT  
**SHAFT Engine Version:** 9.2.20250530  
**Last Updated:** 2026-04-18
