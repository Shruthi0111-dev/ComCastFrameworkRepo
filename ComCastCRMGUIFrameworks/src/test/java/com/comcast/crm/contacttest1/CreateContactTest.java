package com.comcast.crm.contacttest1;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest extends BaseClass {
	
	@Test 
	public void createContactTest() throws IOException {

		/* create object */
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();

	    //read testscript data from excel file and random number
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandumNumber();
				
	    //Step 2: navigate to Contact module
		Homepage hp = new Homepage(driver);
		hp.getContactLnk().click();
				  
		//Step 3: click on "create Contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContBtn().click();
				  
		//step 4: enter all the details & create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithOrg(driver, lastName, lastName);

				  
		//verify Header msg info expected result  
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actLastName = cip.getLastNameInfoMsg().getText();
		if(actLastName.contains(lastName)) {
			System.out.println(lastName + " is verified==>Pass");
		}else {
			System.out.println(lastName + " is not verified==>Fail");
		}
	}
	
	@Test 
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		
		/* create object */
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//read testscript data from excel file and random number
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandumNumber();
		String orgName = eLib.getDataFromExcel("contact", 7, 2);
		
		//Step 2: navigate to Contact module
		Homepage hp = new Homepage(driver);
		hp.getContactLnk().click();
						  
		//Step 3: click on "create Contact" button
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
          }
	
	@Test 
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException  {
		
		 /*create object 
		
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//read testscript data from excel file and random number
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandumNumber();
		String startDate = eLib.getDataFromExcel("contact", 4, 3);
		String endDate = eLib.getDataFromExcel("contact", 4, 4);
		
		//Step 2: navigate to Contact module
		Homepage hp = new Homepage(driver);
		hp.getContactLnk().click();
								  
		//Step 3: click on "create Contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContBtn().click();
		
		//step 4: enter all the details & create new contact
		  CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		  cncp.createContactWithOrg(driver, endDate, lastName);
		  cncp.createContactWithSupportDate(driver, endDate, 30);
		  
		  
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
		  }*/
		  
		
		
	}
}

