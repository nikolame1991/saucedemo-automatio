package saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * Test class for verifying functionality of product interactions
 * and checkout process on SauceDemo application.
 *
 * This class uses the Page Object Model (POM) structure
 * and includes parameterized testing with TestNG DataProvider.
 */
public class saucedemoProductsTest extends BaseTestClass {

    /**
     * Before each test, navigate to login page and perform login with standard user credentials.
     */
    @BeforeMethod
    public void navigationLogin() {
        driver.navigate().to("https://www.saucedemo.com/");
        saucedemoPage.usernamePlaceholder("standard_user");
        saucedemoPage.passwordPlaceholder("secret_sauce");
        saucedemoPage.clickLoginButton();
    }

    /**
     * ✅ Test Case 1: Verify main heading "Swag Labs" and test hamburger menu functionality.
     */
    @Test
    public void verifySwaglabstoNewWindow() {
        productSaucedemo.headingMiddle();       // Verifies heading text
        productSaucedemo.clickHamburg();        // Opens hamburger menu
        productSaucedemo.clickCloseHamburg();   // Closes hamburger menu
    }

    /**
     * ✅ Test Case 2: Full product details interaction:
     * - Click on product image
     * - Verify product title, description, price
     * - Add to cart, remove, add again
     * - Navigate to shopping cart and remove item
     */
    @Test
    public void verifyImg() {
        productSaucedemo.clickImg();
        productSaucedemo.checkText();
        productSaucedemo.checkLongText();
        productSaucedemo.checkPrice();
        productSaucedemo.checkButtonAddToCart();
        productSaucedemo.checkButtonRemove();
        productSaucedemo.checkButtonAddToCartAgain();
        productSaucedemo.checkShoppingCartLink();
        productSaucedemo.removeFromShoppingCartLink();
    }

    /**
     * ✅ Test Case 3: End-to-end checkout flow with hardcoded user data:
     * - Add T-Shirt to cart
     * - Fill checkout form
     * - Verify order summary and success message
     */
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

    /**
     * ✅ Test Case 4: Parameterized checkout test using DataProvider
     * - Runs the checkout flow for multiple sets of user data
     */
    @Test(dataProvider = "userData", dataProviderClass = TestDataSauceDemo.class)
    public void verifyTest(String firstName, String lastName, String postalCode) {
        productSaucedemo.clickCartIcon();
        productSaucedemo.clickCheckoutButton();
        productSaucedemo.enterFirstName(sauceDemoTest.correctFirstName);
        productSaucedemo.enterLastName(sauceDemoTest.correctLastName);
        productSaucedemo.enterPostalCode(sauceDemoTest.correctPostCard);
        productSaucedemo.clickContinueButton();

        Assert.assertTrue(productSaucedemo.isSummaryInfoVisible());
        productSaucedemo.clickFinishButton();

        Assert.assertEquals(productSaucedemo.getCompleteHeaderText(), "Thank you for your order!");
        Assert.assertTrue(productSaucedemo.isPonyImageVisible());

        productSaucedemo.clickBackHomeButton();
    }
}
