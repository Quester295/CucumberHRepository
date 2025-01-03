package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.Elementutils;

public class RegisterPage {
	
	WebDriver driver;
	private Elementutils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements( driver, this);
		elementUtils= new Elementutils(driver);
	}
	
	@FindBy (id="input-firstname")
    private WebElement FirstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement EmailField;
	
	@FindBy(id="input-telephone")
	private WebElement TelephoneField ;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(id="input-confirm")
	private WebElement PasswordConfirmField;
	
	@FindBy(name= "agree" )
	private WebElement PrivacyPolicyoption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'] [@value='1']")
	private WebElement YesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningmessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement FirstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement PasswordWarnig;
	
	
public void EnterFirstname(String FirstNameText) {
	
	   elementUtils.typeTextintoElement(FirstNameField, FirstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
		
	public void EnterLastname(String LastNameText) {
		
		elementUtils.typeTextintoElement(LastNameField, LastNameText,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void Enteremailaddress(String EmailText) {
		
		elementUtils.typeTextintoElement(EmailField, EmailText,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
		
	}
	
	public void EnterTelephone(String TelephoneText) {
		
		elementUtils.typeTextintoElement(TelephoneField, TelephoneText,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
		
		public void EnterPassword( String PasswordText) {
			
			elementUtils.typeTextintoElement(PasswordField, PasswordText,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			}
		
		public void EnterConfirmPassword(String PasswordText) {
			
			elementUtils.typeTextintoElement( PasswordConfirmField, PasswordText,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
		}
		
		public void SelectPrivacyPolicy() {
			
			elementUtils.clickOnElement(PrivacyPolicyoption,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		}
			
		public AccountSuccessPage ClickonContinueButton() {
			
			elementUtils.clickOnElement(continueButton,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			return new AccountSuccessPage(driver);
	}
		
		public void selectYesNewletterOption() {
			elementUtils.clickOnElement(YesNewsLetterOption,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
}
		
		public String GetwarningmessageText() {
		
			return elementUtils.getTextFromElement(warningmessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
		
		public String GetFirstNameWarning() {
			
		return elementUtils.getTextFromElement(FirstNameWarning,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
		
		public String GetLastNameWarning() {
			
			return elementUtils.getTextFromElement(LastNameWarning,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
		
		public String GetEmailWarning() {
			
			return elementUtils.getTextFromElement(EmailWarning,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
}
		
		public String GetTelephoneWarning() {
			
		return elementUtils.getTextFromElement(TelephoneWarning,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
}
		
		public String GetPasswordWarning() {
			
			return elementUtils.getTextFromElement(PasswordWarnig,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
		
			
		}
			
		
			
		
			
			
		}
		
		
		
	

	
	
	

	
	
	
		
	
		
	
	

