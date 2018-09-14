package start;



import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= ("src/test/java/features"),glue={"implementation"},plugin= {"pretty","html:target/cucumber"})

@Test
public class Runner extends AbstractTestNGCucumberTests{

}
