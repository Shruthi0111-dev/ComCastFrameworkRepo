package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
//	WebDriver driver;
	public OrganizationPage(WebDriver driver) {          //Rule-3 object Initialization
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement search;
	
	

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	

	
	
	
}
