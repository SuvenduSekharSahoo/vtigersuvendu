package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IntegrationScenarioTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("CommonData/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("url");
		String un=pobj.getProperty("username");
		String pwd=pobj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//more
		Actions act=new Actions(driver);
		WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("(//a[text()='Vendors'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		
		Random r=new Random();
		int num=r.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("Sheet2");
		String name1=sh.getRow(0).getCell(0).getStringCellValue()+num;
		driver.findElement(By.name("vendorname")).sendKeys(name1);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//more-sales order
		Actions act1=new Actions(driver);
		WebElement wb1=driver.findElement(By.xpath("//a[text()='More']"));
		act1.moveToElement(wb1).perform();
		driver.findElement(By.xpath("//a[text()='Sales Order']")).click();
		
		//create sales order
		driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("");
	}

}
