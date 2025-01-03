package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.Elementutils;

public class LoginPage {
	
	WebDriver driver ;
	private Elementutils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this); 
		elementUtils= new Elementutils(driver);
	}
		
        @FindBy(id="input-email")
		private WebElement emailField;
        
        @FindBy(id="input-password")
        private WebElement Passwordfield;
        
        @FindBy(xpath="//input[@value='Login']")
       private WebElement Loginbutton;
        
        @FindBy(xpath="//div[contains (@class,'alert-dismissible')]")
        private WebElement warningMessage;
        
        
 public void enterEmailAddress(String emailText) {
	     
            elementUtils.typeTextintoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
        	
    }
public void enterPassword(String PasswordText) {
	
	        elementUtils.typeTextintoElement(Passwordfield, PasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
 }

public AccountPage clickonLoginButton() {
	
	elementUtils.clickOnElement(Loginbutton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	return new AccountPage(driver);
	
}

public String getWarningMessageText() {
	
	return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
	
}


	


