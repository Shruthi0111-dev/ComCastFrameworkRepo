package com.comcast.crm.basetest;

import java.io.IOException;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabasrUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {


	//private static final String[] BROWSER = null;
	public DatabasrUtility dbLib = new DatabasrUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite //(groups = {"smokeTest", "regressionTest"})
	public void configBs() throws SQLException {
		System.out.println("connect to DB , Report configuration");
		dbLib.getDbconnection();
		
		 //spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TEST Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "FIREFOX-100");
		
		}
	
	// @Parameters ("BROWSER")
	 @BeforeClass (groups = {"smokeTest", "regressionTest"})   		//read common data from property file
	    public void configBc() throws IOException {
	    	System.out.println("===Launch the Browser===");
	    	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	    	if(BROWSER.equals("firefox")) {
	    			driver = new FirefoxDriver();
	    	}else if(BROWSER.equals("chrome")) {
	    		driver = new ChromeDriver();
	    	}
	    	sdriver = driver;
	}
	 
	@BeforeMethod //(groups = {"smokeTest", "regressionTest"})
    public void configBm() throws IOException {
    	System.out.println("===Login===");
    	
    	wLib.maximizethewindow(driver); 
        wLib.waitForPageToLoad(driver);
    	
    	String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		driver.get(URL);

    	LoginPage lp = new LoginPage(driver);
    	lp.loginToapp(USERNAME, PASSWORD);
    	lp.getUsernameEdt().sendKeys("admin"); 
    	lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();
	}
	
	@AfterMethod //(groups = {"smokeTest", "regressionTest"})
	public void configAm() {
		System.out.println("===Logout===");
		Homepage hp = new Homepage(driver);
		hp.logout();
		
	}
	
	@AfterClass //(groups = {"smokeTest", "regressionTest"})
	public void configAc() {
		System.out.println("===Close Browser===");
		driver.quit();
	}
	
	
	@AfterSuite //(groups = {"smokeTest", "regressionTest"})
	public void configAs() throws SQLException {
		System.out.println("===close DB, Report BackUp===");
		dbLib.closeDbconnection();
		report.flush();
		}
	
		
		  
		 
}