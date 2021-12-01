package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is initialize the Threadlocal Webdriver instance
	 * @param browser
	 * @return WebDriver 
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("The Browser is :"+browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		
		else if (browser.equals("chrome"))
		{

			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else if (browser.equals("edge"))
		{

			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}
		
		else {
			System.out.println("Invalid Broswer choice");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	/**
	 * THis method get the Threadlocal driver 
	 * @return WebDriver
	 */
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

}
