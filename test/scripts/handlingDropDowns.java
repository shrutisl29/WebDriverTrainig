package scripts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class handlingDropDowns {
	WebDriver driver;
	 
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test // Test case1
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		WebElement make =driver.findElement(By.name("make"));
		List<WebElement> options = driver.findElement(By.name("make")).findElements(By.tagName("option"));
	
		Select makeCombo = new Select(make); //make is WebElement of Dropdown, Select is class in Selenium
		makeCombo.selectByIndex(1);
		Thread.sleep(3000);
		makeCombo.selectByValue("mercedes");
		Thread.sleep(3000);
		makeCombo.selectByVisibleText("Audi");
		assertEquals(makeCombo.getOptions().size(),4); //getOptions returns all option elements as List<WebElemt>
		System.out.println(makeCombo.getOptions().size());

		List<String> actualMakeOption, expectedMakeOptions;
		expectedMakeOptions = new ArrayList<String> ();
		actualMakeOption = new ArrayList<String> ();
		expectedMakeOptions.add("BMW");		
		expectedMakeOptions.add("Mercedes");		
		expectedMakeOptions.add("Audi");		
		expectedMakeOptions.add("Honda");		
		
		List<WebElement> allOpt = makeCombo.getOptions();
		for(WebElement oneOpt:allOpt) {
			actualMakeOption.add(oneOpt.getText());
		}
		assertEquals(actualMakeOption,expectedMakeOptions);		
	}
 
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
