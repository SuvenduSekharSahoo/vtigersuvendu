package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateNewDocumentsPage extends WebDriverUtility {
	WebDriver driver;
	
	public CreateNewDocumentsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Document...']")
	private WebElement createDocumentsIconBtn;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement explicitlyWait;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(name="notes_title")
	private WebElement titleTB;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement frameWindow;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn1;

	//===================================================================================================
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateDocumentsIconBtn() {
		return createDocumentsIconBtn;
	}

	public WebElement getExplicitlyWait() {
		return explicitlyWait;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTitleTB() {
		return titleTB;
	}

	public WebElement getFrameWindow() {
		return frameWindow;
	}

	public WebElement getSaveBtn1() {
		return saveBtn1;
	}
	
	//======================================================================================================
	
	public void createDocumentsIconBtn()
	{
		createDocumentsIconBtn.click();
	}
	
	public void explicitlyWait()
	{
		waitForElement(driver, explicitlyWait);
	}
	public void saveBtn()
	{
		saveBtn.click();
	}
	
	public void titleTB(String title)
	{
		titleTB.sendKeys(title);
	}
	
	public void frameWindow(String value)
	{
		frameWindow.sendKeys(value);
	}
	
	public void saveBtn1()
	{
		saveBtn1.click();
		
	}

	}

