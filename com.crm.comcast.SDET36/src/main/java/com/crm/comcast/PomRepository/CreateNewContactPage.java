package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	WebDriver driver;
	
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//================================================================================
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement validateContactInfo;

	//==================================================================================================
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getValidateContactInfo() {
		return validateContactInfo;
	}
	
	//==========================================================================================================
	
	public void createContactIcon()
	{
		createContactIcon.click();
	}
	
	public void lastNameTB(String lastname)
	{
		lastNameTB.sendKeys(lastname);
	}
	
	public void saveBtn()
	{
		saveBtn.click();
	}
	
	public String validateContactInfo()
	{
		return validateContactInfo.getText();
		
	}
}
