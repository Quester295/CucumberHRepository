package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.Elementutils;

public class SearchResultsPage {
	
	WebDriver driver;
	private Elementutils elementUtils;
	
	
	public SearchResultsPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements( driver,this);
		elementUtils=new Elementutils(driver);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement ValidHPProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
    private WebElement messageText;


public boolean DisplayStatusofValidProduct() {
	
	return elementUtils.displayStatusofElement(ValidHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
}

public String getMessageText() {
	
	return elementUtils.getTextFromElement(messageText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	

}

}
