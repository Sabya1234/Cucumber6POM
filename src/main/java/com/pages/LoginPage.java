package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor of the page class
	  public LoginPage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	
	//ByLocators
	
	private By emailId = By.id("email");
	private By pwd = By.id("passwd");
	private By signInButton= By.id("SubmitLogin");
	private By forgetPasswordLink= By.linkText("Forgot your password?1111");
			
    //page Action methods( behavior):feature of the page 
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}

	
	public boolean isForgetPasswordlinkExists()
	{
		return driver.findElement(forgetPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String userName)
	{
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void clickOnSignInButton()
	{
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Log in with"+un+"and"+pwd);
		enterUserName(un);
		enterPassword(pwd);
		clickOnSignInButton();
		return new AccountsPage(driver);
		
	}
}
