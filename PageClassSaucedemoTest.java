package saucedemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TestNG test class for SauceDemo login page.
 * Contains multiple test cases verifying login behavior with various credential scenarios.
 * Uses Page Object Model class PageClassSaucedemo for UI interactions and assertions.
 */
public class PageClassSaucedemoTest extends BaseTestClass {

    /**
     * Navigates to the SauceDemo homepage before each test method.
     */
    @BeforeMethod
    public void navigation() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    /**
     * Clears all browser cookies after each test to ensure clean state between tests.
     */
    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    /**
     * Test Case 1: Attempt login without entering any credentials.
     * Verifies the error handling for empty username and password.
     */
    @Test
    public void loginWithOutCredentials() {
        saucedemoPage.loginLogo("");                 // Verify login page logo is present
        saucedemoPage.usernamePlaceholder("");       // Enter empty username
        saucedemoPage.passwordPlaceholder("");       // Enter empty password
        saucedemoPage.clickLoginButton();             // Attempt login
        // Assertions for error messages are inside PageClassSaucedemo methods
    }

    /**
     * Test Case 2: Successful login using valid credentials.
     * Username: standard_user
     * Password: secret_sauce
     */
    @Test
    public void loginCorrectPassword() {
        saucedemoPage.loginLogo("");                 // Verify login page logo is present
        saucedemoPage.usernamePlaceholder("standard_user");  // Enter valid username
        saucedemoPage.passwordPlaceholder("secret_sauce");   // Enter valid password
        saucedemoPage.clickLoginButton();                     // Attempt login
        // Additional assertions can be added in future to verify successful login
    }

    /**
     * Test Case 3: Attempt login with invalid credentials.
     * Verifies that login fails and error is displayed.
     */
    @Test
    public void loginWrong() {
        saucedemoPage.usernamePlaceholder("kajsdhkajsd");    // Enter invalid username
        saucedemoPage.passwordPlaceholder("alskdjlaksd");    // Enter invalid password
        saucedemoPage.clickLoginButton();                     // Attempt login
        // Assertions for error messages are inside PageClassSaucedemo methods
    }
}
