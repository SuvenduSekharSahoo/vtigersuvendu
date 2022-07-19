package com.crm.comcast.DocumentsTest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepository.CreateNewDocumentsPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

@Listeners(com.vtiger.comcast.GENERICUTILITY.ListenerImplementation.class)
public class CreateDocumentsTest extends BaseClass {
	
	//public static void main(String[] args) throws Throwable {
	@Test(groups={"smoke"})
	public void createDocumentsTest() throws Throwable
	{
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	
//	String url=fLib.getPropertyKeyValue("url");
//	String un=fLib.getPropertyKeyValue("username");
//	String pwd=fLib.getPropertyKeyValue("password");
	
//	FileInputStream fis=new FileInputStream("CommonData/commondata.properties");
//	Properties pobj=new Properties();
//	pobj.load(fis);
//	String url=pobj.getProperty("url");
//	String un=pobj.getProperty("username");
//	String pwd=pobj.getProperty("password");

	//jLib.getRandomNumber();
	
//	WebDriver driver=new ChromeDriver();
//	
//	wLib.waitForElementInDOM(driver);
	
	//driver.get(url);	
	
//	LoginPage lp = new LoginPage(driver);
//	lp.loginToVtiger(url, un, pwd);
//	driver.findElement(By.name("user_name")).sendKeys(un);
//	driver.findElement(By.name("user_password")).sendKeys(pwd);
//	driver.findElement(By.id("submitButton")).click();	
	
	HomePage hp = new HomePage(driver);
	hp.documentsLink();
	//driver.findElement(By.linkText("Documents")).click();
	
	CreateNewDocumentsPage cnd = new CreateNewDocumentsPage(driver);
	cnd.createDocumentsIconBtn();
	//driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		
	cnd.saveBtn();
	//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	//Thread.sleep(2000);
	//cnd.explicitlyWait();
	String expectedMsg="Title";
	wLib.swithToAlertWindowAndAccpect(driver, expectedMsg);
	
	//Assert.fail();
	
//	Alert alt = driver.switchTo().alert();
//	alt.accept();
	
	jLib.getRandomNumber();
//	Random r=new Random();
//	int num=r.nextInt(1000);
	
	String title=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
//	FileInputStream fis=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//	Workbook book=WorkbookFactory.create(fis);
//	Sheet sh=book.getSheet("Sheet2");
//	String title=sh.getRow(0).getCell(0).getStringCellValue()+num;
	
	cnd.titleTB(title);
	//driver.findElement(By.name("notes_title")).sendKeys(title);
	
	//wLib.executeJavaScript(driver, 0, 4000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000);");
		
	wLib.switchToFrame(driver, 0);
	//driver.switchTo().frame(0);
	
	String writeInFrameWindow = eLib.getDataFromExcel("Sheet2", 5, 1);
	cnd.frameWindow(writeInFrameWindow);
	//driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("Handle FramePopUp");
	
	wLib.switchBackFromFrameToMainWindow(driver);
	//driver.switchTo().defaultContent();
	
	cnd.saveBtn1();
	//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	
//	hp.signout();
	//WebElement signout=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
	//wLib.mouseOverOnElement(driver, signout);
//	Actions act=new Actions(driver);
//	act.moveToElement(signout).perform();
	//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}

}

