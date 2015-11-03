package endToendTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by vikas on 09/10/2015.
 */
public class AllOtherMethods extends BaseClassPage {
    public String empid;
    By pimModule = By.id("menu_pim_viewPimModule");
    By addemployee = By.id("menu_pim_addEmployee");
    By firname = By.id("firstName");
    By lstname = By.id("lastName");
    By chkBtn = By.id("chkLogin");
    By employeeId= By.id("employeeId");
    By username = By.id("user_name");
    By userPassword = By.id("user_password");
    By confPassword = By.id("re_password");
    By status = By.id("status");
    By location = By.id("location");
    By save = By.id("btnSave");
    By profilePic = By.id("profile-pic");
    public AllOtherMethods(WebDriver driver)
    {
        this.driver=driver;
    }

    public void adminCreatesEmployeeLogin(String Firname, String Lstname, String Username,String UserPassword){
        Utils.clickBtn(pimModule);
        Utils.clickBtn(addemployee);
        Utils.type(firname, Firname);
        Utils.type(lstname, Lstname);
        empid= driver.findElement(employeeId).getAttribute("value");
        Utils.clickBtn(chkBtn);
        Utils.waitForSometime();
        Utils.type(username, Username);
        Utils.type(userPassword, UserPassword);
        Utils.type(confPassword, UserPassword);
        Utils.selectFromDropdown(status, "Enabled");
        Utils.selectFromDropdown(location, "Australian Regional HQ");
        Utils.clickBtn(save);
        Utils.assertEquals("EmplFirstName EmplLastName", profilePic);

    }
    public void employeeChecksLoginDetails(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Utils.assertEquals("EmplFirstName EmplLastName",profilePic);
    }
    By edit = By.id("btnSave");
    By nationality = By.id("personal_cmbNation");
    By gender = By.id("personal_optGender_2");
    By meritsts = By.id("personal_cmbMarital");
    By savebtn = By.id("btnSave");
    public void employeeEditsDetails(){
        Utils.clickBtn(edit);
        Utils.selectFromDropdown(nationality, "Indian");
        Utils.clickBtn(gender);
        Utils.selectFromDropdown(meritsts, "Single");
        Utils.clickBtn(savebtn);
    }
    By emplList = By.id("menu_pim_viewEmployeeList");
    By emplsearch = By.id("empsearch_id");
    By search = By.id("searchBtn");
    public void searchEmployee(String empid){
        Utils.clickBtn(pimModule);
        Utils.clickBtn(emplList);
        Utils.type(emplsearch, empid);
        Utils.clickBtn(search);
    }
    By checkBix = By.id("ohrmList_chkSelectAll");
    By delete = By.id("btnDelete");
    By deleteOk = By.id("dialogDeleteBtn");
    public void adminDeleteEmplDeetails(){
        this.searchEmployee(empid);
        Utils.waitForSometime();
        Utils.clickBtn(checkBix);
        Utils.clickBtn(delete);
        Utils.clickBtn(deleteOk);

    }



}
