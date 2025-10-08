package allTestPages;

import allClassPages.LeavePage;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest{
    @Test
    public void fillAssignLeaveForm(){
        LeavePage leavePage = new LeavePage(driver);
        leavePage.fillAssignLeaveForm("Orange");
    }
}
