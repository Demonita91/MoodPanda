package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test
    @Description("User update his mood with rate, description and specific date, hours, minutes")
    public void updateMoodOlderTest() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(6, "Everything is OK!", "Older", "1 am", ":00", "Oct", "2011", "2");
        rateYourHappinessModal
                .clickUpdateButton();
        myUpdatesPage
                .openPage()
                .isPageOpened()
                .checkMoodDescription("Everything is OK!");
    }

    @Test
    @Description("User update his mood with rate, description and the date: Now")
    public void updateMoodNowTest() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(3, "Everything is OK!", "Now");
        rateYourHappinessModal
                .clickUpdateButton();
        myUpdatesPage
                .openPage()
                .isPageOpened()
                .checkMoodDescription("Everything is OK!");
    }

    @Test
    @Description("User update his mood with rate, description and the date: Yesterday")
    public void updateMoodYesterdayTest() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(7, "Everything is OK!", "Yesterday");
        rateYourHappinessModal
                .clickUpdateButton();
        myUpdatesPage
                .openPage()
                .isPageOpened()
                .checkMoodDescription("Everything is OK!");
    }

}


