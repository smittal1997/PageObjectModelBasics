package com.baseclass;


import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;


public class PageParentClass {
	
	public static WebDriver driver; //making static because other class will calling again this constuctor so make the conditon
	public static TopMenu menu;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\baseclass\\AccountExcelData.xlsx");

	public static String newbrowser;
	public static String browser = "chrome";
	public static String siteurl = "https://login.salesforce.com";
	public static WebDriverWait wait;
	public static String clickNewButtonXpath = "//li[@data-target-selection-name='sfdc:StandardButton.Account.New']";
	public static String accName = "//input[@name='Name']";
	
	
	public PageParentClass()
	{
		if(driver==null) {
			
		//Jenkins Configurations
			if (System.getProperty("browser") != null && !System.getProperty("browser").isEmpty())
			{	
				newbrowser = System.getenv("browser");
						
			} else
			{
				browser = System.getenv("browser");
			}
			System.setProperty("browser", browser);
			
			//Launch Browser config
			if(browser.equals("chrome"))
			{
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
			}
			else if(browser.equals("firefox"))
			{
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				FirefoxOptions options = new FirefoxOptions();
				//options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new FirefoxDriver(options);
		
			}
		driver.get(siteurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		menu = new TopMenu(driver);
		}
	}
	
	public boolean isElementPresent(By by)
	{
		try {
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
		
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException
	{
	
		try {
				Assert.assertEquals(actual, expected);
		}catch(Throwable t) {
			TestUtil.captureScreenshot();
			Reporter.log("verification failure"+t.getMessage());
			Reporter.log("<br>");
			Reporter.log("Verification Failure Screenshot");
			Reporter.log("<img src ="+TestUtil.ssname+">Screenshot</img>");
			Reporter.log("<br>");
		}
	}
	
	
/*	@AfterSuite
	public static void quit()
	{
		driver.quit();
	} */

}
