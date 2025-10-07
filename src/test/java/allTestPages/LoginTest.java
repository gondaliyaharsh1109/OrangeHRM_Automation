package allTestPages;

import allClassPages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void positiveLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("Admin","admin123");
    }
    @Test
    public void blankInputFieldsValidation(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtnWithoutEnteringCredentials();
    }
    @Test
    public void incorrectUsernameAndPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.incorrectUsernameAndPassword("hello admin","hello admin");
    }
}
