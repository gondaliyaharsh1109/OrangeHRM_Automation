package allClassPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeavePage extends BasePage{
    Faker faker = new Faker();
    Actions actions = new Actions(driver);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
    By employeeNameInputField = By.xpath("//input[@placeholder='Type for hints...']");
    By selectEmployeeOption = By.xpath("//div[@role='option']//span[normalize-space()='Orange Test']");
    By clickOnLeaveType = By.xpath("//div[contains(@class,'oxd-select-text--after')]");
    By selectLeaveOption = By.xpath("//div[@role='option']//span[normalize-space()='CAN - Personal']");
    By fromDatePicker = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    By toDatePicker = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    By partialDaysDropdown = By.xpath("(//div[contains(@class,'oxd-select-text oxd-select')])[2]");
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
    public void fillAssignLeaveForm(String employeeName) throws  InterruptedException{
        String fakeComment = faker.lorem().sentence(10);
        String fromDate = LocalDate.now().plusDays(2).format(formatter);
        String toDate = LocalDate.now().plusDays(3).format(formatter);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.executeLogin("Admin","admin123");
        dashboardPage.clickOnAssignLeaveBtn();

        waitForElement(employeeNameInputField).sendKeys(employeeName);
        actions.moveToElement(waitForElement(selectEmployeeOption)).click().perform();

        waitForElement(clickOnLeaveType).click();
        actions.moveToElement(waitForElement(selectLeaveOption)).click().perform();

        waitForElement(fromDatePicker).sendKeys(fromDate, Keys.TAB);
        waitForElement(toDatePicker).sendKeys(toDate);
//        Thread.sleep(1000);
        waitForElement(partialDaysDropdown).click();
//        Thread.sleep(1000);
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
