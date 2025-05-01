package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	WebDriver driver;

	PageClassSaucedemo saucedemoPage;
	PageClassSaucedemoProducts productSaucedemo;
	TestDataSauceDemo sauceDemoTest;

	@BeforeTest
	public void initalization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		saucedemoPage = new PageClassSaucedemo(driver);
		productSaucedemo = new PageClassSaucedemoProducts(driver);
		sauceDemoTest = new TestDataSauceDemo();
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
