package saucedemo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for verifying product page functionality on SauceDemo.
 * Includes interaction with product details, cart, checkout flow, and validations.
 */
public class PageClassSaucedemoProducts {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	// -------------------- Web Elements --------------------

	@FindBy(css = ".app_logo")
	WebElement headingMiddle;

	@FindBy(css = ".bm-burger-button")
	WebElement clickHamburg;

	@FindBy(css = "#react-burger-cross-btn")
	WebElement clickCloseHamburg;

	@FindBy(css = "#item_4_img_link > img")
	WebElement clickImg;

	@FindBy(css = ".inventory_details_name.large_size")
	WebElement checkText;

	@FindBy(css = ".inventory_details_desc.large_size")
	WebElement checkLongText;

	@FindBy(css = ".inventory_details_price")
	WebElement checkPrice;

	@FindBy(css = "#add-to-cart")
	WebElement checkButtonAddToCart;

	@FindBy(css = "#remove")
	WebElement checkButtonRemove;

	@FindBy(css = "#add-to-cart")
	WebElement checkButtonAddToCartAgain;

	@FindBy(css = ".shopping_cart_link")
	WebElement checkShoppingCartLink;

	@FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
	WebElement removeFromShoppingCartLink;

	@FindBy(css = "#continue-shopping")
	WebElement clickButtonContinueShopping;

	@FindBy(css = ".pricebar #add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement clickTshirt;

	@FindBy(css = "a.shopping_cart_link")
	WebElement cartIcon;

	@FindBy(css = "button#checkout")
	WebElement checkoutButton;

	@FindBy(css = "input#first-name")
	WebElement firstNameInput;

	@FindBy(css = "input#last-name")
	WebElement lastNameInput;

	@FindBy(css = "input#postal-code")
	WebElement postalCodeInput;

	@FindBy(css = "input#continue")
	WebElement continueButton;

	@FindBy(css = "div.summary_info")
	WebElement summaryInfo;

	@FindBy(css = "button#finish")
	WebElement finishButton;

	@FindBy(css = "h2.complete-header")
	WebElement completeHeaderText;

	@FindBy(css = "img[alt='Pony Express']")
	WebElement ponyImage;

	@FindBy(css = "button#back-to-products")
	WebElement backHomeButton;

	// -------------------- Constructor --------------------

	/**
	 * Constructor initializes WebDriver, WebDriverWait, Actions, and PageFactory.
	 */
	public PageClassSaucedemoProducts(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// -------------------- Methods --------------------

	/** Verifies main header "Swag Labs" is visible */
	public void headingMiddle() {
		WebElement textMain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo")));
		String actual = textMain.getText();
		String expected = "Swag Labs";
		assertTrue(actual.equals(expected), "Header is incorrect.");
	}

	/** Opens sidebar (hamburger) menu */
	public void clickHamburg() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHamburg)).click();
	}

	/** Closes sidebar menu if present */
	public void clickCloseHamburg() {
		try {
			WebElement closeBtn = wait.until(ExpectedConditions.visibilityOf(clickCloseHamburg));
			if (closeBtn.isDisplayed()) closeBtn.click();
		} catch (TimeoutException e) {
			System.out.println("Sidebar close button not found.");
		}
	}

	/** Clicks on product image */
	public void clickImg() {
		wait.until(ExpectedConditions.elementToBeClickable(clickImg)).click();
	}

	/** Verifies product title is correct */
	public void checkText() {
		wait.until(ExpectedConditions.visibilityOf(checkText));
		assertTrue(checkText.getText().equals("Sauce Labs Backpack"), "Product title mismatch.");
	}

	/** Verifies product description contains expected substring */
	public void checkLongText() {
		wait.until(ExpectedConditions.visibilityOf(checkLongText));
		assertTrue(checkLongText.getText().contains("carry."), "Product description mismatch.");
	}

	/** Verifies product price is as expected */
	public void checkPrice() {
		wait.until(ExpectedConditions.visibilityOf(checkPrice));
		assertTrue(checkPrice.getText().equals("$29.99"), "Product price is incorrect.");
	}

	/** Clicks "Add to Cart" */
	public void checkButtonAddToCart() {
		wait.until(ExpectedConditions.visibilityOf(checkButtonAddToCart)).click();
	}

	/** Clicks "Remove" button */
	public void checkButtonRemove() {
		wait.until(ExpectedConditions.visibilityOf(checkButtonRemove)).click();
	}

	/** Clicks "Add to Cart" again */
	public void checkButtonAddToCartAgain() {
		wait.until(ExpectedConditions.visibilityOf(checkButtonAddToCartAgain)).click();
	}

	/** Clicks on shopping cart icon */
	public void checkShoppingCartLink() {
		wait.until(ExpectedConditions.visibilityOf(checkShoppingCartLink)).click();
	}

	/** Removes item from cart */
	public void removeFromShoppingCartLink() {
		wait.until(ExpectedConditions.visibilityOf(removeFromShoppingCartLink)).click();
	}

	/** Clicks add-to-cart on T-shirt */
	public void verifyTShirt() {
		wait.until(ExpectedConditions.elementToBeClickable(clickTshirt)).click();
	}

	/** Clicks shopping cart icon */
	public void clickCartIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}

	/** Clicks checkout button */
	public void clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
	}

	/** Inputs first name */
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
	}

	/** Inputs last name */
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
	}

	/** Inputs postal code */
	public void enterPostalCode(String postalCode) {
		wait.until(ExpectedConditions.visibilityOf(postalCodeInput)).sendKeys(postalCode);
	}

	/** Clicks Continue in checkout */
	public void clickContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}

	/** Checks if checkout summary info is visible */
	public boolean isSummaryInfoVisible() {
		return wait.until(ExpectedConditions.visibilityOf(summaryInfo)).isDisplayed();
	}

	/** Finalizes checkout */
	public void clickFinishButton() {
		wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
	}

	/** Gets final confirmation header text */
	public String getCompleteHeaderText() {
		return wait.until(ExpectedConditions.visibilityOf(completeHeaderText)).getText();
	}

	/** Verifies that Pony Express image is visible */
	public boolean isPonyImageVisible() {
		return wait.until(ExpectedConditions.visibilityOf(ponyImage)).isDisplayed();
	}

	/** Clicks "Back Home" button */
	public void clickBackHomeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
	}
}
