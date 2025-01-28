package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test
	public void getProductInfoTest(String x)
	{
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://www.amazon.in/");
	    
	  //search product
	  		CharSequence brandName = null;
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
	  		
	}
	}