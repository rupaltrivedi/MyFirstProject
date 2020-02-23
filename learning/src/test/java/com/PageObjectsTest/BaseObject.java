package com.PageObjectsTest;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;

public class BaseObject {

	public static WebDriver driver;
	
	

	ReadConfig readconfig = new ReadConfig();

	String baseurl= readconfig.getUrl();
	String emailId= readconfig.getEmail();
	String password= readconfig.getPassword();
	String username= readconfig.getUsername();

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws Exception {

		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=  new ChromeDriver();
			
		}else if(br.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=  new FirefoxDriver();
			
		}
		else if(br.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=  new InternetExplorerDriver();
		}

		driver.get(baseurl);
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}


	public static void takeScreenshotForTesting(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
		
		File destinationFile =new File("./test-output\\FailedTestScreenshot\\"+ name+".png");
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	
//	@AfterClass
//	public void tearDown() {
//
//		driver.quit();
//	}
}












