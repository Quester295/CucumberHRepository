package Stepdefinition;

import java.sql.Driver;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.Driverfactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtils commonutils;


	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
      
		driver =   Driverfactory.getdriver();
		HomePage homepage = new HomePage(driver);
		homepage.ClickOnMyAccount();
		loginpage = homepage.selectLoginoption();

	}
	
	@When("^User enters valid email address(.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailtxt) {

		loginpage.enterEmailAddress(emailtxt);
	}

	@When("^User has enetered valid password (.+) into password field$")
	public void user_has_enetered_valid_password_into_password_field(String PasswordTxt) {

		loginpage.enterPassword(PasswordTxt);

	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {

		accountpage = loginpage.clickonLoginButton();

	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		
		Assert.assertTrue(accountpage.displaystatusofedityouraccountinformation());
	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidemailtxt) {

		commonutils = new CommonUtils();
		loginpage.enterEmailAddress(commonutils.getEmailWithTimestamp());

	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasswordtxt) {

		loginpage.enterPassword(invalidpasswordtxt);
	}

	@Then("User should get a proper warning message about creditionals mismatch")
	public void user_should_get_a_proper_warning_message_about_creditionals_mismatch() {

		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password"));

	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		loginpage.enterEmailAddress("");
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		loginpage.enterPassword("");
	}

	@When("User enters invalid email address  into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	    // Write code here that turns the phrase above into concrete actions
		commonutils = new CommonUtils();
		loginpage.enterEmailAddress(commonutils.getEmailWithTimestamp());
	}

}





