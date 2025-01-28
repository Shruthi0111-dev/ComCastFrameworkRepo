package com.comcast.crm.contacttest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
		/* create object */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();


		
		//read the data from property file
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		

	    //read testscript data from excel file and random number
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandumNumber();
		
		WebDriver driver = new FirefoxDriver();
		 
		 
		 //Step 1: Login to app
		 wLib.maximizethewindow(driver); 
		 wLib.waitForPageToLoad(driver);
		 driver.get(URL);
		  
		 LoginPage lp = new LoginPage(driver);
			
		 lp.getUsernameEdt().sendKeys("admin");
		 lp.getPasswordEdt().sendKeys("admin");
		 lp.getLoginBtn().click();
				
	    //Step 2: navigate to Contact module
		Homepage hp = new Homepage(driver);
		hp.getContactLnk().click();
				  
		//Step 3: click on "create Contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContBtn().click();
		
		//step 4: enter all the details & create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createLastName(driver, lastName);
		cncp.getSaveBtn().click();

				  
		//verify Header msg info expected result  
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actLastName = cip.getLastNameInfoMsg().getText();
		if(actLastName.contains(lastName)) {
			System.out.println(lastName + " is verified==>Pass");
		}else {
			System.out.println(lastName + " is not verified==>Fail");
		}
		
		
		hp.logout();
	}
	
	
}
