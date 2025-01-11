# 💻 My Automation Project 
### 🛠️ Testing Automation Demo Project for Tutorials Ninja Demo
This is a testing automation demo project that tests a real site called: http://tutorialsninja.com/demo/index.php.
It is designed as a practical example for learning modern test automation tools and techniques.
<p>
  <img src="Screenshots/QAfoxebsite.jpg" width="70%" title="Example for screenshot on failure"  />
    <img src="Screenshots/allure02.jpg" width="70%" title="Example for screenshot on failure"  />
</p>

## 📑 Technologies & Skill & Features
| Technologies      | Description |
| ----------- | ----------- |
| **Java:**      | The project is developed using Java, providing a robust and widely used programming language for automation.       |
| **TestNG:**   | TestNG is used as the testing framework, offering powerful test configuration options, parallel execution, and detailed reporting.        |
| **Selenium WebDriver:**   | The project includes Selenium WebDriver for automating browser interactions        |
| **Page Object Model (POM):**   | The project follows the POM design pattern, enhancing test maintainability and reusability by separating page elements and actions.        |
| **Allure Reports:**   | Test results are documented using Allure Reports, providing a clear and interactive visualization of test execution.        |
| **Maven:**   | 	A build automation tool that simplifies dependency management, project builds, and test execution processes.
| **Jenkins:**   | Continuous integration and continuous delivery (CI/CD) platform for automated builds and deployments.        |

## 📊 Reports
  ```bash
  mvn allure:serve
  ```
## 📊 Reports Examples
<p>
  <img src="Screenshots/allure01.jpg" width="40%" title="Example for screenshot on failure"  />
  <img src="Screenshots/allure02.jpg" width="40%" alt="Example for screenshot on failure" />
</p>

## 📖 Prerequisites

To work with this project, ensure you have the following installed:

1. **Java Development Kit (JDK)**  
   - **Version:** 22 or higher  
   - **Download:** [Java Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)  
   - **Verify installation:**
     ```bash
     java -version
     ```

2. **Apache Maven**  
   - **Version:** 3.8.5 or higher  
   - **Download:** [Maven Downloads](https://maven.apache.org/download.cgi)  
   - **Verify installation:**
     ```bash
     mvn -v
     ```

3. **Selenium WebDriver**  
   - Included as a dependency in the `pom.xml`. No manual installation is required.  
   - **Dependency:**
     ```xml
     <dependency>
         <groupId>org.seleniumhq.selenium</groupId>
         <artifactId>selenium-java</artifactId>
         <version>4.27.0</version>
     </dependency>
     ```

4. **TestNG Framework**  
   - Included as a dependency in the `pom.xml`. No manual installation is required.  
   - **Dependency:**
     ```xml
     <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>7.3.0</version>
         <scope>test</scope>
     </dependency>
     ```

## Recommended Development Environment

- **Eclipse IDE**  
  - Since you have experience with Eclipse, it is recommended to use it for developing and running the project.  
  - **Download:** [Eclipse Downloads](https://www.eclipse.org/downloads/)  
  - Ensure that:
    - You configure Eclipse to use **JDK 22**.  
    - Maven integration is properly set up in Eclipse.

---

This ensures your environment is correctly configured to work with the project.

## 🚀 Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/your-repo.git
    ```


## 📁 Project Structure
```
├── pom.xml
├── src/test
│   ├── java
│   │   ├── pageobjects
│   │   │   ├── BasePage.java
│   │   │   ├── CheckOutPage.java
│   │   │   ├── LaptopPage.java
│   │   │   ├── LaptopsAndNotebooksPage.java
│   │   │   ├── LoginPage.java
│   │   │   ├── MainPage.java
│   │   │   ├── MyCartPage.java
│   │   │   └── ProductComparisonPage.java
│   │   ├── tests
│   │   │   ├── AddRemoveDifferrentLaptopsToCartTests.java
│   │   │   ├── AddRemoveLaptopsToComparisonTests.java
│   │   │   ├── AddRemoveSameLaptopsToCartTests.java
│   │   │   ├── BaseTest.java
│   │   │   ├── CartTests.java
│   │   │   ├── ContactUsTests.java
│   │   │   ├── EndToEndTest.java
│   │   │   ├── FooterTests.java
│   │   │   ├── InspectLaptopTests.java
│   │   │   ├── LoginTests.java
│   │   │   ├── SearchTests.java
│   │   │   └── SortByTests.java
│   │   └── utils
│   │       └── Utils.java
│   └── resources
│       └── data
│           └── configuration.properties
└── testng.xml

```
Thanks for visiting my GitHub profile! 😊
Artyom Chernenko
