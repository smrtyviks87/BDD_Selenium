package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features={"src//test//java//features"}
        ,glue={"stepDefinitons","Utility"}
        ,plugin = {"pretty", "html:target/cucumber"}
        ,tags = ("@web")

)
@Test
public class RunTest extends AbstractTestNGCucumberTests {

}