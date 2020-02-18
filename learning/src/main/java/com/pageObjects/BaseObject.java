package com.pageObjects;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class BaseObject {

	public static WebDriver driver;

	public static Properties pro;


	public void loadProperties() throws Exception {
		pro = new Properties();
		
		File propertyFile = new File(System.getProperty("user.dir") +"\\src\\main\\resources\\ObjectRepo.properties");
		
			FileInputStream fis = new FileInputStream(propertyFile);
			pro.load(fis);
			
	}

	public void takeScreenshotForTesting() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile =new File("C:\\Users\\Rupal Trivedi\\eclipse-workspace\\learning\\test-output\\screenshot");
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}












