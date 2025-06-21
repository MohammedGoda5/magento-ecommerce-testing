# 🧪 Magento E-Commerce Test Automation Project

This automation framework validates key workflows on the [Magento Demo Site](https://magento.softwaretestingboard.com),
using the [SHAFT Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) with Selenium, TestNG, and Java.



## 📌 Objective

To ensure the quality of an e-commerce platform by automating critical scenarios such as:

- Product search (valid/invalid)
- Add to cart functionality
- Checkout flow

---

## 🧰 Tech Stack

| Tool           | Description                                   |
|----------------|-----------------------------------------------|
| Java           | Programming language                          |
| SHAFT Engine   | Test automation framework (Selenium + TestNG) |
| Maven          | Dependency and build management               |
| TestNG         | Test execution and reporting framework        |
| Allure         | Reporting and result visualization            |
| POM Design     | Page Object Model for scalability             |

---

## 🗂 Project Structure

magento-ecommerce-testing/
├── src/
│ ├── main/java/pages/ # Page Objects (Home, Login, Product, Checkout)
│ └── test/java/tests/ # Test classes (AddToCart, Checkout, product search)
│ └── BaseTest.java # Common setup/teardown
│ └── testDataFiles/testData.json
├── testng.xml # Test suite definition
├── pom.xml # Maven dependencies and plugins
├── generate_allure_report.bat # Allure report generator
├── README.md # Project documentation
├── testng.xml # file to run all the test cases


---

 ✅ Test Coverage

| Test Case           | Description                                           |
|---------------------|-------------------------------------------------------|
| `ProductSearchTest` | Searches for valid and invalid keywords               |
| `AddToCartTest`     | Verifies cart functionality with product variations   |
| `CheckoutTest`      | Completes the checkout process                        |

---

## ▶️ How to Run the Project

## Prerequisites
- Java 21 
- Maven  3.9.9
- git version 2.45.1.windows.1

 Execution (via PowerShell or Terminal) or IDE  i.e(IntelliJ)


# Steps to run the script   
`mvn clean test --% -DsuiteXmlFile=testng.xml
`
