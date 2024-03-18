package com.baseclass;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.google.common.io.Files;

public class TestUtil extends PageParentClass {
	
	public static String ssname;
	
	public static void captureScreenshot() throws IOException
	{
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		ssname = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(System.getProperty("user.dir"));
		Files.copy(screenshot, new File(System.getProperty("user.dir")+"\\test-output\\html\\"+ssname));
	} 
	
	/*common dataProvider created
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{	
		String sheetname = m.getName();
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
	}*/
	
	
/*	public static boolean isTestRunnable(String testname, ExcelReader excel)
	{
		String sheetName = "Test Suites";
		int rows = excel.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rows;rowNum++)
		{
			String testcase = excel.getCellData(sheetName, "TestCaseID", rowNum);
			
			if(testcase.equalsIgnoreCase(testname)) {
				String runmode = excel.getCellData(sheetName, "RunMode", rowNum);
				
				if(runmode.equalsIgnoreCase("Y"))
				{
					return true;
				}else
				{
					return false;
				}
			}
		}
		return false;
	} */

}
