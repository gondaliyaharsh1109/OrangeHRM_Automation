package allClassPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    By userNameInputField = By.xpath("//input[@name='username']");
    By passwordInputField = By.xpath("//input[@name='password']");
    By clickLoginBtn = By.xpath("//button[@type='submit']");
    By visibleDashboardText = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");
    By userNameRequireText = By.xpath("(//span[contains(.,'Required')])[1]");
    By passwordRequireText = By.xpath("(//span[contains(.,'Required')])[2]");
    By invalidCredentialsText = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void visitLoginPage(){
        visits("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void executeLogin(String username, String password){
        visitLoginPage();
        waitForElement(userNameInputField).sendKeys(username);
        waitForElement(passwordInputField).sendKeys(password);
        waitForElement(clickLoginBtn).click();
        String actualVisibleTextAfterLogin = waitForElement(visibleDashboardText).getText();
        String expectedVisibleTextAfterLogin = "Dashboard";
        Assert.assertEquals(actualVisibleTextAfterLogin,expectedVisibleTextAfterLogin);
    }
    public void clickLoginBtnWithoutEnteringCredentials(){
        visitLoginPage();
        waitForElement(clickLoginBtn).click();
        String actualVisibleUsernameRequiredText = waitForElement(userNameRequireText).getText();
        String expectedVisibleUsernameRequiredText = "Required";
        Assert.assertEquals(actualVisibleUsernameRequiredText,expectedVisibleUsernameRequiredText);
        String actualVisiblePasswordRequiredText = waitForElement(passwordRequireText).getText();
        String expectedVisiblePasswordRequiredText = "Required";
        Assert.assertEquals(actualVisiblePasswordRequiredText,expectedVisiblePasswordRequiredText);
    }
    public void incorrectUsernameAndPassword(String username, String password){
        visitLoginPage();
        waitForElement(userNameInputField).sendKeys(username);
        waitForElement(passwordInputField).sendKeys(password);
        waitForElement(clickLoginBtn).click();
        String actualInvalidCredentialText = waitForElement(invalidCredentialsText).getText();
        String expectedInvalidCredentialText = "Invalid credentials";
        Assert.assertEquals(actualInvalidCredentialText,expectedInvalidCredentialText);
    }
}