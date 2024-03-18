package com.crmPages;

import org.openqa.selenium.By;

import com.baseclass.PageParentClass;

public class CreateAccount extends PageParentClass {
	
	public void createAccount(String accountName)
	{
		driver.findElement(By.xpath(accName)).sendKeys(accountName);
	}

}
