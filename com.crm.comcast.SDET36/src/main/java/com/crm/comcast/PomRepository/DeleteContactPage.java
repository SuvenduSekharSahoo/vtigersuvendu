package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class DeleteContactPage extends WebDriverUtility {
	
	WebDriver driver;
	public DeleteContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//===========================================================================================
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//input[@class='crmbutton small delete'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchForTB;
	
	@FindBy(id="bas_searchfield")
	private WebElement idListBox;
	
	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement validateContactInfo;
	
	//=================================================================================
	
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

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getSearchForTB() {
		return searchForTB;
	}

	public WebElement getIdListBox() {
		return idListBox;
	}
	
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getValidateContactInfo() {
		return validateContactInfo;
	}
	
	//=====================================================================================
	
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
	
	public void deleteBtn(WebDriver driver, String expectedMsg)
	{
		deleteBtn.click();
		swithToAlertWindowAndAccpect(driver, expectedMsg);
	}
	
	public void searchForTB(String lastname)
	{
		searchForTB.sendKeys(lastname);
	}
	
	public WebElement idListBox()
	{
		idListBox.click();
		return idListBox;
	}
	
	public void searchNowBtn()
	{
		searchNowBtn.click();
	}
	
	public void validateContactInfo()
	{
		String expected="No Contact Found !";
		String value=validateContactInfo.getText();
		Assert.assertEquals("expected", "value");
		System.out.println("=============successfully deleted================");
	}
}
