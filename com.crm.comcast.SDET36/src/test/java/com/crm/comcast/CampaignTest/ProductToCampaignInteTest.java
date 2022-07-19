package com.crm.comcast.CampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepository.CreateNewProductToCampaignPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class ProductToCampaignInteTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	
	@Test(groups ={"regression"})
	public void productToCampaignTest() throws Throwable
	{
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
//		FileInputStream fis=new FileInputStream("CommonData/commondata.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url=fLib.getPropertyKeyValue("url");
//		String un=fLib.getPropertyKeyValue("username");
//		String pwd=fLib.getPropertyKeyValue("password");
		
//		WebDriver driver=new ChromeDriver();
//		wLib.waitForElementInDOM(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToVtiger(url, un, pwd);
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnProducts();
		
		
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		CreateNewProductToCampaignPage cnp = new CreateNewProductToCampaignPage(driver);
		
		cnp.clickCreateProductIcon(driver);
		
//		Random r=new Random();
//		int num=r.nextInt(1000);
		
		String productname=eLib.getDataFromExcel("Sheet2", 3, 1)+jLib.getRandomNumber();
//		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sh=book.getSheet("Sheet2");
//		String name=sh.getRow(2).getCell(1).getStringCellValue()+num;
		
		
		//driver.findElement(By.name("productname")).sendKeys(productname);
		cnp.productNameTB(driver, productname);
		
		//driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		cnp.saveBtn(driver);
		
		//Actions act=new Actions(driver);
		//WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		//wLib.mouseOverOnElement(driver, more);
		//act.moveToElement(moreOption);
		//hp.getMoreOption();


		//act.moveToElement(more).perform();
		String campaignname=eLib.getDataFromExcel("Sheet2", 1, 0)+jLib.getRandomNumber();
		//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		cnp.getMoreOption1();
		
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		cnp.createCampaignBtn(driver);
		//driver.findElement(By.name("campaignname")).sendKeys(campaignname);
		cnp.campaignNameTB(driver, campaignname);
		
		
		//driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		cnp.productLookUpIcon();
		
		//String partialWindowTitle="sh1.getRow(3).getCell(1).getStringCellValue()";
		String partialWindowTitle ="Products";
		wLib.swithToWindow(driver, partialWindowTitle);
//		Set<String> set=driver.getWindowHandles();
//		Iterator<String> it=set.iterator();
//		while(it.hasNext())
//		{
//			String wid=it.next();
//			driver.switchTo().window(wid);
//			String currentWindowTitle=driver.getTitle();
//			System.out.println(currentWindowTitle);
//			if(currentWindowTitle.contains(partialWindowTitle))
//			{
//				break;
//			}
//		}
		
//		FileInputStream fis2=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book1=WorkbookFactory.create(fis2);
//		Sheet sh1=book1.getSheet("Sheet2");
//		String name1=sh1.getRow(0).getCell(0).getStringCellValue()+num;
		
		//driver.findElement(By.name("search_text")).sendKeys(productname);
		cnp.productWindowTB(driver, productname);
		
		//driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		cnp.searchNowBtn(driver);
		
		//driver.findElement(By.id("1")).click();
		cnp.clickOnProduct(driver);
		
		wLib.swithToWindow(driver, partialWindowTitle);				
//		Set<String> set1=driver.getWindowHandles();
//		Iterator<String> it1=set1.iterator();
//		while(it1.hasNext())
//		{
//			String wid1=it1.next();
//			driver.switchTo().window(wid1);
//			String window=driver.getTitle();
//			if(window.contains(partialWindowTitle))
//			{
//				break;
//			}
//		}
		
		
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		cnp.clickOnSaveBtn(driver);
		
		String actual="sh.getRow(4).getCell(2).getStringCellValue()";
		String expected="sh1.getRow(0).getCell(0).getStringCellValue()";
		if(actual.contains(expected))
		{
			System.out.println("unsuccess");
		}
		else
		{
			System.out.println("success");
		}
		

	//Actions act1=new Actions(driver);
		//WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mouseOverOnElement(driver, signout);
//		hp.signout();
	//act.moveToElement(wb1).perform();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		

	}

}

