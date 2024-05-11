package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment24march {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test // Test case1
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://twitter.com/");
		
		List<WebElement> links = driver.findElements(By.xpath("//div"));
		System.out.println("No. of a tags: "+links.size());
	}
	
	@Test
	public void cookieRelatedMethods() throws InterruptedException {
		driver.get("https://twitter.com/");
		driver.manage().window().fullscreen();
		//System.out.println("Fullscreen");
		//Thread.sleep(7000);
		//driver.manage().window().minimize();
		System.out.println(driver.manage().window().getPosition());
		Dimension position = new Dimension(800,800);
		driver.manage().window().setSize(position);
		
	}
 
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
