package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Base test class for SauceDemo automation project.
 * Handles WebDriver initialization and page object instantiation.
 * All test classes extend this class to inherit the setup and teardown logic.
 */
public class BaseTestClass {
	WebDriver driver;

	PageClassSaucedemo saucedemoPage;                 // Page Object for login and general page actions
	PageClassSaucedemoProducts productSaucedemo;      // Page Object for product-related actions
	TestDataSauceDemo sauceDemoTest;                  // Class containing test data (e.g. valid credentials)

	@BeforeTest
	public void initalization() {
		// Initialize Chrome browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Instantiate Page Object Model classes and test data
		saucedemoPage = new PageClassSaucedemo(driver);
		productSaucedemo = new PageClassSaucedemoProducts(driver);
		sauceDemoTest = new TestDataSauceDemo();
	}

	@AfterTest
	public void closeDriver() {
		// Quit the browser after tests are completed
		driver.quit();
	}
}
