package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


/**
 * @author admin
 * contains logins page elements & business library like login
 */

public class LoginPage extends WebDriverUtility {                          //Rule-1 create a separate java class
	                     
	//WebDriver driver;
	public LoginPage(WebDriver driver) {          //Rule-3 object Initialization
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")                    //Rule-2 Object creation
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private  WebElement loginBtn;

	private WebDriver driver;

	
	
	public WebElement getUsernameEdt() {             //Rule-4 object Encapsulation
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Rule-5 provide Action
	/**
	 * login to application based url,username,password
	 * @param username
	 * @param password
	 */
	public void loginToapp(String username , String password)
	{
		waitForPageToLoad(driver);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		
		loginBtn.click();
	}


	
	

	
}
