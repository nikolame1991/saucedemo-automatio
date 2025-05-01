package saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class saucedemoProductsTest extends BaseTestClass {

	@BeforeMethod
	public void navigationLogin() {
		driver.navigate().to("https://www.saucedemo.com/");
		saucedemoPage.usernamePlaceholder("standard_user");
		saucedemoPage.passwordPlaceholder("secret_sauce");
		saucedemoPage.clickLoginButton();

	}

	// Test case 1
	@Test
	public void verifySwaglabstoNewWindow() {
		productSaucedemo.headingMiddle(); // Pozivanje metode za testiranje "Swag Labs" naslova
		productSaucedemo.clickHamburg();
		productSaucedemo.clickCloseHamburg();
	}

	// Test case 2
	@Test
	public void verifyImg() {
		productSaucedemo.clickImg();
		productSaucedemo.checkText();
		productSaucedemo.checkLongText(); // Provera skraceni text
		productSaucedemo.checkPrice();
		productSaucedemo.checkButtonAddToCart();
		productSaucedemo.checkButtonRemove();
		productSaucedemo.checkButtonAddToCartAgain();
		productSaucedemo.checkShoppingCartLink();
		productSaucedemo.removeFromShoppingCartLink();
	}

	/*---------------------------------------------------*/
	// Test case 3
	@Test
	public void verifyTShirt() {
		productSaucedemo.verifyTShirt();
		productSaucedemo.clickCartIcon();
		productSaucedemo.clickCheckoutButton();
		productSaucedemo.enterFirstName("Nikola");
		productSaucedemo.enterLastName("Medan");
		productSaucedemo.enterPostalCode("21000");
		productSaucedemo.clickContinueButton();

		Assert.assertTrue(productSaucedemo.isSummaryInfoVisible());

		productSaucedemo.clickFinishButton();

		Assert.assertEquals(productSaucedemo.getCompleteHeaderText(), "Thank you for your order!");
		Assert.assertTrue(productSaucedemo.isPonyImageVisible());

		productSaucedemo.clickBackHomeButton();
	}

	/*----------------------------------------------------*/
	// Test case 4
	@Test(dataProvider = "userData", dataProviderClass = TestDataSauceDemo.class)
	public void verifyTest(String firstName, String lastName, String postalCode) {

		productSaucedemo.clickCartIcon();
		productSaucedemo.clickCheckoutButton();
		productSaucedemo.enterFirstName(sauceDemoTest.correctFirstName);
		productSaucedemo.enterLastName(sauceDemoTest.correctLastName);
		productSaucedemo.enterPostalCode(sauceDemoTest.correctPostCard);
		productSaucedemo.clickContinueButton();
		productSaucedemo.clickFinishButton();

		Assert.assertTrue(productSaucedemo.isSummaryInfoVisible());

		productSaucedemo.clickFinishButton();

		Assert.assertEquals(productSaucedemo.getCompleteHeaderText(), "Thank you for your order!");
		Assert.assertTrue(productSaucedemo.isPonyImageVisible());

		productSaucedemo.clickBackHomeButton();
	}
}
