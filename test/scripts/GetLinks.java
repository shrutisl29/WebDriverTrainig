package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetLinks {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test // Test case1
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://www.google.com/");
		List<WebElement> allGoogleLinks= driver.findElements(By.xpath("//a"));
		System.out.println("Total links are: "+allGoogleLinks.size());
		
		for(org.openqa.selenium.WebElement oneElement:allGoogleLinks)
		{
			System.out.println(oneElement.getText()+" - "+oneElement.getAttribute("href"));
		}
		
	}
 
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
 
	

}
