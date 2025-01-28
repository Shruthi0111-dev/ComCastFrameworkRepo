package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInformationPage {

	//WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {          //Rule-3 object Initialization
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;

	@FindBy(id="dtlview_Type")
	private WebElement typeInfo;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneInfo;
	
	
	public WebElement getPhoneInfo() {
		return phoneInfo;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

public void createOrg(String orgName , String industry, String type, String PhoneNumber) {
	String actindustry = industryInfo.getText();
	if(actindustry.contains(industry)) {
		System.out.println("is verified");
	}
	else {
		System.out.println("is not verified");
	}
	
	
	String actPhoneNum = phoneInfo.getText();
	if(actPhoneNum.contains(PhoneNumber)) {
		System.out.println("is verified");
	}
	else {
		System.out.println("is not verified");
	}

}
	
	}
	
	



	
	
	
	
	


