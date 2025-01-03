package Stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerpage;
	private  AccountSuccessPage accountsuccesspage;
	private CommonUtils commonutils;
	
	

	
	@Given("user navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		
		
		driver= Driverfactory.getdriver();
		HomePage homePage =new HomePage(driver);
		homePage.ClickOnMyAccount();
		registerpage=homePage.selectRegisteroption();
	
}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
	 Map<String, String> DataMap = dataTable.asMap(String.class, String.class);
	 

	 registerpage.EnterFirstname(DataMap.get("firstname"));
	 registerpage.EnterLastname(DataMap.get("Lastname"));
	 commonutils =new CommonUtils();
	 registerpage.Enteremailaddress(commonutils.getEmailWithTimestamp());
	 registerpage.EnterTelephone(DataMap.get("telephone"));
	 registerpage.EnterPassword(DataMap.get("Password"));
	 registerpage.EnterConfirmPassword(DataMap.get("Password"));
	 
	 
	}
	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
	 Map<String, String> DataMap = dataTable.asMap(String.class, String.class);
	 
	 
	 
	 registerpage.EnterFirstname(DataMap.get("firstname"));
	 registerpage.EnterLastname(DataMap.get("Lastname"));
	 registerpage.Enteremailaddress(DataMap.get("email"));
	 registerpage.EnterTelephone(DataMap.get("telephone"));
	 registerpage.EnterPassword(DataMap.get("Password"));
	 registerpage.EnterConfirmPassword(DataMap.get("Password"));
	 
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		
		registerpage.SelectPrivacyPolicy();  
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountsuccesspage =registerpage.ClickonContinueButton();  
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		
		Assert.assertEquals("Your Account Has Been Created", accountsuccesspage.GetPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerpage.selectYesNewletterOption();
	  
	}

	@Then("User should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() {
		
Assert.assertTrue(registerpage.GetwarningmessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user dont enter any details into field")
	public void user_dont_enter_any_details_into_field() {
		
		 registerpage.EnterFirstname("");
		 registerpage.EnterLastname("");
		 registerpage.Enteremailaddress("");
		 registerpage.EnterTelephone("");
		 registerpage.EnterPassword("");
		 registerpage.EnterConfirmPassword("");
		 }
@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		
		Assert.assertTrue(registerpage.GetwarningmessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.GetFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.GetLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.GetEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.GetTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.GetPasswordWarning());
	  
	}
	


}
