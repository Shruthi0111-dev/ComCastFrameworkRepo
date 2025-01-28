package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
*test class for contact module
*@author admin
*
*/
public class SearchContactTest extends BaseClass {
	
	@Test
	public void searchcontactTest() {
		/* 
		 * Step1: login to app
		 */
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("username", "password");
	}
}
