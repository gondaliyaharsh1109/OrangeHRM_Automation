package allClassPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage extends BasePage{
    LoginPage loginPage = new LoginPage(driver);
    By clickToggleBtn = By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']");
    By searchInputField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    By firstSearchTab = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[1]");
    By clickBtnForLogout = By.xpath("//p[@class='oxd-userdropdown-name']");
    By clickLogout = By.xpath("//a[contains(text(),'Logout')]");
    By verifyLoginTextOnLoginPage = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
    By clickOnAssignLeaveBtn = By.xpath("//button[@title='Assign Leave']");

    public DashboardPage(WebDriver driver){
        super(driver);
    }
    public void waitForElementsToBeInvisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void verifyToggleFunctionality(){
        loginPage.executeLogin("Admin","admin123");
        waitForElement(clickToggleBtn).click();
        waitForElementsToBeInvisible(searchInputField);
        waitForElement(clickToggleBtn);
        waitForElement(clickToggleBtn).click();
        waitForElement(searchInputField);
    }
    public void verifySearchFunctionalityOnDashboard(String search, String searchedTab){
        loginPage.executeLogin("Admin","admin123");
        waitForElement(searchInputField).sendKeys(search);
        String actualText = waitForElement(firstSearchTab).getText();
        Assert.assertEquals(actualText,searchedTab);
    }
    public void logoutFunctionality(){
        loginPage.executeLogin("Admin","admin123");
        waitForElement(clickBtnForLogout).click();
        waitForElement(clickLogout).click();
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(actualUrl,expectedUrl);
        String actualLoginText = waitForElement(verifyLoginTextOnLoginPage).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText,expectedLoginText);
    }
    public void clickOnAssignLeaveBtn(){
        waitForElement(clickOnAssignLeaveBtn).click();
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}