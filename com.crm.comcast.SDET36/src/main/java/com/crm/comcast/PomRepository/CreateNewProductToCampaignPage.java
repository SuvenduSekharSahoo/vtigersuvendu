package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateNewProductToCampaignPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewProductToCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//==================================================
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement clickCreateProductIcon;
	
	@FindBy(name="productname")
	private WebElement productNameTB;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveBtn;
	
	@FindBy(linkText="More")
	private WebElement moreOption;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignBtn;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignBtn;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTB;
	
	@FindBy(xpath="(//img[@align='absmiddle'])[3]")
	private WebElement productLookUpIcon;
	
	@FindBy(name="search_text")
	private WebElement productWindowTB;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchNowBtn;
	
	@FindBy(id="1")
	private WebElement clickOnProduct;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement clickOnSaveBtn;
	
	
	//====================================================================
	
	public WebElement getClickCreateProductIcon() {
		return clickCreateProductIcon;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameTB() {
		return productNameTB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getMoreOption() {
		return moreOption;
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

	public WebElement getproductLookUpIcon() {
		return productLookUpIcon;
	}

	public WebElement getProductWindowTB() {
		return productWindowTB;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	
	public WebElement getClickOnProduct() {
		return clickOnProduct;
	}

	public WebElement getClickOnSaveBtn() {
		return clickOnSaveBtn;
	}

	
	//==========================================================================

	public void clickCreateProductIcon(WebDriver driver)
	{
		clickCreateProductIcon.click();
	}
	
	public void productNameTB(WebDriver driver, String productname) 
	{
		productNameTB.sendKeys(productname);
	}
	
	public void saveBtn(WebDriver driver) 
	{
		saveBtn.click();
	}
	
	public void getMoreOption1()
	{
		mouseOverOnElement(driver, moreOption);
//	}
//	
//	public void campaignBtn(WebDriver driver)
//	{
		campaignBtn.click();
	}
	
	public void createCampaignBtn(WebDriver driver)
	{
		createCampaignBtn.click();
	}
	
	public void campaignNameTB(WebDriver driver, String campaignName)
	{
		campaignNameTB.sendKeys(campaignName);
	}
	
	public void productLookUpIcon()
	{
		productLookUpIcon.click();
	}
	
	public void productWindowTB(WebDriver driver, String productname)
	{
		productWindowTB.sendKeys(productname);
	}
	
	public void searchNowBtn(WebDriver driver)
	{
		searchNowBtn.click();
	}
	
	public void clickOnProduct(WebDriver driver)
	{
		clickOnProduct.click();
	}
	
	public void clickOnSaveBtn(WebDriver driver)
	{
		clickOnSaveBtn.click();
	}
	
	
}
