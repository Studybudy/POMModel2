package endToendTC;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by vikas on 09/10/2015.
 */
public class LoginPage extends BaseClassPage {
    By userName= By.id("txtUsername");
    By password=By.id("txtPassword");
    By login=By.id("btnLogin");
    By welcome = By.id("welcome");
    By logout = By.linkText("Logout");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void setUserNameOHRM(String UserName)
    {
        Utils.type(userName,UserName);
    }
    public void setPassword(String Password)
    {
        Utils.type(password,Password);
    }
    public void clickLogin()
    {
        Utils.clickBtn(login);
    }

    public void loginAttempt(String UserName,String Password)
    {
        this.setUserNameOHRM(UserName);
        this.setPassword(Password);
        this.clickLogin();
    }
    public void logoutAttempt(){
        Utils.clickBtn(welcome);
        Utils.clickBtn(logout);
    }
}
