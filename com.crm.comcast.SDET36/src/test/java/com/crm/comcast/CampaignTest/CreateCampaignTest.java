package com.crm.comcast.CampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepository.CreateNewCampaignPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateCampaignTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	@Test(groups ={"regression"})
	public void createCampaignTest() throws Throwable
	{
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
//		FileInputStream fis=new FileInputStream("CommonData/commondata.properties"); 
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url=pobj.getProperty("url");
//		String un=pobj.getProperty("username");
//		String pwd=pobj.getProperty("password");
		
//		String url=fLib.getPropertyKeyValue("url");
//		String username=fLib.getPropertyKeyValue("username");
//		String password=fLib.getPropertyKeyValue("password");
//		
		
//		WebDriver driver=new ChromeDriver();
//		wLib.waitForElementInDOM(driver);
		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToVtiger(url, username, password);
		
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		
		HomePage hp = new HomePage(driver);
		hp.moreOption();
		//Actions act=new Actions(driver);
		CreateNewCampaignPage ccp = new CreateNewCampaignPage(driver);
		ccp.campaignBtn();
		//WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		//wLib.mouseOverOnElement(driver, more);
		//act.moveToElement(more).perform();
		
		ccp.campaignBtn();
		//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		ccp.createCampaignBtn();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
//		Random r=new Random();
//		int num=r.nextInt(1000);
		
		String name=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
		
//		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sh=book.getSheet("Sheet2");
//		String name=sh.getRow(0).getCell(0).getStringCellValue()+num;
		
		ccp.campaignNameTB(name);
		//driver.findElement(By.name("campaignname")).sendKeys(name);
		
		ccp.saveBtn();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		String actual = ccp.validateCampaignName();
		//String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actual.contains(name))
		{
			System.out.println("campaign creation pass");
		}
		else
		{
			System.out.println("campaign creation fail");
		}
		
		ccp.deleteBtn();
		//driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
		
		String expectedMsg = "Are you sure";
		wLib.swithToAlertWindowAndAccpect(driver, expectedMsg);
//		Alert alt=driver.switchTo().alert();
//		alt.accept();
		
		ccp.searchForTB(name);
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(name);
		
		
//		WebElement element=driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
//		element.click();
		String text="Campaign Name";
	    WebElement wb=ccp.inListBox();
		//wLib.select(element, text);
		Select s=new Select(wb);
		s.selectByVisibleText("Campaign Name");
		//wb.click();
		
		ccp.searchForBtn();
//		WebElement wb2=driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]"));
//		wb2.click();
		
		String actual1="No Campaign Found !";
		
		String expected = ccp.validateCampaignInfo();
		//String expected=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		
		if(actual1.contains(expected))
		{
			System.out.println("deleted pass");
		}
		else
		{
			System.out.println("deleted failed");
		}
		
		//hp.signout();
//		WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mouseOverOnElement(driver, wb1);
		//Actions act1=new Actions(driver);
		//act1.moveToElement(wb1).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		
	}

}
