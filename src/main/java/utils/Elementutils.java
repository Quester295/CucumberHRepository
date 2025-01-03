package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementutils {
	
	WebDriver driver;
	
	public Elementutils(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void clickOnElement(WebElement element,long durationinSeconds) {
		
		
		WebElement webelement=	waitforElement(element,durationinSeconds);
		webelement.click();
	}
	
	public void typeTextintoElement(WebElement element,String textToBeTyped,long durationinSeconds) {

		WebElement webelement=	waitforElement(element,durationinSeconds);
		
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeTyped); 
	}
	
	public WebElement waitforElement(WebElement element,long durationinSeconds) {
		
		WebElement webelement =null;

		try {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationinSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	} catch(Throwable e) {
		
		e.printStackTrace();
		
	}
		return webelement;
		
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption,long durationinseconds) {
		
		WebElement webelement=	waitforElement(element,durationinseconds);
		Select select =new Select(element);	
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationinseconds) {
		Alert alert= waitforAlert(durationinseconds);
		alert.accept();
		
	}
	
	public void DismissAlert(long durationinseconds) {
		
		Alert alert = waitforAlert(durationinseconds);
		alert.dismiss();
	}
	
	public Alert waitforAlert(long durationinseconds) {
		
		Alert alert=null;
		
		try {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationinseconds))	;
		 alert =wait.until(ExpectedConditions.alertIsPresent());
		}catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		return alert;
	}
	
	public  void mouseHoverAndClick(WebElement element,long durationinseconds) {
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(durationinseconds));
		WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions actions =new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();
			
		
	}
	 public WebElement waitforVIsibilityofElement(WebElement element,long durationinseconds) {
		 
		 WebElement webelement=null;
		 
		 try {
		 WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(durationinseconds));
			 webelement = wait.until(ExpectedConditions.visibilityOf(element));
		 }catch(Throwable e) {
			 
			 e.printStackTrace();
			 
		 }
		 
		 return webelement;
		 
	 }
	 
	 public void javaScriptClick (WebElement element,long durationinseconds) {
		 
		WebElement webelement= waitforVIsibilityofElement(element,durationinseconds);
		JavascriptExecutor jse =((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click;", webelement);
		 
	 }
	 
	 public void javaScriptType (WebElement element,long durationinseconds,String textTobeTyped) {
		 
		 WebElement webelement= waitforVIsibilityofElement(element,durationinseconds);
		 JavascriptExecutor jse =((JavascriptExecutor)driver);
		 jse.executeScript("arguments[0].value='"+ textTobeTyped+"'", webelement);
	 }
	 
	 public String getTextFromElement(WebElement element,long durationinseconds) {
		 WebElement webelement=	waitforElement(element,durationinseconds);
		return  webelement.getText();
		 
	 }
	 
	 public boolean displayStatusofElement(WebElement element,long durationinseconds) {
		try { 
		 WebElement webelement= waitforVIsibilityofElement(element,durationinseconds);
		 return webelement.isDisplayed();
		}catch (Throwable e) {
			return false;
		}
		
	 }
	 
	 
		 
	 }
			
	
	
		
	
	
	

	
	
