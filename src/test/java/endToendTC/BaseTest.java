package endToendTC;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by vikas on 09/10/2015.
 */
public class BaseTest extends BaseClassPage {
    static String URL = "http://srikanthgoudm.trial412.orangehrmlive.com";

    @BeforeClass
    public static void openBrowser(){
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
