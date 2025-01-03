package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.Elementutils;

public class AccountPage {
	
	WebDriver driver;
	private Elementutils elementutils;
	
	public AccountPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver,this);
		elementutils =new Elementutils(driver);
		
	}
	
  @FindBy(linkText="Edit your account information")
private WebElement editYourAccountInformationOption;
  
  
  public boolean displaystatusofedityouraccountinformation() {
	  
	 
	 return  elementutils.displayStatusofElement(editYourAccountInformationOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	   
	  
  }
	

  }

