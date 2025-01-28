package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//input[@name='account_name']/following-sibling::img"))
	private WebElement plusBtn;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath=("//input[@value=\"  Save  \"]"))
	private WebElement saveBtn;
	
	@FindBy(id="search_txt")
	private WebElement searchField;

	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(id="jscal_trigger_support_start_date")
	private WebElement startDateBtn;
	
	@FindBy(name="support_start_date")
	private WebElement start_Date;
	
	@FindBy(id="jscal_trigger_support_end_date")
	private WebElement endDateBtn;
	
	@FindBy(name="support_end_date")
	private WebElement end_Date;
	

	

public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getPlusBtn() {
		return plusBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getStart_Date() {
		return start_Date;
	}

	public WebElement getEnd_Date() {
		return end_Date;
	}

	public void createLastName(WebDriver driver, String lastName) {
	    lastNameEdt.sendKeys(lastName);
	    saveBtn.click();
	}
	
	 public void createContactWithOrg (WebDriver driver, String orgName, String lastName) {
    lastNameEdt.sendKeys(lastName);
	plusBtn.click();
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.switchToTabonURL(driver, "module=Accounts");
	searchField.sendKeys(orgName);
	searchBtn.click();
	driver.findElement(By.xpath("//a[@id='1']")).click();
	wLib.switchToTabonTitle(driver, "Contacts&action");
	saveBtn.click();
		}

    public void createContactWithSupportDate (WebDriver driver, String orgName, int days) {
    lastNameEdt.sendKeys(orgName);
	JavaUtility jLib = new JavaUtility();
	String startDate = jLib.getSystemDateYYYYMMDD();
    String endDate = jLib.getRequiredDateYYYYMMDD(days);
	start_Date.clear();
    start_Date.sendKeys(startDate);
	end_Date.clear();
    end_Date.sendKeys(endDate);
    saveBtn.click();


	/*
	 * startDateBtn.click(); Select sel = new Select(startDateBtn);
	 * sel.selectByVisibleText(startDate);
	 * 
	 * endDateBtn.click(); Select sel1 = new Select(endDateBtn);
	 * sel1.selectByVisibleText(endDate);
	 */
}



	

}
