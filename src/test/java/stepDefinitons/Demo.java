package stepDefinitons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Demo {
    public int countdown;
    @Test
    public void execute(){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring( NoSuchElementException.class )
                .ignoring( StaleElementReferenceException.class ) ;
        driver.get("https://e.ggtimer.com/");
        wait.until( ExpectedConditions.presenceOfElementLocated(
                By.id("start_a_timer") ) );


    }
}
