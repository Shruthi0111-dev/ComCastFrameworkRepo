package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgWithPhoneNumberTest {

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
		String orgName=eLib.getDataFromExcel("org", 1, 2) + jLib.getRandumNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		
        
		 WebDriver driver = new FirefoxDriver();
		 
		//Step 1: Login to app
		 wLib.maximizethewindow(driver);
		 wLib.waitForPageToLoad(driver);
		 driver.get(URL);
		 
		  LoginPage lp = new LoginPage(driver);
		
		  lp.getUsernameEdt().sendKeys("admin");
		  lp.getPasswordEdt().sendKeys("admin");
		  lp.getLoginBtn().click();
		  
		  //Step 2: navigate to organization module
		  Homepage hp = new Homepage(driver);
		  hp.getOrgLink().click();
		  
		  //Step 3: click on "create Organization" button
		  OrganizationPage cnp = new OrganizationPage(driver);
		  cnp.getCreateNewOrgBtn().click();
		  
		  
		  //step 4: enter all the details & create new organization
		  CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		  cnop.createOrg(orgName);
		  cnop.createPhone(phoneNumber);

		      //verify the phonenumber info expected result 
		  OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		  String actPhonenumber = oip.getPhoneInfo().getText();
		  System.out.println(actPhonenumber);
		  if(actPhonenumber.equals(phoneNumber)) { 
			  System.out.println(phoneNumber +" phonenumber is verified==>Pass"); }
			  else {
			  System.out.println(phoneNumber +" phonenumber not verified==>Fail");
			  }
			  
			 
			 //Step 5: logout
		      hp.logout();

			  
		  //driver.quit();


	}

}
