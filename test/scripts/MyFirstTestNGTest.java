package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class MyFirstTestNGTest {
	WebDriver driver;

	
	 @Test //test case
	 public void googleSearch() {
	 driver.get("https://www.goggle.com");
	 driver.findElement(By.name("q")).sendKeys("Selenium Training");
	  }
	 
	@Test // test case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("stc123");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12345");

		// username.submit(); //using submit() we can submit the form (form tag in html)
		password.submit();

		String expectedPageTitleAfterLogin = "My account";
		Thread.sleep(5000);
		String actualPageTitleAfterLogin = driver.getTitle();

		/*
		 * if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
		 * System.out.println("Login successfull!!!!"); } else {
		 * System.out.println(actualPageTitleAfterLogin);
		 * System.out.println("Login Failed!!!"); }
		 */
		assertEquals(actualPageTitleAfterLogin, expectedPageTitleAfterLogin, "Page title is not as expected.");

	}

	@BeforeMethod // executes before every Test. Can be used for pre-requisites
	public void beforeMethod() {
		System.out.println("I executes before every Test");

	}

	@AfterMethod // executes after every Test
	public void afterMethod() {
		System.out.println("I executes after every Test");
	}

	@BeforeClass // executes only once before 1st test
	public void beforeClass() {
		// driver = new ChromeDriver();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterClass // executes only once after last test is executed
	public void afterClass() {
		driver.quit();
	}

}
