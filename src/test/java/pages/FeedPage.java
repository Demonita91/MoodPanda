package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class FeedPage {

    public static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    public FeedPage isPageOpened() {
        try {
            $(UPDATE_MOOD_CSS).waitUntil(Condition.visible, 10000);
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + UPDATE_MOOD_CSS);
        }
        return this;
    }

    public RateYourHappinessModal clickUpdate() {
        log.info("Click update mood button");
        $(UPDATE_MOOD_CSS).click();
        return new RateYourHappinessModal();
    }//?log
}
