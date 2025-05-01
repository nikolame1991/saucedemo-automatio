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

public class PageClassSaucedemoProducts {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	// Element
	@FindBy(css = ".app_logo") // Provera naslova
	WebElement headingMiddle;

	@FindBy(css = ".bm-burger-button") // Provera dugme "Hamburg"
	WebElement clickHamburg;

	@FindBy(css = "#react-burger-cross-btn")
	WebElement clickCloseHamburg;
	/*-----------------------------------------------------------*/
	@FindBy(css = "#item_4_img_link > img") // kliknuti sliku
	WebElement clickImg;

	@FindBy(css = ".inventory_details_name.large_size") // Provera naslov proizvoda
	WebElement checkText;

	@FindBy(css = ".inventory_details_desc.large_size") // Provera dugackih tekstova
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
	/*----------------------------------------------------------*/
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

	/*---------------------------------------------------*/

	// Konstruktor
	public PageClassSaucedemoProducts(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Metod
	public void headingMiddle() {
		WebElement textMain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo")));

		// Uzimanja teksta iz elementa
		String actualMiddleText = textMain.getText();
		String expectedMiddleText = "Swag Labs";

		// Asertacija da li su naslovi isti
		assertTrue(actualMiddleText.equals(expectedMiddleText), "Nije dobar naslov");
	}

	// Dugme za slidebar hamburg
	public void clickHamburg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickHamburg)).click();
	}

	// Dugme za zatvaranje slidebar hamburg
	public void clickCloseHamburg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement closeBtn = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-cross-btn")));
			if (closeBtn.isDisplayed()) {
				closeBtn.click();
			}
		} catch (TimeoutException e) {
			System.out.println("Dugme za zatvaranje hamburger menija nije pronađeno na stranici.");
		} catch (Exception e) {
			System.out.println("Došlo je do greške pri zatvaranju hamburger menija: " + e.getMessage());
		}
	}

	/*-----------------------------------------------------------*/
	// kliknuti sliku
	public void clickImg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(clickImg)).click();
	}

	// Provera naslov proizvoda
	public void checkText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_details_name.large_size")));

		String actualTextCheck = checkText.getText();
		String expectedTextCheck = "Sauce Labs Backpack";

		assertTrue(actualTextCheck.equals(expectedTextCheck), "Nije dobar podnaslov");
	}

	// Provera skraceni tekst
	public void checkLongText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement longTextCheck = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_details_desc.large_size")));

		String actualTextLongContains = longTextCheck.getText();
		String expectedTextLongContains = "carry.";

		assertTrue(actualTextLongContains.contains(expectedTextLongContains), "Nije dobro skracen");
	}

	// Proveriti ispisanu cenu
	public void checkPrice() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement priceCheck = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_details_price")));

		String actualPriceCheck = priceCheck.getText();
		String expectedPriceCheck = "$29.99";

		assertTrue(actualPriceCheck.equals(expectedPriceCheck), "Nije dobra cena");
	}

	// provera dugme "Add to cart"
	public void checkButtonAddToCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement buttonAddToCart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart")));
		buttonAddToCart.click();
	}

	// pRovera dugme "Remove"
	public void checkButtonRemove() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement buttonRemove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#remove")));
		buttonRemove.click();
	}

	// provera dugme "Add to cart" PONOVO
	public void checkButtonAddToCartAgain() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement buttonAddToCart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart")));
		buttonAddToCart.click();
	}

	// Provera link Korpa
	public void checkShoppingCartLink() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement linkShoppingCartLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_link")));
		linkShoppingCartLink.click();
	}

	// Provera dugme "Remove" iz "Shopping Cart Link"
	public void removeFromShoppingCartLink() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement removeShoppingCartLink = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".btn.btn_secondary.btn_small.cart_button")));
		removeShoppingCartLink.click();
	}

	/*----------------------------------------------------------------*/
	public void verifyTShirt() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".pricebar #add-to-cart-sauce-labs-bolt-t-shirt"))).click();
	}

	public void clickCartIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}

	public void clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
	}

	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
	}

	public void enterPostalCode(String postalCode) {
		wait.until(ExpectedConditions.visibilityOf(postalCodeInput)).sendKeys(postalCode);
	}

	public void clickContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}

	public boolean isSummaryInfoVisible() {
		return wait.until(ExpectedConditions.visibilityOf(summaryInfo)).isDisplayed();
	}

	public void clickFinishButton() {
		wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
	}

	public String getCompleteHeaderText() {
		return wait.until(ExpectedConditions.visibilityOf(completeHeaderText)).getText();
	}

	public boolean isPonyImageVisible() {
		return wait.until(ExpectedConditions.visibilityOf(ponyImage)).isDisplayed();
	}

	public void clickBackHomeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
	}
}
