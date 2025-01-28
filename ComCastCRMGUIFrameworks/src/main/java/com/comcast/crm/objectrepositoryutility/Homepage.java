package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	public Homepage(WebDriver driver) {          //Rule-3 object Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;

    
	
    public WebElement getOrgLink() {
		return orgLink;
	}
    public WebElement getContactLnk() {
		return contactLnk;
	}
    public WebElement getCampaignLnk() {
		return campaignLnk;
	}
    public WebElement getMoreLnk() {
		return moreLnk;
	}
    public WebElement getAdminImg() {
		return adminImg;
	}
    public WebElement getSignOut() {
		return signoutLnk;
	}
    
    public void navigateToCampaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLnk).perform();
		campaignLnk.click();
	}
    
    public void logout() {
    	Actions act = new Actions(driver);
    	act.moveToElement(adminImg).perform();
    	signoutLnk.click();
    }
	
}








	








	














	








	








	


	
