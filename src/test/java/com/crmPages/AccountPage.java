package com.crmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.baseclass.PageParentClass;

public class AccountPage extends PageParentClass {
	
	
	/*we can write class name as return type which 
	 * ever it is returning or going to next class. 
	 * In below method we use CreateAccount class because 
	 * after click on new button it will open the 
	 * Account form. For which separated class is created.
	 */
	
	public CreateAccount clickOnNewButton() 
	{
		//Thread.sleep(3000);
		
		driver.findElement(By.xpath(clickNewButtonXpath)).click();
		return new CreateAccount();
	}
	
	public void clickOnImportButton()
	{
		
	}
	

}
