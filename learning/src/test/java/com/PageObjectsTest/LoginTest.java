package com.PageObjectsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pageObjects.BaseObject;
import com.pageObjects.LoginWordPress;
import com.pageObjects.SignUpPage;

public class LoginTest {

	public static WebDriver driver;
	SignUpPage signUpPage;
	LoginWordPress loginwordpress;
	BaseObject bo;

	@BeforeSuite
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

		driver=  new ChromeDriver();
		driver.get("https://wordpress.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		bo.loadProperties();
	}
	
	@Test
	public void logIn() throws InterruptedException {
		
		loginwordpress = new LoginWordPress(driver);
		loginwordpress.logInLink();
	}


	@Test(dependsOnMethods="logIn")
	public void loginByFirstUsernameTest() throws InterruptedException {

		loginwordpress.loginByFirstUsername("trvd.rupal@gmail.com");
		//loginwordpress.continueWithGoogleButton();
	}

	@Test(dependsOnMethods="loginByFirstUsernameTest")
	public void signUpTest() {
		signUpPage= new SignUpPage(driver);
		signUpPage.signUpforFirstTime("trvd.rupal@gmail.com","Rupal","rupa1988edi");



	}
}
