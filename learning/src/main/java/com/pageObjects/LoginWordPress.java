	package com.pageObjects;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

	public class LoginWordPress {

		public WebDriver driver;
		public WebDriverWait wait;

		public LoginWordPress(WebDriver driver) {
			this.driver=driver;
		}


		By logInLink = By.linkText("Log In");
		By username = By.xpath("//input[@type='text' and @id='usernameOrEmail']");
		By continueButton= By.xpath("//button[@type='submit' and contains(text(),'Continue')]");
		By continueWithGoogleButton= By.xpath("//*[@class='social-buttons__button button']//*[text()='Continue with Google']");
		By createNewAccountLink= By.linkText("Create a new account");
		By signUp= By.xpath("//div[@class='masterbar__login-links']//*[text()='Sign Up']");
		By validation_error= By.xpath("//*[@class='form-input-validation is-error']//*[text()='User does not exist.']");

		public void logInLink() throws InterruptedException {

			WebElement logInButton= driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
			logInButton.click();
			
		}


		public void loginByFirstUsername(String user) throws InterruptedException {
			wait=new WebDriverWait(driver,30);
			WebElement email_textBox= wait.until(ExpectedConditions.visibilityOfElementLocated(username));
			email_textBox.sendKeys(user);

			driver.findElement(continueButton).click();
			if(validation_error!=null) {

				signUpButton();

			}

		}


		public void loginByUsername(String user) throws InterruptedException {
			wait=new WebDriverWait(driver,30);
			WebElement email_textBox= wait.until(ExpectedConditions.visibilityOfElementLocated(username));
			email_textBox.sendKeys(user);

			driver.findElement(continueButton).click();
		}

		public void continueWithGoogleButton() {
			wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(continueWithGoogleButton)).click();

		}

		public void signUpButton() {
			driver.findElement(signUp).click();

		}
	}



