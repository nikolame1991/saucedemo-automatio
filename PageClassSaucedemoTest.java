package saucedemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageClassSaucedemoTest extends BaseTestClass {

	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// 1. Test case
	@Test
	public void loginWithOutCredentials() {
		saucedemoPage.loginLogo("");
		saucedemoPage.usernamePlaceholder("");
		saucedemoPage.passwordPlaceholder("");
		saucedemoPage.clickLoginButton();
	}

	// 2. test case
	@Test
	public void loginCorrectPassword() {
		saucedemoPage.loginLogo("");
		saucedemoPage.usernamePlaceholder("standard_user");
		saucedemoPage.passwordPlaceholder("secret_sauce");
		saucedemoPage.clickLoginButton();
	}

	// 3. Test Case
	@Test
	public void loginWrong() {
		saucedemoPage.usernamePlaceholder("kajsdhkajsd");
		saucedemoPage.passwordPlaceholder("alskdjlaksd");
		saucedemoPage.clickLoginButton();
	}
}
