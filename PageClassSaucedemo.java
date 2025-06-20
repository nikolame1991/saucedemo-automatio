package saucedemo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object class for handling login-related functionality on the SauceDemo site.
 * Contains methods for entering credentials, clicking login, and verifying error messages.
 */
public class PageClassSaucedemo {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	// -------------------- Web Elements --------------------

	@FindBy(css = "#root > div > div.login_logo")
	public WebElement loginLogo;

	@FindBy(css = "#user-name")
	public WebElement placeholderUserName;

	@FindBy(css = "#password")
	public WebElement placehodlerPassword;

	@FindBy(css = "#login-button")
	public WebElement clickLoginButton;

	@FindBy(css = "svg.fa-times-circle")
	public List<WebElement> inputErrorIcons;

	@FindBy(css = "button.error-button > svg.fa-times")
	public WebElement closeErrorButton;

	@FindBy(css = "div.error-message-container.error")
	public WebElement errorMessageBox;

	// -------------------- Constructor --------------------

	/**
	 * Initializes WebDriver, Actions, WebDriverWait and PageFactory elements.
	 * 
	 * @param driver WebDriver instance
	 */
	public PageClassSaucedemo(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// -------------------- Methods --------------------

	/**
	 * Verifies that the login logo text matches the expected title.
	 * Waits until the element is visible and compares its text.
	 */
	public void loginLogo(String logoLogin) {
		WebElement mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#root > div > div.login_logo")));

		String actualMainTitle = mainTitle.getText();
		String expectedMainTitle = "Swag Labs";

		assertTrue(actualMainTitle.equals(expectedMainTitle), "Login page title is incorrect.");
	}

	/**
	 * Enters the username into the username input field.
	 * 
	 * @param username The username to input
	 */
	public void usernamePlaceholder(String username) {
		placeholderUserName.sendKeys(username);
		placeholderUserName.click();
	}

	/**
	 * Enters the password into the password input field.
	 * 
	 * @param password The password to input
	 */
	public void passwordPlaceholder(String password) {
		placehodlerPassword.sendKeys(password);
		placehodlerPassword.click();
	}

	/**
	 * Clicks the login button after waiting until it's clickable.
	 */
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickLoginButton)).click();
	}

	/**
	 * Verifies that two input error icons (SVG) are displayed after invalid login.
	 */
	public void checkInputErrorIconsDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(inputErrorIcons));
		assertTrue(inputErrorIcons.size() == 2, "Both input error icons are not displayed.");
	}

	/**
	 * Verifies that the "X" close button in the error message is displayed.
	 */
	public void checkCloseErrorButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(closeErrorButton));
		assertTrue(closeErrorButton.isDisplayed(), "The close (X) button is not visible.");
	}

	/**
	 * Verifies that the error message box is displayed on failed login.
	 */
	public void checkErrorMEssageBoxDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(errorMessageBox));
		assertTrue(errorMessageBox.isDisplayed(), "The error message box is not displayed.");
	}
}
