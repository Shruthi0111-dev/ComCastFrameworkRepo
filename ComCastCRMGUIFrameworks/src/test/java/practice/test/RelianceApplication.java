package practice.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RelianceApplication {

	@Test
	public void loginApp() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.reliancedigital.in");
		
        driver.findElement(By.id("wzrk-cancel")).click();

		WebElement ele = driver.findElement(By.id("RIL_MobilesTabletsNavigationNode"));		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
        
		WebElement ele1 = driver.findElement(By.xpath("//a[.='Best Deals on OnePlus CE3 Lite']/../../li[1]/a[text()='Smartphones']"));
		Actions act1 = new Actions(driver);
		act.moveToElement(ele1).click().perform();

		driver.findElement(By.xpath("//p[text()='Tecno Pop 9 5G 128 GB, 4 GB RAM, Midnight Shadow, Mobile Phone']")).click();
		
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='9,399.00']"));
		String text = ele2.getText();
		System.out.println(text);
		
		driver.findElement(By.id("add_to_cart_main_btn")).click();
		
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Please enter a valid pincode']"));
		String text1 = ele3.getText();
		System.out.println(text1);
		
		 
		
		
		//driver.quit();
		
	}
}
