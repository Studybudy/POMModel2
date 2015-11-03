package endToendTC;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by vikas on 09/10/2015.
 */
public class RegressionPack extends BaseTest {
    String adminUsername = "Admin", adminPassword = "UIJtRgzn";
    String emplUsername = "EmplName"+Utils.generateRandomNo();
    String emplPassword = "Password123";
    String emplFirstName = "EmplFirstName", emplLastName = "EmplLastName";
    By spanMsg=By.id("spanMessage");


    LoginPage loginPage=new LoginPage(driver);
    AllOtherMethods allmethods = new AllOtherMethods(driver);

    @Test
    public void pimModuleEndToEnd(){
        loginPage.loginAttempt(adminUsername, adminPassword);
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        allmethods.adminCreatesEmployeeLogin(emplFirstName, emplLastName, emplUsername, emplPassword);
        loginPage.logoutAttempt();
        loginPage.loginAttempt(emplUsername, emplPassword);
        Assert.assertTrue(Utils.isTextPresent("Welcome EmplFirstName"));
        allmethods.employeeChecksLoginDetails();
        allmethods.employeeEditsDetails();
        loginPage.logoutAttempt();
        loginPage.loginAttempt(adminUsername, adminPassword);
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        allmethods.adminDeleteEmplDeetails();
        loginPage.logoutAttempt();
        loginPage.loginAttempt(emplUsername, emplPassword);
        Utils.assertEquals("Employee is deleted", spanMsg);




    }

}
