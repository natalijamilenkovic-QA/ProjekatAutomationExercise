Absolutely — here’s a **GitHub-ready README** for your AutomationExercise project, styled in a **clean, professional format** similar to the example you shared.

---

````markdown
# AutomationExercise - QA Automation Project

**Junior QA Automation practice project** for the  
[AutomationExercise](https://automationexercise.com/) e-commerce web application.

This repository contains both **manual test cases** and **automated UI tests** covering core user journeys, implemented using **Java**, **Selenium WebDriver**, and **TestNG** following the **Page Object Model (POM)** design pattern.

---

## 📌 Project Overview

This project focuses on validating key features of an e-commerce workflow, including:

- ✅ User login (valid & invalid)
- ✅ Product search by keyword
- ✅ Adding products to the cart
- ✅ Cart and checkout validation
- ✅ Complete end-to-end (E2E) order placement

Both **manual test case documentation** and **automated test scripts** are provided to demonstrate QA fundamentals and real-world scenario coverage.

---

## 🧰 Tech Stack & Tools

| Category | Technology |
|----------|------------|
| Language | Java 21 (LTS) |
| Automation | Selenium WebDriver |
| Test Runner | TestNG |
| Build Tool | Maven |
| Driver Management | WebDriverManager |
| Design Pattern | Page Object Model (POM) |

---

## 🚀 Installation

### ✔️ Prerequisites

Before running tests, ensure you have:

- Java JDK 21 or higher
- Maven
- IntelliJ IDEA or Eclipse
- Google Chrome browser installed

---

### 🔽 Clone the Repository

```bash
git clone https://github.com/natalijamilenkovic-QA/ProjekatAutomationExercise.git
cd ProjekatAutomationExercise
````

After cloning, open the project in your IDE and wait for Maven to download dependencies from `pom.xml`.

---

## ▶️ Running Automated Tests

### Run All Tests

```bash
mvn test
```

### Run a Specific Test Class

```bash
mvn test -Dtest="PlaceOrderTests"
```

You can also run tests directly through your IDE’s test runner.

---

## 📂 Project Structure

```text
Project_AutomationExercise
├── src/
│   ├── Base/                # BaseTest class (WebDriver setup)
│   ├── Pages/               # Page Object Model classes
│   └── Tests/               # Test classes (TestNG)
├── target/                  # Build artifacts
├── pom.xml                  # Maven configuration
└── README.md                # Project documentation
```

---

## 🧠 Framework Overview

### 🧩 Base Package

* **BaseTest.java**

  * Configures WebDriver setup and teardown
  * Uses TestNG annotations (`@BeforeMethod`, `@AfterMethod`)
  * Maximizes browser window and handles driver lifecycle

---

### 🧾 Pages Package (POM Implementation)

Each page is implemented with Selenium’s **PageFactory** and `@FindBy` annotations:

| Page Class     | Description                               |
| -------------- | ----------------------------------------- |
| `HomePage`     | Navigation to Login and Products          |
| `LoginPage`    | Login fields, actions, and validation     |
| `ProductsPage` | Product search, scroll/click logic        |
| `CartPage`     | Cart verification and checkout navigation |
| `CheckoutPage` | Address details and order comments        |
| `PaymentPage`  | Payment entry and success validation      |

---

### 🧪 Tests Package (Automated Scenarios)

| Test Class              | Scenario                                |
| ----------------------- | --------------------------------------- |
| `LoginValidUserTest`    | Login with valid credentials            |
| `LoginInvalidUserTest`  | Login with invalid credentials (error)  |
| `SearchProductTest`     | Validate search results contain keyword |
| `AddProductsToCartTest` | Add product to cart and verify          |
| `PlaceOrderTests`       | End-to-end order placement flow         |

---

## 🔍 Key Techniques & Assertions

### Methods Used

* **JavascriptExecutor**

  * Handling elements that require scroll or complex interactions
* **WebDriverWait**

  * Explicit waits for element visibility or presence
* **Actions**

  * Hover and complex mouse interactions for dynamic UI

### Assertions Used

* `Assert.assertTrue` – Element visibility & conditions
* `Assert.assertFalse` – Validation that list results aren’t empty
* `Assert.assertEquals` / `contains` – Verification of product names or expected text

---

## 📋 Manual Testing

Manual test cases were created for all implemented scenarios and include:

* Clear step-by-step instructions
* Test data inputs
* Expected results for verification

These documents help ensure complete functional coverage and support automation validation.

---

## 📌 Learning Outcomes

This project demonstrates:

* Fundamentals of QA test automation
* Structuring tests using POM and Selenium
* Integration with TestNG and Maven
* End-to-end scenario automation
* Clear mapping between manual and automated tests

---

## 👤 Author

**Natalija Milenković**
Junior QA Automation Engineer


