package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class MyUpdatesPage {
    private static final String URL = "https://moodpanda.com/Feed/?Me=1";
    private static final String VALUE_OF_MOOD = "[class='MoodPostItem media-content']";


    public MyUpdatesPage openPage() {
        open(URL);
        return this;
    }

    public MyUpdatesPage isPageOpened() {
        try {
            $(VALUE_OF_MOOD).waitUntil(Condition.visible, 10000);
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + VALUE_OF_MOOD);
        }
        return this;
    }

    public MyUpdatesPage checkMoodDescription(String description) {
        $(VALUE_OF_MOOD);
        assertEquals($(VALUE_OF_MOOD).getText(), description, "Incorrect Error message");
        return this;
    }
}
