package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;

import com.PageObjectsTest.BaseObject;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends TestListenerAdapter {

	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest logger;



	public void onStart(ITestContext testContext) {

		String timestamp = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss").format(new Date());
		String reportName = "Test-Report-"+timestamp+".html";
		extentHtmlReporter = new ExtentHtmlReporter("./test-output/"+ reportName); 

		extentHtmlReporter.config().setDocumentTitle("Automation Reports");
		extentHtmlReporter.config().setReportName("Regression Test");
		extentHtmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("User","Rupal");
		extentReports.setSystemInfo("Environment","QA");


		System.out.println("Test started------> "+ testContext.getName());
	}


	public void onFinish(ITestContext testContext) {
		
		extentReports.flush();
		System.out.println("Test finished------> "+ testContext.getName());
	}

	public void onTestSuccess(ITestResult tr) {

		logger= extentReports.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN ));
		System.out.println("Successful test------> "+ tr.getMethod());
		BaseObject.takeScreenshotForTesting(tr.getName());
	}


	public void onTestFailure(ITestResult tr) {

		logger= extentReports.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));

		String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+ tr.getName()+".png";
		BaseObject.takeScreenshotForTesting(tr.getName());
		

		File file = new File(screenshotPath);

		if (file.exists()) {

			try {

				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Test failed------> "+ tr.getMethod());
	}

	
	public void onTestSkipped(ITestResult tr) {
		
		logger= extentReports.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		throw new SkipException("Skipping the test");
		

	}
}
