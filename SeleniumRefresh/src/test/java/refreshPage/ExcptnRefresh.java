package refreshPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcptnRefresh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				//Set up the webdriver manager for chrome driver
				WebDriverManager.chromedriver().setup();
				
				//Create the webdriver object
				WebDriver driver = new ChromeDriver();
				
				//Navigate to a URL
				driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
				
				//Perform some action
				driver.findElement(By.xpath("//button[@id ='save']")).click();
				
				//Exception Handling using try-catch block
				try {
					//Refresh the page
					driver.navigate().refresh();	
				}
				catch(Exception e){
					System.out.println("Exception occurred during page refresh : " +e.getMessage());
				}
				
				
				//Close the browser
				driver.quit();

	}

}
