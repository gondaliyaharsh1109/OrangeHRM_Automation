package allClassPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminPage extends BasePage{
    By firstSearchTab = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[1]");
    By verifyAdminText = By.xpath("//div[contains(@class,'oxd-topbar-header')]//span[contains(@class,'oxd-topbar')]");
    By clickAddBtn = By.xpath("//button[contains(normalize-space(),'Add')]");
    By verifyAddUserText = By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6 orangehrm-main-title')]");
    By clickUserRole = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");

    public AdminPage(WebDriver driver){
        super(driver);
    }
    public void addUserAndVerifyBySearch(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifySearchFunctionalityInToggle("ad","Admin");
        waitForElement(firstSearchTab).click();
        String actualAdminText = waitForElement(verifyAdminText).getText();
        String expectedAdminText = "Admin";
        Assert.assertEquals(actualAdminText,expectedAdminText);
    }
}
