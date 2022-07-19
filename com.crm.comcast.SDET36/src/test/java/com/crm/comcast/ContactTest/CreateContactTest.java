package com.crm.comcast.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepository.CreateNewContactPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

public class CreateContactTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	@Test(groups={"smoke"})
		public void createContactTest() throws Throwable{
			{
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//String url=fLib.getPropertyKeyValue("url");
		//String un=fLib.getPropertyKeyValue("username");
		//String pwd=fLib.getPropertyKeyValue("password");
//		FileInputStream fis=new FileInputStream("CommonData/commondata.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url=pobj.getProperty("url");
//		String un=pobj.getProperty("username");
//		String pwd=pobj.getProperty("password");

		jLib.getRandomNumber();
//		Random r=new Random();
//		int num=r.nextInt(1000);
		
//		WebDriver driver=new ChromeDriver();
//		
//		wLib.waitForElementInDOM(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//LoginPage lp = new LoginPage(driver);
		//lp.loginToVtiger(url, un, pwd);
		
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();	
		
		String lastname=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
//		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sh=book.getSheet("Sheet2");
//		String lastname=sh.getRow(0).getCell(0).getStringCellValue()+num;
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createContactIcon();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		cnc.lastNameTB(lastname);
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		cnc.saveBtn();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		String expected=lastname;
		
		String act=cnc.validateContactInfo();
		//String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(expected.contains(act))
		{
			System.out.println("fail");
		}
		else
		{
			System.out.println("pass");
		}
		
		//hp.signout();
		//Actions act=new Actions(driver);
//			WebElement signout=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//			wLib.mouseOverOnElement(driver, signout);
		//act.moveToElement(wb).perform();
//			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	}
}
