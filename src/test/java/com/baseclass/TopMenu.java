package com.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crmPages.AccountPage;

public class TopMenu  {
	
	WebDriver driver;
	
	
	public TopMenu(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void gotoHome()
	{
		
	}

	
	public void gotoContact()
	{
		
	}
	
	/*we can write class name as return type which 
	 * ever it is returning or going to next class. 
	 * In below method we use AccountPage class because 
	 * after click on Account button it will go to 
	 * Account Page. For which separated class is created.
	 * 
	 * Read next Account class comment for same return type.
	 */
	public AccountPage gotoAccount() 
	{
	
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='Account']")).click();
		return new AccountPage();
	}
	
	public void gotoLeads()
	{
		
	}
}
