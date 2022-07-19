package com.crm.comcast.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

import com.crm.comcast.PomRepository.DeleteContactPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class DeleteContactTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	@Test
		public void createContactTest() throws Throwable
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

		jLib.getRandomNumber();
//		Random r=new Random();
//		int num=r.nextInt(1000);
		
		String lastname=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
//		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sh=book.getSheet("Sheet2");
//		String lastname=sh.getRow(0).getCell(0).getStringCellValue()+num;
//		System.out.println(lastname);
		
//		WebDriver driver=new ChromeDriver();
//		
//		wLib.waitForElementInDOM(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToVtiger(url, un, pwd);
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();	
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		DeleteContactPage dc = new DeleteContactPage(driver);
		dc.createContactIcon();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		dc.lastNameTB(lastname);
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		dc.saveBtn();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		}
		
		
	@Test
		public void deleteContactsTest() throws Throwable
		{
			FileUtility fLib = new FileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
		
			String lastname=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
			
			HomePage hp = new HomePage(driver);
			hp.clickOnContacts();
			
			DeleteContactPage dc = new DeleteContactPage(driver);
			dc.createContactIcon();
		
			dc.lastNameTB(lastname);

			dc.saveBtn();

		
		String expectedMsg="Are you sure";
		dc.deleteBtn(driver, expectedMsg);
		//driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
		//wLib.swithToAlertWindowAndAccpect(driver);
//		Alert alt=driver.switchTo().alert();
//		alt.accept();
		
		dc.searchForTB(lastname);
		//driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastname);
		
		WebElement wb = dc.idListBox();
		Select s = new Select(wb);
		s.selectByIndex(2);
//		WebElement wb=driver.findElement(By.id("bas_searchfield"));
//		wb.click();
		//wLib.select(wb, 2);
//		Select s=new Select(wb);
//		s.selectByIndex(2);
		
		dc.searchNowBtn();
		//driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
		
		
//		String expected="No Contact Found !";
//		String actual = dc.validateContactInfo();
		//String actual=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
//		if(expected.contains(actual))
//		{
//			System.out.println("=============successfully deleted================");
//		}
//		else
//		{
//			System.out.println("============not deleted=============");
//		}
		
		//hp.signout();
		//Actions act=new Actions(driver);
//		WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mouseOverOnElement(driver, wb1);
		//act.moveToElement(wb1).perform();
//		
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
