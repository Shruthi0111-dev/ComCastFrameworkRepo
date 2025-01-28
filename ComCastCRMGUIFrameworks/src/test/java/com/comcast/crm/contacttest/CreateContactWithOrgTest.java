package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {

		/* create object */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//read common data from property file
				String BROWSER = fLib.getDataFromPropertiesFile("browser");
				String URL = fLib.getDataFromPropertiesFile("url");
				String USERNAME = fLib.getDataFromPropertiesFile("username");
				String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		
		//read testscript data from excel file and random number
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandumNumber();
		String orgName = eLib.getDataFromExcel("contact", 7, 2);
		
		
		 WebDriver driver = new FirefoxDriver();
		 
		 
		 //Step 1: Login to app
		 wLib.maximizethewindow(driver);
		 wLib.waitForPageToLoad(driver);
		 driver.get(URL);
		 
		  LoginPage lp = new LoginPage(driver);
		
		  lp.getUsernameEdt().sendKeys("admin");
		  lp.getPasswordEdt().sendKeys("admin");
		  lp.getLoginBtn().click();
		  
		//Step 2: navigate to contact module
		  Homepage hp = new Homepage(driver);
		  hp.getContactLnk().click();
		  
		  //Step 3: click on "create contact" button
		  ContactPage cp = new ContactPage(driver);
		  cp.getCreateNewContBtn().click();
		  
		  //step 4: enter all the details & create new contact
		  CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		  cncp.createContactWithOrg(driver, orgName, lastName);
          
        
	       //verify Header msg expected result String actheaderInfo =
	      ContactInformationPage cip = new ContactInformationPage(driver);
	      String actLastName = cip.getLastNameInfoMsg().getText();
	      if(actLastName.contains(lastName)) {
				System.out.println(actLastName + " is verified==>Pass"); }
		    else {
				System.out.println(actLastName + " is not verified==>Fail"); }

			
		    //Step 8:Logout
			  hp.logout();
				
			  driver.quit();
			  
			  
			  
			  
			  
			  
			/* * //verify Header orgName expected result String actOrgName =
			 * driver.findElement(By.id("dtlview_Organization")).getText();
			 * System.out.println(actOrgName); if(actOrgName.trim().equals(orgName)) {
			 * System.out.println(orgName + " is created==>Pass"); }else {
			 * System.out.println(orgName + " is not created==>Fail"); }*/
			 
		  
		  
		
		  
	}

	}
		  
		  /*
			 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).
			 * click(); driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			 */
			  
		  

	
