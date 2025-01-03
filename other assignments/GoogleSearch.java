package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {
	
	WebDriver driver;
	
	@Given("Google browser is open")
	public void google_browser_is_open() {
		System.out.println("Inside Step- Google Browser is open");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("user is on google Search")
	public void user_is_on_google_search() {
		System.out.println("Inside step-user is on google search page ");
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		System.out.println("Inside step - user enters a text in search box ");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		Thread.sleep(2000);

	}

	@When("hits enter")
	public void hits_enter() {
		System.out.println("Inside step-hits enter ");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Inside step-user is navigated to search results ");
		
		driver.getPageSource().contains("Online Courses");
			driver.close();
		driver.quit();

	}


}
