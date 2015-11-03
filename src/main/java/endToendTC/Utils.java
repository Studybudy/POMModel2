package endToendTC;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by vikas on 09/10/2015.
 */
public class Utils extends BaseClassPage {
    public static void type(By element,String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }
    public static void clickBtn(By element){
        driver.findElement(element).isDisplayed();
        driver.findElement(element).click();
    }
    public static void clickLink(String text){
        driver.findElement(By.linkText(text)).isDisplayed();
        driver.findElement(By.linkText(text)).click();
    }
    public static void selectFromDropdown(By element, String text){
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }
    public static int generateRandomNo(){
        Random random1= new Random();
        int randomNumber = random1.nextInt();
        return randomNumber;
    }
    public static void waitForSometime(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static boolean isElementPresent(By element) {
        return driver.findElement(element).isDisplayed();
    }
    public static boolean isChecklistSelected(By element) {
        return driver.findElement(element).isSelected();
    }
    public static boolean isTextPresent(String text){
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }
    public static void assertEquals(String s1, By element){
        Assert.assertEquals(s1, driver.findElement(element).getText());

    }
}
