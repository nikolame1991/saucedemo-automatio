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

public class PageClassSaucedemo {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	// Elementi
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

	/*
	 * @FindBy(css = "#login_credentials") public WebElement showLoginCredentials;
	 * 
	 * @FindBy(css = "#login_password") public WebElement showLoginPassword;
	 */

	// Konstruktor
	public PageClassSaucedemo(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Metod
	// Provera naslova
	public void loginLogo(String logoLogin) {
		// sacekati dok se ne pojavi "Naslov" element
		WebElement mainTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div.login_logo")));

		// Uzimanja teksta iz elementa
		String actualMainTitle = mainTitle.getText();
		String expectedMainTitle = "Swag Labs";

		// Asertacija da li su naslovi isti
		assertTrue(actualMainTitle.equals(expectedMainTitle), "Nije dobar naslov");
	}

	// Metod za login
	public void usernamePlaceholder(String username) {
		placeholderUserName.sendKeys(username);
		placeholderUserName.click();
	}

	// Metod za password
	public void passwordPlaceholder(String password) {
		placehodlerPassword.sendKeys(password);
		placehodlerPassword.click();
	}

	// Metod za dugme
	public void clickLoginButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickLoginButton)).click();
	}

	// za prikaz 2 SVG ikonice za greske
	public void checkInputErrorIconsDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(inputErrorIcons));
		// Provera da li su oba prikazana
		assertTrue(inputErrorIcons.size() == 2, "Nisu prikazane obe ikone za gresku");
	}

	// prikaz za drugo dugme "X"
	public void checkCloseErrorButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(closeErrorButton));
		assertTrue(closeErrorButton.isDisplayed(), "X dugme za zatvaranje nije prikazano");
	}

	// Poruka za greske
	public void checkErrorMEssageBoxDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(errorMessageBox));
		assertTrue(errorMessageBox.isDisplayed(), "Poruka o gresci nije prikazana");
	}

}
