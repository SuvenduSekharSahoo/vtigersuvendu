package com.crm.comcast.PomRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//============================================================================

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTB;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement validateOrganizationName;
	
	//===========================================================================
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getOrganizationNameTB() {
		return organizationNameTB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getValidateOrganizationName() {
		return validateOrganizationName;
	}
	
	//==============================================================================
	
	public void organizationNameTB(String orgname) 
	{
		organizationNameTB.sendKeys(orgname);
	}
	
	public void saveBtn()
	{
		saveBtn.click();
	}
	
	public void validateOrganizationName() throws Throwable
	{
		String actual=validateOrganizationName.getText();
		ExcelUtility eu = new ExcelUtility();
		String expected = eu.getDataFromExcel("Sheet2", 0, 0);
		Assert.assertTrue(actual.contains(expected));
	}
}
