package com.vtiger.comcast.GENERICUTILITY;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

public class WebDriverUtility {
	
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}

	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param element 
	 * @param object
	 */
	public void waitForElement (WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			          if(currentWindowTitle.contains(partialWindowTitle)) {
			        	  System.out.println("window switch successfully");
			        	  break;
			          }
		    	}
	}

	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 * @param expectedMsg
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver, String expectedMsg ) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().contains(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 * @param expectedMsg
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().contains(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		 alt.dismiss();
	}
	
	/**
	 * used to Switch to Alert Window & pass the msg inside the textbox
	 * @param driver
	 */
	public void switchToAlertWindowAndPassSendKeys(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("pass the value");
	}

	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to switch back the driver focus to main window
	 * @param driver
	 */
	public void switchBackFromFrameToMainWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element , String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	/**
	 * 
	 * @param driver 
	 * @param driver
	 * @param i
	 * @param j
	 * 
	 */
	public void executeJavaScript(WebDriver driver, int i, int j)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(i, j);");
	
	}
}
