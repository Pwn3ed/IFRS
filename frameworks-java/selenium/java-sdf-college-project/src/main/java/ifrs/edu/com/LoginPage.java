package ifrs.edu.com;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * LoginPage
 */
public class LoginPage {
	private WebDriver driver;

	// <input type="text" class="form-input" name="username">
	private By nameInputBy = By.name("username");
	// <input type="password" class="form-input" name="password">
	private By passwordInputBy = By.name("password");
	// <input class="form-button" type="submit" value="Entrar">
	private By loginBy = By.className("form-button");
	// <a class="form-to-link" href="/register">não possui uma conta?
	// <em>Registre-se já!</em></a>
	private By linkSignInBy = By.className("form-to-link");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getCurrentUrl().equals("http://localhost:5173/login"))
			throw new IllegalStateException(
					"Está não é a página Login, página atual: " + driver.getCurrentUrl());
	}

	public HomePage loginUser(String name, String password) {
		this.driver.findElement(nameInputBy).sendKeys(name);
		this.driver.findElement(passwordInputBy).sendKeys(password);

		this.driver.findElement(loginBy).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		if (!alert.getText().equals("User logged succefully")) {
			alert.accept();
			throw new RuntimeException("Error on login");
		}

		alert.accept();

		return new HomePage(driver);
	}

	public SignInPage toSignInPage() {
		this.driver.findElement(linkSignInBy).click();
		return new SignInPage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}
}
