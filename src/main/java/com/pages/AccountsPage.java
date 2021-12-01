package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
WebDriver driver;
	
	//constructor of the page class

	  public AccountsPage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	 
	//locators 
	  private By accountsections = By.cssSelector("div#center_column span");
	  private By signOut=By.cssSelector("a.logout");
	  
	//Accountpage methods
	  
	  public int getAccountsectionCount()
	  {
		  return driver.findElements(accountsections).size();
	  }
	 
	  public List<String> getAccountSectionList()
	  {
		  List<String> actlist=new ArrayList<String>();
		  List<WebElement> accountList=driver.findElements(accountsections);
		  
		  for(WebElement e:accountList)
		  {
			  System.out.println(e.getText());
			  String text=e.getText();
			  actlist.add(text);
		  }
		  
		  return actlist;
		  
	  }
	  
	  public void getAccountPageTitle()
	  {
		  driver.getTitle();
	  }
	  
	  public LoginPage clickOnSignOutButton()
	  {
		  driver.findElement(signOut).click();
		  return new LoginPage(driver);
	  }

}
