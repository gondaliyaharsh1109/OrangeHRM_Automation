package allClassPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminPage extends BasePage{
    By firstSearchTab = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[1]");
    By verifySystemUsersText = By.xpath("//div[contains(@class,'oxd-table-filter-header-title')]");
    By clickAddBtn = By.xpath("//button[contains(normalize-space(),'Add')]");
    By verifyAddUserText = By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6 orangehrm-main-title')]");
    By clickUserRole = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    By selectAdminRole = By.xpath("//div[contains(@role,'listbox')]//span[contains(text(),'Admin')]");
    By employeeNameInputField = By.xpath("//input[@placeholder='Type for hints...']");
    By selectEmployeeOption = By.xpath("//div[@role='option']//span[normalize-space()='Orange Test']");
    By clickStatus = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[2]");
    By selectStatus = By.xpath("//div[contains(@role,'listbox')]//span[contains(text(),'Enabled')]");
    By usernameInputField = By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
    By passwordInputField = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordInputField = By.xpath("(//input[@type='password'])[2]");
    By clickSubmitBtn = By.xpath("//button[contains(normalize-space(),'Save')]");

    public AdminPage(WebDriver driver){
        super(driver);
    }
    public void addUserAndVerifyBySearch(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifySearchFunctionalityInToggle("ad","Admin");
        waitForElement(firstSearchTab).click();
        String actualSystemUsersText = waitForElement(verifySystemUsersText).getText();
        String expectedSystemUsersText = "System Users";
        Assert.assertEquals(actualSystemUsersText,expectedSystemUsersText);
        waitForElement(clickAddBtn).click();
        String actualAddUserText = waitForElement(verifyAddUserText).getText();
        String expectedAddUserText = "Add User";
        Assert.assertEquals(actualAddUserText,expectedAddUserText);
    }
}
