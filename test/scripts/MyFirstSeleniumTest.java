package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		// driver = new ChromeDriver();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

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

		if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Login successfull!!!!");
		} else {
			System.out.println(actualPageTitleAfterLogin);
			System.out.println("Login Failed!!!");
		}
	}

}
