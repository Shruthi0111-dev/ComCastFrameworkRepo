package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createNewContBtn;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement saveBtn;

	public WebElement getCreateNewContBtn() {
		return createNewContBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
}

	

	
	

