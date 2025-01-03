package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Myhooks {
	
	WebDriver driver;
	private ConfigReader configreader;
	
	
	
	
	@Before
	public void setup() {
	
		 configreader= new ConfigReader();
		Properties prop =configreader.intializeProperties();
	      driver= Driverfactory.intializeBrowser(prop.getProperty("browser"));
   	driver.get(prop.getProperty("url"));
	
}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName= scenario.getName().replaceAll("","_");
		
		if (scenario.isFailed()) {
			
			byte[] SrcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(SrcScreenshot, "image/png", scenarioName);
		}
		
		
		
		  driver.quit();
		
	}
	
	

}
