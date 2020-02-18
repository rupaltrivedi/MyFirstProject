package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BaseObject{
	
	public WebDriverWait wait;
	public WebDriver driver;

	By signUpEmail= By.xpath("//div//label/following-sibling::input[@type='email']");
	By signUpUsername= By.xpath("//div//label/following::input[@type='email']/following::input[@type='text']");
	By signUpPassword= By.xpath("//div[@class='form-password-input']/input[@id='password']");
	By createAccountButton= By.xpath("//button[@type='submit']");
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public void signUpforFirstTime(String emailID,String name,String password) {
		wait= new WebDriverWait(driver,20);
	WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(signUpEmail));
	email.sendKeys(emailID);
	driver.findElement(signUpUsername).sendKeys(name);
	driver.findElement(signUpPassword).sendKeys(password);
	driver.findElement(createAccountButton).click();
	
		
	}

}
