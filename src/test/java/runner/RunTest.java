package runner;

import Utility.FileReaderManager;
import Utility.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(features={"src//test//java//features"}
        ,glue={"stepDefinitons","Utility"}
        ,plugin = {"json:target/cucumber-reports/cucumber.json"}
        ,tags = ("@web")

)
@Test
public class RunTest extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getReportConfigPath()));

    }
}


