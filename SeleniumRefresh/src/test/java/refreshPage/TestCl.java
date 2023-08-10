package refreshPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCl {

	
	@Test
	public void testOne() throws InterruptedException {
		// TODO Auto-generated method stub
		//Set up the webdriver manager for chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Create the webdriver object
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Navigate to a URL
		driver.get("https://www.lambdatest.com/selenium-playground");
		
	driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
//		
//		driver.findElement(By.id("user-message")).sendKeys("Input text one");
//		
//		driver.findElement(By.id("showInput")).click();
//		
//		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys("10");
//		
//		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys("5");
//		
//		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
//		
//		String sum = driver.findElement(By.id("addmessage")).getText();
//		
//		System.out.println(sum);

		//Perform clicking on Get Random User button
				driver.findElement(By.id("user-message")).sendKeys("Test Message");
				//Using the sleep method since the loading takes time.
				//Thread.sleep(5000);
				driver.findElement(By.id("showInput")).click();
				//Capture the first name
				String msg =driver.findElement(By.id("message")).getText();
				//Printing the captured text
				System.out.println(msg);
				//Locating the web page through body tag and performing key press
				driver.findElement(By.tagName("body")).sendKeys("\\uE035");
				//Using the sleep method since the loading takes time.
				Thread.sleep(5000);
				//Checking if the web element that displays user names is displayed and storing the boolean value
				boolean val = driver.findElement(By.id("message")).isDisplayed();
				//Asserting that the element is not displayed
				Assert.assertEquals(val, false,"Element is present!");
	}

}
