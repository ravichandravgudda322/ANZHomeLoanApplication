package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import cucumber.api.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
