package ifrs.edu.com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * SystemTest
 */
@TestMethodOrder(OrderAnnotation.class)
public class SystemTest {
	private static WebDriver driver;
	private static String username;
	private static String password;

	@BeforeAll
	public static void setup() {
		SystemTest.driver = new ChromeDriver();

		driver.get("http://localhost:5173");

		SystemTest.username = UUID.randomUUID().toString();
		SystemTest.password = UUID.randomUUID().toString();
	}

	@AfterAll
	public static void end() {
		SystemTest.driver.close();
	}

	@Test
	@Order(1)
	public void signInTest() {
		LoginPage loginPage = new LoginPage(SystemTest.driver);
		SignInPage signInPage = loginPage.toSignInPage();

		HomePage homePage = signInPage.signInValidUser("SystemTest is a test USER", "99", SystemTest.username, SystemTest.password);
		assertTrue(homePage.getDriver().getPageSource().contains("global chat"));
	}

	@Test
	@Order(2)
	public void logoutTest() {
		HomePage homePage = new HomePage(SystemTest.driver);
		ProfilePage profilePage = homePage.toProfilePage();

		LoginPage loginPage = profilePage.logout();
		assertTrue(loginPage.getDriver().getPageSource().contains("login page"));
	}

	@Test
	@Order(3)
	public void loginTest() {
		LoginPage loginPage = new LoginPage(SystemTest.driver);

		HomePage homePage = loginPage.loginUser(SystemTest.username, SystemTest.password);
		assertTrue(homePage.getDriver().getPageSource().contains("global chat"));
	}

	@Test
	@Order(4)
	public void sendMessageTest() {
		HomePage homePage = new HomePage(SystemTest.driver);

		assertTrue(homePage.sendMessage(username + password));
	}

	@Test
	@Order(5)
	public void clearMessagesTest() {
		HomePage homePage = new HomePage(SystemTest.driver);

		assertFalse(homePage.sendMessage("/clear"));
	}

	@Test
	@Order(6)
	public void deleteAccountTest() {
		HomePage homePage = new HomePage(SystemTest.driver);
		ProfilePage profilePage = homePage.toProfilePage();

		LoginPage loginPage = profilePage.deleteAccount(SystemTest.password);
		assertTrue(loginPage.getDriver().getPageSource().contains("login page"));
	}

	@Test
	@Order(7)
	public void loginNotFoundTest() {
		LoginPage loginPage = new LoginPage(SystemTest.driver);

		assertThrows(RuntimeException.class, () -> {
			loginPage.loginUser(SystemTest.username, SystemTest.password);
		});
	}
}
