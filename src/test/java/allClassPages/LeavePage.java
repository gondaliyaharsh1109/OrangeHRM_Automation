package allClassPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeavePage extends BasePage{
    Faker faker = new Faker();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
    By employeeNameInputField = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeOptionClick = By.xpath("//div[@role='listbox']//span[normalize-space()='Test User 1']");
    By clickOnLeaveType = By.xpath("//div[@class='oxd-select-text-input']");
    By selectLeaveType = By.xpath("//div[@role='listbox']//span[normalize-space()='CAN - Personal']");
    By fromDatePicker = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    By toDatePicker = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    By partialDaysDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By daysSelectionDropdown = By.xpath("//div[@role='listbox']//span[normalize-space()='All Days']");
    By durationDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
    By durationSelectionDropdown = By.xpath("//div[@role='listbox']//span[normalize-space()='Half Day - Morning']");
    By commentsInputField = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By clickAssignBtn = By.xpath("//button[@type='submit']");
    By clickOkBtn = By.xpath("//button[contains(.,'Ok')]");
    By verifyLeaveSavedText = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']");

    public LeavePage(WebDriver driver){
        super(driver);
    }
    public WebElement elementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void fillAssignLeaveForm(String employeeName){
        String fakeComment = faker.lorem().sentence(10);
        String fromDate = LocalDate.now().plusDays(2).format(formatter);
        String toDate = LocalDate.now().plusDays(10).format(formatter);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.executeLogin("Admin","admin123");
        dashboardPage.clickOnAssignLeaveBtn();
        waitForElement(employeeNameInputField).sendKeys(employeeName);
        waitForElement(employeeOptionClick).click();
//        String option = String.format("//div[@role='listbox']//span[normalize-space()='%s']",employeeOption);
//        WebElement employeeOptions = driver.findElement(By.xpath(option));
//        employeeOptions.click();
        waitForElement(clickOnLeaveType).click();
        waitForElement(selectLeaveType).click();
        waitForElement(fromDatePicker).sendKeys(fromDate);
        waitForElement(toDatePicker).sendKeys(toDate);
        waitForElement(partialDaysDropdown).click();
        waitForElement(daysSelectionDropdown).click();
        waitForElement(durationDropdown).click();
        waitForElement(durationSelectionDropdown).click();
        waitForElement(commentsInputField).sendKeys(fakeComment);
        waitForElement(clickAssignBtn).click();
        waitForElement(clickOkBtn).click();
        String actualLeaveSavedText = waitForElement(verifyLeaveSavedText).getText();
        String expectedLeaveSavedText = "Success";
        Assert.assertEquals(actualLeaveSavedText,expectedLeaveSavedText);
    }
}
