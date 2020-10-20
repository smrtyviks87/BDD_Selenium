package stepDefinitons;

import Utility.Hook;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages.EggtimerHome;
import pages.EggtimerCountdown;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    public WebDriver driver;
    public String URL;
    public By txtStarttimer,btnGo,txtCountdown;
    public long starttime;
    public MyStepdefs(){
        this.driver= Hook.getDriver();
        this.URL=Hook.baseURL;
        this.txtStarttimer=EggtimerHome.txtStarttimer;
        this.btnGo=EggtimerHome.btnGo;
        this.txtCountdown=EggtimerCountdown.txtCountdown;
    }

    @Given("I am on the eggtimer application")
    public void i_am_on_the_eggtimer_application() throws Throwable {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring( NoSuchElementException.class )
                .ignoring( StaleElementReferenceException.class ) ;
        driver.get(URL);
        wait.until( ExpectedConditions.presenceOfElementLocated(
                By.id("start_a_timer") ) );


    }

    @And("I See Input field for period")
    public void iSeeInputFieldForPeriod() {
    Assert.assertTrue(driver.findElement(txtStarttimer).isDisplayed());
     }

    @And("I see a button {string}")
    public void iSeeAButton(String arg0) {

        Assert.assertTrue(driver.findElement(btnGo).isDisplayed());
        String actualbtntext=driver.findElement(btnGo).getAttribute("alt");
        Assert.assertEquals(actualbtntext,arg0);

    }

    @When("I Enter invalid period {string}")
    public void iEnterInvalidPeriod(String arg0) {
        driver.findElement(txtStarttimer).clear();
        driver.findElement(txtStarttimer).sendKeys(arg0);
            }

    @And("I Click Go Button")
    public void iClickGoButton() {
        driver.findElement(btnGo).click();
        starttime=System.currentTimeMillis()/1000;

    }

    @Then("I should be asked to enter valid period")
    public void iShouldBeAskedToEnterValidPeriod() {
        driver.findElement(By.xpath("//*[contains(., 'Enter valid period')]"));
    }

    @Then("I should see the timer is started")
    public void iShouldSeeTheTimerIsStarted() throws Throwable {

    }


    @When("I Enter valid period {string}")
    public void iEnterValidPeriod(String arg0) {
        driver.findElement(txtStarttimer).clear();
        driver.findElement(txtStarttimer).sendKeys(arg0);
    }

    @Then("I should see the timer is started {string}")
    public void iShouldSeeTheTimerIsStarted(String arg0) throws Throwable {
        String expectedtxt,actualtxt;

        int actualcountdown;

        Assert.assertTrue(driver.findElement(txtCountdown).isDisplayed());
        expectedtxt=arg0;
        actualtxt=driver.findElement(txtCountdown).getText();
        Assert.assertEquals(expectedtxt,actualtxt);
        int countdownval=Integer.parseInt(driver.findElement(txtCountdown).getText().substring(0,2).trim());
        while(countdownval>0){
            String actualtext=driver.findElement(txtCountdown).getText();
            actualcountdown=Integer.parseInt(driver.findElement(txtCountdown).getText().substring(0,2).trim());

            if(actualcountdown == 1){
                expectedtxt= countdownval+" second";
            }else{
                expectedtxt= countdownval+" seconds";
            }
           Assert.assertEquals(expectedtxt,actualtext);
            countdownval=actualcountdown;
            TimeUnit.SECONDS.sleep(1);
            countdownval=countdownval-1;
        }


    }
}
