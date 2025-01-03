package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.Elementutils;

public class AccountSuccessPage {
	
	WebDriver driver;
	private Elementutils elementUtils;

	public AccountSuccessPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new Elementutils(driver);

}
	@FindBy(xpath="//div[@id= 'content']/h1")
	private WebElement pageHeading;
	
	
	public String GetPageHeading() {
		
		return elementUtils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
}
