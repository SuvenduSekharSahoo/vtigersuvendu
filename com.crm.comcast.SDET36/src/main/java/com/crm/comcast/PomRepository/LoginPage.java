package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//=============================================================================
	
	@FindBy(name="user_name")
	private WebElement usernamneTB;
	
	@FindBy(name="user_password")
	private WebElement passwordTB;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	//=============================================================================
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getUsernamneTB() {
		return usernamneTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//==================================================================================
	
	public void loginToVtiger(String url,String username,String password)
	{
		driver.get(url);
		
		String actualurl = "http://localhost:8888/";
		String expurl = driver.getCurrentUrl();
		Assert.assertTrue(actualurl.contains(expurl));
		System.out.println("url verified");
		
		usernamneTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginbutton.click();
	}
}
