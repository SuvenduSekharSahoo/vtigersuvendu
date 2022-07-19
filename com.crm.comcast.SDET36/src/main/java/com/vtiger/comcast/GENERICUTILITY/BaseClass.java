package com.vtiger.comcast.GENERICUTILITY;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	
	/*for Listener Separate driver
	public static WebDriver listenerDriver;
	*/
	
	@BeforeSuite(alwaysRun=true)
	public void configBS() 
	{
		System.out.println("===========connect to DataBase=============");
	}
	
	@Parameters("Browser")
	@BeforeClass(alwaysRun=true)
	//Parameter-String Browser
	public void launchBrowser()
	{
//		if(Browser.equals("chrome"))
//		{
			driver=new ChromeDriver();
//	}
//		else if(Browser.equals("edge"))
//		{
//			driver=new EdgeDriver();
//	}

			
	wLib.waitForElementInDOM(driver);
	System.out.println("============Launch the Browser===========");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginapp() throws IOException 
	{
		String url=fLib.getPropertyKeyValue("url");
		String username=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToVtiger(url, username, password);
		System.out.println("============Login to Application===========");

	}
	
	@AfterMethod(alwaysRun=true)
	public void logoutApp() 
	{
		HomePage hp = new HomePage(driver);
		hp.signout();
		System.out.println("============SignOut from Application===========");

	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() 
	{
		driver.close();
		System.out.println("============Close the Browser===========");
	}
	
	@AfterSuite(alwaysRun=true)
	public void configAS()
	{
		System.out.println("============close DataBase=============");
	}
}

