package tests;

import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test
    public void login() {
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

}
//demonita27@malinator.com
//200592