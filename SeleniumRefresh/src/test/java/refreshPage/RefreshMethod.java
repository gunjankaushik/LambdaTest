package refreshPage;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RefreshMethod {

	
	
	   public String username = "gunjan.kaushik02";
	   public String accesskey = "u0eYRVCWaeeGqyojwoPrQ5HqWDVto3sFZPIlKJxvCC1acpZKsb";
	   WebDriver driver = null;
	   
	   
	@BeforeClass
	public void setUp() {
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("114.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accesskey);
		ltOptions.put("project", "Refresh Page using Selenium");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		try
	       {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + "@hub.LambdaTest.com/wd/hub"), browserOptions);
	       }
	       catch (Exception e)
	       {
	           System.out.println(e.getMessage());
	       }

		driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
	}
	
	
	@Test
	public void navigateRefreshMethod() throws InterruptedException  {

		
		//Perform clicking on Get Random User button
		driver.findElement(By.xpath("//button[@id ='save']")).click();
		//Using the sleep method since the loading takes time.
		Thread.sleep(5000);
		//Capture the first name
		String user =driver.findElement(By.xpath("//*[@id='loading']")).getText();
		//Printing the captured text
		System.out.println(user);
		//Refresh the page
		driver.navigate().refresh();
		//Using the sleep method since the loading takes time.
		Thread.sleep(5000);
		//Checking if the web element that displays user names is displayed and storing the boolean value
		boolean val = driver.findElement(By.xpath("//*[@id='loading']")).isDisplayed();
		//Asserting that the element is not displayed
		Assert.assertEquals(val, false,"Element is present!");
		
	}
	
	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();

	}

}
