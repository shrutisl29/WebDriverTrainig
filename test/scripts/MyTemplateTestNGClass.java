package scripts;
 
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
 
import static org.testng.Assert.*;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
 
public class MyTemplateTestNGClass {

	WebDriver driver;
 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test // Test case1
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("");
	}
 
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
