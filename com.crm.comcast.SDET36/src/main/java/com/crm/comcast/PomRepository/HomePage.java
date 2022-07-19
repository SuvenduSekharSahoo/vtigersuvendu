package com.crm.comcast.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//===========================================================================
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	@FindBy(linkText="More")
	private WebElement moreOption;
	
	//=================================================================================

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getDocumentsLink() {
		return documentsLink;
	}
	
	public WebElement getSignoutimg()
	{
		return signoutimg;
	}

	public WebElement getSignoutBtn() 
	{
		return signoutBtn;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}
	
	//================================================================================
	
	public void clickOnContacts() 
	{
		contactsLink.click();
	}
	
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	public void clickOnProducts()
	{
		productsLink.click();
	}

	public void documentsLink()
	{
		documentsLink.click();
	}
	
	public void moreOption()
	{
		mouseOverOnElement(driver, moreOption);
	}
	
	public void signout()
	{
//		HomePage hp = new HomePage(driver);
//		hp.mouseOverOnElement(driver, signoutimg);
//		signoutBtn.click();
		mouseOverOnElement(driver,signoutimg);
		signoutBtn.click();
	}

	
}
