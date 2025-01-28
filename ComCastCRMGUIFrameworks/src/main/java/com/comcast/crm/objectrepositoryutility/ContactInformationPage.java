package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInfoMsg;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateInfo;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateInfo;

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebElement getLastNameInfoMsg() {
		return lastNameInfoMsg;
	}

	// verify startDatE info expected result
	public void verifyStartDateInfo(String startDate) {
		String actStartDate = startDateInfo.getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " startdate is verified==>Pass");
		} else {
			System.out.println(startDate + " startdate is not verified==>Fail");
		}
	}

	// verify EndDate info expected result
	public void verifyEndDateInfo(String endDate) {
		String actEndDate = endDateInfo.getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " startdate is verified==>Pass");
		} else {
			System.out.println(endDate + " startdate is not verified==>Fail");
		}
	}
}
