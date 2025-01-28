package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	
	//WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {          //Rule-3 object Initialization
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@value=\"  Save  \"]")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id="phone")
	private WebElement phoneNumEdt;
	
	

	public WebElement getPhoneNumEdt() {
		return phoneNumEdt;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
	}
	
    public void createInd(String industry) {
    	industryDD.sendKeys(industry);
		Select sel1 = new Select(industryDD);
		sel1.selectByVisibleText(industry);
		saveBtn.click();
	}
    
    public void createType(String type) {
    	typeDD.sendKeys(type);
        Select sel2 = new Select(typeDD);
	    sel2.selectByVisibleText(type);
	    saveBtn.click();
    }
    public void createPhone(String phoneNumber) {
    	phoneNumEdt.sendKeys(phoneNumber);
        saveBtn.click();
  }
}
