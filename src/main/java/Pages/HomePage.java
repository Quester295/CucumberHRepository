package Pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.Elementutils;

public class HomePage {
	
	WebDriver driver;
	private Elementutils elementUtils;
	
	public  HomePage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver,this);
		elementUtils =new Elementutils(driver);
	}
	
	
	@FindBy(xpath= "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement Searchboxfield;
	
	@FindBy(xpath="//button[contains(@class,' btn-default ')]")
	private WebElement Searchbutton;
	
	public void ClickOnMyAccount()
	{
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public LoginPage selectLoginoption()
	{
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisteroption()
	{
		elementUtils.clickOnElement(RegisterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void EnterProductintoSearchbox(String ProductText) {
		
		elementUtils.typeTextintoElement(Searchboxfield, ProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		}
	
	public SearchResultsPage ClickSearchbutton() {
		elementUtils.clickOnElement(Searchbutton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
		
	}
	}
	

