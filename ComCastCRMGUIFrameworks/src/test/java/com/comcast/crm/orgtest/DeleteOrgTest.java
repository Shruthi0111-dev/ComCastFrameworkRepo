package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws IOException
	{
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
		
		//String lastName = eLib.getDataFromExcel("contact", 1, 2) + 
		//String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		String orgName=eLib.getDataFromExcel("org", 10, 2) + jLib.getRandumNumber();
		
		
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
		  
		  //verify Header msg expected result
		  OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		  String actOrgName = oip.getHeaderMsg().getText();		  
		  if(actOrgName.contains(orgName)) {
			 System.out.println((orgName + "name is verified ==PASS"));
		  }else {
			  System.out.println((orgName + "name is not verified ==FAIL"));
		  }
		  
		  //goback to organization Page
		  hp.getOrgLink().click();
		  
		  //search for organization
		  cnp.getSearchEdt().sendKeys(orgName);
		  wLib.selectVisibleText(cnp.getSearchDD(), "Organization Name");
          cnp.getSearch().click();
          
          
		  //in dynamic webtable select and delete org
          driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
          wLib.switchToAlertAndAccept(driver);

          
          //Step 5: logout
		  hp.getSignOut().click();
		  
		  
		  
		  driver.close();
		  
		  }
}

