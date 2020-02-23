package com.PageObjectsTest;

import org.testng.annotations.Test;

import com.pageObjects.LoginWordPress;
import com.pageObjects.SignUpPage;

public class LoginTest extends BaseObject {

	
	SignUpPage signUpPage;
	LoginWordPress loginwordpress;
	BaseObject bo;


	
	@Test
	public void logIn() throws InterruptedException {
		
		
		loginwordpress = new LoginWordPress(driver);
		loginwordpress.logInLink();
		//Assert.assertTrue((driver.getTitle()).contains("https://wordpress.com/log-in"));
		
		System.out.println("Welcome to the Login Page");
		
	}


	@Test(dependsOnMethods="logIn")
	public void loginByFirstUsernameTest() throws InterruptedException {

		loginwordpress.loginByFirstUsername(emailId);
		
		//loginwordpress.continueWithGoogleButton();
	}

	@Test(dependsOnMethods="loginByFirstUsernameTest")
	public void signUpTest() {
		signUpPage= new SignUpPage(driver);
		signUpPage.signUpforFirstTime(emailId,username,password);



	}
}
