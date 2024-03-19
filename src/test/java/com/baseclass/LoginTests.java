package com.baseclass;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.defaults.LoginPage;

public class LoginTests extends PageParentClass {
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data) throws Throwable
	{
		LoginPage lp = new LoginPage();
		lp.doLogin(data.get("username"),data.get("password"));
		//Assert.fail("Login test"); //Commenting the failure
	}
	
	@DataProvider
	public static Object[][] getData()
	{	
		if(excel==null)
		{
			excel = new ExcelReader("C:\\Users\\Ranosys\\eclipse-workspace\\Y_DataDriven_Framework\\src\\test\\java\\AccountExcelData.xlsx");
		}
		
		String sheetname = "LoginTests";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		
		Object[][] data = new Object[rows-1][1]; //rows-1 because we are not counting first row 
		Hashtable<String,String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++) 
		{
			table = new Hashtable<String, String>();
			for(int colNum=0; colNum<cols; colNum++)
			{
				table.put(excel.getCellData(sheetname, colNum, 1), excel.getCellData(sheetname, colNum, rowNum));
				data[rowNum-2][0] = table;
		}	
		}
		return data;
	} 
	

}
