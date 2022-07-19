package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility {
	
	WebDriver driver;
	public CreateNewCampaignPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//==================================================================================
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreoption;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignBtn;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignBtn;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTB;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement validateCampaignName;
	
	@FindBy(xpath="(//input[@class='crmbutton small delete'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForTB;
	
	@FindBy(xpath="(//select[@id='bas_searchfield'])[1]")
	private WebElement inListBox;
	
	@FindBy(xpath="(//input[@class='crmbutton small create'])[1]")
	private WebElement searchForBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement validateCampaignInfo;
	
	//===================================================================================
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMoreoption() {
		return moreoption;
	}

	public WebElement getCampaignBtn() {
		return campaignBtn;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getCampaignNameTB() {
		return campaignNameTB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getValidateCampaignName() {
		return validateCampaignName;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getSearchForTB() {
		return searchForTB;
	}

	public WebElement getInListBox() {
		return inListBox;
	}

	public WebElement getSearchForBtn() {
		return searchForBtn;
	}

	public WebElement getValidateCampaignInfo() {
		return validateCampaignInfo;
	}
	
	//=====================================================================================
	
	public void moreToCampaign()
	{
		mouseOverOnElement(driver,moreoption);	
	}
	
	public void campaignBtn()
	{
		campaignBtn.click();
	}
	
	public void createCampaignBtn()
	{
		createCampaignBtn.click();
	}
	
	public void campaignNameTB(String campaignname)
	{
		campaignNameTB.sendKeys(campaignname);
	}
	
	public void saveBtn()
	{
		saveBtn.click();
	}
	
	public String validateCampaignName()
	{
		return validateCampaignName.getText();
	}
	
	public void deleteBtn()
	{
		deleteBtn.click();
	}
	
	public void searchForTB(String campaignname)
	{
		searchForTB.sendKeys(campaignname);
	}
	
	public WebElement inListBox()
	{		
		inListBox.click();
		return inListBox ;	
	}
	
	public void searchForBtn()
	{
		searchForBtn.click();
	}
	
	public String validateCampaignInfo()
	{
		return validateCampaignInfo.getText();
	}

}
