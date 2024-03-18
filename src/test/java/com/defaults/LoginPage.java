package com.defaults;
import org.openqa.selenium.By;

import com.baseclass.PageParentClass;

public class LoginPage extends PageParentClass {
	
	
	public void doLogin(String username, String password)  
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		//Thread.sleep(15000);
		}

	public void forgotPassword()
	{
		
	}
}
