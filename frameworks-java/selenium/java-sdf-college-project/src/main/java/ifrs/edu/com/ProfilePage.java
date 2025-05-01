package ifrs.edu.com;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ProfilePage
 */
public class ProfilePage {
	private WebDriver driver;

	// <button className="basic-button" name="logout-button" />
	private By logoutBy = By.name("logout-button");
	// <button className="basic-button" name="delete-account-button"/>
	private By deleteAccountBy = By.name("delete-account-button");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getCurrentUrl().equals("http://localhost:5173/profile"))
			throw new IllegalStateException(
					"Está não é a página Profile, página atual: " + driver.getCurrentUrl());
	}

	public LoginPage logout() {
		this.driver.findElement(logoutBy).click();
		return new LoginPage(driver);
	}

	public LoginPage deleteAccount(String password) {
		this.driver.findElement(deleteAccountBy).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

		try {
			Alert prompt = wait.until(ExpectedConditions.alertIsPresent());

			prompt.sendKeys(password);
			prompt.accept();

			wait.until(ExpectedConditions.alertIsPresent());
			Alert confirmationAlert = driver.switchTo().alert();
			String alertText = confirmationAlert.getText();
			confirmationAlert.accept();

			if (!alertText.equals("User succefully deleted!"))
				throw new RuntimeException("Error deleting Account: " + alertText);
		} catch (Exception e) {
			throw new RuntimeException("Error deleting account: " + e.getMessage());
		}

		return new LoginPage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}
}
