package allTestPages;

import allClassPages.AdminPage;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest{
    @Test
    public void addUserAndVerifyBySearch(){
        AdminPage adminPage = new AdminPage(driver);
        adminPage.addUserAndVerifyBySearch();
    }
}
