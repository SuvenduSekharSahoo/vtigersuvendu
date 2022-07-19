package com.vtiger.comcast.GENERICUTILITY;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseClass implements ITestListener {
	
	//@Override
	public void onTestFailure(ITestResult result) {

		String failedTestName = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./failedscreenshot.png");
		
		String s = new Date().toString().replaceAll("|","-");
		
		try {
			FileUtils.copyFile(src, trg);
			} 
		catch (IOException e)
			{
			e.printStackTrace();
			}
	}

}
