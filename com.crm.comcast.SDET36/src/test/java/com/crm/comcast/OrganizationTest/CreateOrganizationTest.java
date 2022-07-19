package com.crm.comcast.OrganizationTest;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepository.CreateNewOrganizationPage;
import com.crm.comcast.PomRepository.HomePage;
import com.crm.comcast.PomRepository.LoginPage;
import com.crm.comcast.PomRepository.OrganizationPage;
import com.vtiger.comcast.GENERICUTILITY.BaseClass;
import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;
import com.vtiger.comcast.GENERICUTILITY.FileUtility;
import com.vtiger.comcast.GENERICUTILITY.JavaUtility;
import com.vtiger.comcast.GENERICUTILITY.WebDriverUtility;

@Listeners(com.vtiger.comcast.GENERICUTILITY.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	//public static void main(String[] args) throws Throwable {
	@Test(groups={"smoke"})
	public void createOrganizationTest() throws Throwable
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
//		String pw=fLib.getPropertyKeyValue("password");
		
//		WebDriver driver=new ChromeDriver();
//		wLib.waitForElementInDOM(driver);
//		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToVtiger(url,un,pw);
		
		jLib.getRandomNumber();
//		Random r=new Random();
//		int num=r.nextInt(1000);
		
		String name=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
//		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sh=book.getSheet("Sheet2");
//		String name=sh.getRow(0).getCell(0).getStringCellValue()+num;
//		System.out.println(name);
		
		
		
		//wLib.waitForElementInDOM(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrganizationBtn();
	}
	
	
	
	
		@Test(groups={"regression"})
		public void mandatoryFields() throws Throwable
		{
			
			FileUtility fLib = new FileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			
			String name=eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNumber();
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganization();
			
			OrganizationPage op = new OrganizationPage(driver);
			op.createOrganizationBtn();
			
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.organizationNameTB(name);
		cno.saveBtn();
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		//String actual = cno.validateOrganizationName();
		//String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String expected="Suv";
		/*
		if(actual.contains(expected))
		{
			System.out.println("fail");
		}
		else
		{
			System.out.println("pass");
		}
		*/
		//hp.signout();
		
		
		//Actions act1=new Actions(driver);
//		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mouseOverOnElement(driver, signout);
		//act.moveToElement(wb1).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
