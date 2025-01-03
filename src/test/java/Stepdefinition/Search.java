package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import Pages.HomePage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Search {
	
	WebDriver driver;
	private HomePage homepage;
	private SearchResultsPage searchresultspage;
	
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
	
		driver=  Driverfactory.getdriver();
	    
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validproducttxt) {
		
		homepage= new HomePage(driver);
		homepage.EnterProductintoSearchbox(validproducttxt);
	    
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
	
		searchresultspage=	homepage.ClickSearchbutton();   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		

		Assert.assertTrue(searchresultspage.DisplayStatusofValidProduct());
}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String Invalidproducttxt) {
		 homepage =new HomePage(driver);
		homepage.EnterProductintoSearchbox(Invalidproducttxt);
}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
	
		Assert.assertEquals("There is no product that matches the search criteria.", searchresultspage.getMessageText());
}

	@When("User dont enter any product name into Search")
	public void user_dont_enter_any_product_name_into_search() {
		homepage =new HomePage(driver);
	   
	}

}
