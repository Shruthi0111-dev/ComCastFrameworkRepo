package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class createContactWithSupportDateTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
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
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandumNumber();
		String orgName=eLib.getDataFromExcel("contact", 4, 3) + jLib.getRandumNumber();
		
		  String startDate=jLib.getSystemDateYYYYMMDD(); 
		  //String startDate = eLib.getDataFromExcel("contact", 4, 3); 
		  String endDate = jLib.getRequiredDateYYYYMMDD(30); 
		  //String endDate = eLib.getDataFromExcel("contact", 4, 4);
		 
		
		 
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
		  cncp.createContactWithSupportDate(driver, orgName, 30);
		  
		  
		  
		  //verify startDate & EndDate info expected result
		  ContactInformationPage cip = new ContactInformationPage(driver);
		  String actStartDate = cip.getStartDateInfo().getText();
		  if(actStartDate.contains(startDate)) {
			  System.out.println(startDate + " startdate is verified==>Pass");
		  }else {
			  System.out.println(startDate + " startdate is not verified==>Fail");
		  }
		  
		  
		  String actEndDate = cip.getEndDateInfo().getText();
		  if(actEndDate.equals(endDate)) {
			  System.out.println(endDate + " enddate is verified==>Pass");
		  }else {
			  System.out.println(endDate + " enddate is not verified==>Fail");
		  }
		  
		  //Step 5: logout
		  hp.logout();
		  
		  driver.close();
	}

}
