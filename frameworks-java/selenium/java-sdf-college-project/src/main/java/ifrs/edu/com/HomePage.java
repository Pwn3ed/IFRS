package ifrs.edu.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage
 */
public class HomePage {
	private WebDriver driver;

	// <label className="message-raw">{message.text}</label>
	private By messageBy = By.className("message-raw");
	// <input ref={chatText} type="text" className="chat-text-input"
	// onChange={changeHandler} onKeyDown={enterHandler} />
	private By messageInputBy = By.className("chat-text-input");
	// <input type="submit" value="enviar" className="chat-text-submit"
	// onClick={clickHandler} />
	private By messageSendBy = By.className("chat-text-submit");
	// <a id="link-to-profile" class="nav-link" href="/profile"></a>
	private By linkProfileBy = By.id("link-to-profile");

	public HomePage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getCurrentUrl().equals("http://localhost:5173/"))
			throw new IllegalStateException(
					"Está não é a página Home, página atual: " + driver.getCurrentUrl());
	}

	public boolean sendMessage(String message) {
		this.driver.findElement(messageInputBy).sendKeys(message);
		this.driver.findElement(messageSendBy).click();
		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}
		return this.driver.findElements(messageBy).stream().map(mess -> mess.getText())
				.filter(mess -> mess.equals(message)).count() > 0;
	}

	public ProfilePage toProfilePage() {
		this.driver.findElement(linkProfileBy).click();
		return new ProfilePage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}
}
