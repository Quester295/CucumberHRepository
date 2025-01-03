package Stepdefinition;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/resources/AppFeatures",
        glue={"Stepdefinition","Hooks"},
        publish=true,
        plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})


public class TestRunner  	 {


}
	


//	monochrome=true,
	  //  plugin = {"pretty", "html:target/htmlreport/cucumber-reports12.html",
	    		//  "junit:target/JUnitReports/junitreport12.xml",
	    		//   "json:target/cucumber/report12.json"}
       
		

