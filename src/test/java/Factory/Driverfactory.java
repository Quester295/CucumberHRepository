package Factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public  class Driverfactory {
	
	static WebDriver driver=null;
	
	public static WebDriver intializeBrowser(String browserName) {
		
		
		
		
		if (browserName.equals("chrome")) {
			
			 driver= new ChromeDriver();
				
		}else if (browserName.equals("Firefox")) {
			
			 driver=new FirefoxDriver();
	
		}else if (browserName.equals("Edge")) {
			
			  driver =new EdgeDriver();
		}else if (browserName.equals("Safari")) {
			
			 driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		//driver.navigate().to("https://tutorialsninja.com/demo/");
		return driver;
		
		
	}	
	
		

	
public static  WebDriver getdriver() {
	
	return driver;
}

}
