package com.comcast.crm.orgtest1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.generic.listnerutility.ListnerImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		/* create object */
        ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
				
		
		//read testscript data from excel file and random number
		String orgName=eLib.getDataFromExcel("org", 1, 2) + jLib.getRandumNumber();
		
		  //Step 2: navigate to organization module
		  Homepage hp = new Homepage(driver);
		  hp.getOrgLink().click();
		  
		  
		  //Step 3: click on "create Organization" button
		  OrganizationPage cnp = new OrganizationPage(driver);
		  cnp.getCreateNewOrgBtn().click();
		  
		  //step 4: enter all the details & create new organization
		  CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		  cnop.createOrg(orgName);
		  cnop.getSaveBtn().click();
		  
		  //verify Header msg expected result
		  OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		  String actOrgName = oip.getHeaderMsg().getText();		  
		  if(actOrgName.contains(orgName)) {
			 System.out.println((orgName + "name is verified ==PASS"));
		  }else {
			  System.out.println((orgName + "name is not verified ==FAIL"));
		  }

		  }
	
	@Test 
	public void createOrganizationwithIndustry() throws EncryptedDocumentException, IOException {
		
		/* create object */
        ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
				
		
		//read testscript data from excel file and random number
		String orgName=eLib.getDataFromExcel("org", 1, 2) + jLib.getRandumNumber();
		String Industry = eLib.getDataFromExcel("org", 4, 3);

		  //Step 2: navigate to organization module
		  Homepage hp = new Homepage(driver);
		  hp.getOrgLink().click();
		  
		//Step 3: click on "create Organization" button
		  OrganizationPage cnp = new OrganizationPage(driver);
		  cnp.getCreateNewOrgBtn().click();
		  
		  //step 4: enter all the details & create new organization
		  CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		  cnop.createOrg(orgName);
		  cnop.createInd(Industry);
		  		  
		  
          //verify the industries and type info testcase2		  
		  
		  OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		  String actIndustry = oip.getIndustryInfo().getText();
		  if(actIndustry.contains(Industry)) { 
		  System.out.println((Industry + "name is verified ==PASS")); }
		  else { System.out.println((Industry +"name is not verified ==FAIL")); }
	}
	
	@Test
	public void CreateOrgWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		/* create object */
        ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//read testscript data from excel file and random number
		String orgName=eLib.getDataFromExcel("org", 1, 2) + jLib.getRandumNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		
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
		
	}
}
		  
		  
		  
		  
		  
		  

