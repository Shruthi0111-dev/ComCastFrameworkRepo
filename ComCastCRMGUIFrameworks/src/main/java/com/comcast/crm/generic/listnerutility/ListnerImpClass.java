package com.comcast.crm.generic.listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListnerImpClass implements ITestListener, ISuiteListener {

	public static ExtentReports report;	
	 public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TEST Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===== =====>"+result.getMethod().getMethodName()+">=====START=====");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED <==");
		}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===== =====>"+result.getMethod().getMethodName()+">=====END=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED <==");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		String currentTime = new Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+currentTime);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <==");
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		}
	}
