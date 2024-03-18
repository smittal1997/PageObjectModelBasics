package com.baseclass;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

public class CustomListener extends BaseTest implements ITestListener {
	
	
	
	public void onTestFailure(ITestResult result)
	{
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("Capturing Screenshot");
		Reporter.log("<img src ="+TestUtil.ssname+">Screenshot</img>");
	} 
	
}
