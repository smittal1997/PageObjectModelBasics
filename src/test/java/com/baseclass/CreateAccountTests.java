package com.baseclass;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmPages.AccountPage;
import com.crmPages.CreateAccount;
import com.defaults.LoginPage;

public class CreateAccountTests extends PageParentClass {
	
	@Test(dataProvider="getData")
	public void createAccountTest(Hashtable<String,String> data) 
	{
		/*Skipping a test case from Test Suites file
		 * A test suite sheet created and define all classes in them with
		 * Readmode. 
		 * For specific create readmode column in each sheet except in test suite file
		if(!(TestUtil.isTestRunnable("CreateAccountTests", excel))) {
			throw new SkipException("Skipping the test "+"CreateAccountTests"+"".toUpperCase()+" ");
		}
		*/
		
		//check once using Create different classes object and using Wait correctly
		AccountPage account = PageParentClass.menu.gotoAccount();
		CreateAccount ca = account.clickOnNewButton();
		ca.createAccount(data.get("AccountsName"));
	}
	
	@DataProvider
	public static Object[][] getData()
	{	
		if(excel==null)
		{
			excel = new ExcelReader("C:\\Users\\Ranosys\\eclipse-workspace\\Y_DataDriven_Framework\\src\\test\\java\\AccountExcelData.xlsx");
		}
		
		String sheetname = "CreateAccountTests";
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
