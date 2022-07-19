package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility
{
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//=====================================================================================
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationBtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchForTB;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//================================================================================
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateOrganizationBtn() {
		return createOrganizationBtn;
	}

	public WebElement getSearchForTB() {
		return searchForTB;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//====================================================================================
	
	public void createOrganizationBtn() 
	{
		createOrganizationBtn.click();
	}
	
	public void searchforPassValue(String name)
	{
		searchForTB.sendKeys(name);
	}
	
	public void searchNowBtn()
	{
		searchNowBtn.click();
	}
	

}
