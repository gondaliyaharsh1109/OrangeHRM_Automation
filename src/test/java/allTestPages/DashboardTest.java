package allTestPages;

import allClassPages.DashboardPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{
    @Test
    public void verifyToggleFunctionality(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyToggleFunctionality();
    }
    @Test
    public void verifySearchFunctionalityOnDashboard(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifySearchFunctionalityOnDashboard("da","Dashboard");
    }
    @Test
    public void logoutFunctionality(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logoutFunctionality();
    }
}
