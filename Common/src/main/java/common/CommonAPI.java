package common;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/resources/features/login.feature", glue = {"steps"})
public class CommonAPI extends AbstractTestNGCucumberTests {

    public static WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "../Common/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
