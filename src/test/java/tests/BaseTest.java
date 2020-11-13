package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.FeedPage;
import pages.LoginPage;
import pages.MyUpdatesPage;
import pages.RateYourHappinessModal;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModal rateYourHappinessModal;
    MyUpdatesPage myUpdatesPage;
    String email = "demonita27@malinator.com";
    String password = "200592";

    @BeforeMethod
    public void setUp(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModal = new RateYourHappinessModal();
        myUpdatesPage = new MyUpdatesPage();

    }

   @AfterMethod(alwaysRun = true)
        public void closeBrowser(){
        getWebDriver().quit();
   }

}
