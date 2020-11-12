package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class RateYourHappinessModal {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    private static final String CANCEL_BUTTON = "[class=.btn btn-sm btn-default pull-left']";
    private static final String UPDATE_BUTTON = "[class='btn btn-sm btn-primary ButtonUpdate']"; //вопрос по локатору
    private static final String TEXT_AREA = "#TextBoxUpdateMoodTag";
    private static final String DATE = "//div[contains(text(),'%s')]";
    private static final String HOURS = "#ddlHistoricHour";
    private static final String MINUTES = "#ddlHistoricMinute";
    private static final String MONTH = ".ui-datepicker-month";
    private static final String YEAR = ".ui-datepicker-year";
    private static final String DAY = "//*[contains(text(),'%s')]/ancestor::td//a";

    public void isUpdateMoodModalOpened() {
        try {
            $(UPDATE_BUTTON).waitUntil(Condition.visible, 10000);
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + UPDATE_BUTTON);
        }
    }

    public void updateMood(int moodRating, String description) {
        log.info("update mood with: " + moodRating + description);
        int defaultMood = 5;

        $(SLIDER_CSS).click();
        Keys direction;
        if (moodRating > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodRating - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }

        $(TEXT_AREA).sendKeys(description);

    }

    public void updateMood(int moodRating, String description, String date) {
        log.info("update mood with: " + moodRating + description + date);
        updateMood(moodRating, description);
        selectDate(date);

    }

    public void updateMood(int moodRating, String description, String date, String hours, String minutes) {
        log.info("update mood with: " + moodRating + description + date + hours + minutes);
        updateMood(moodRating, description, date);
        selectTime(hours, minutes);

    }

    public RateYourHappinessModal updateMood(int moodRating, String description, String date, String hours, String minutes, String month, String year, String day) {
        log.info("update mood with: " + moodRating + description + date + hours + minutes + month + year + day);
        updateMood(moodRating, description, date);
        selectMonth(month);
        selectYear(year);
        selectDay(day);
        selectTime(hours, minutes);
        return this;
    }

    public void selectDate(String date) {
        log.info("Select date: " + date);
        $(By.xpath(String.format(DATE, date))).click();
    }

    public void selectHours(String hours) {
        log.info("Select date: " + hours);
        new Select($(HOURS)).selectByVisibleText(hours);
    }

    public void selectMinutes(String minutes) {
        log.info("Select date: " +minutes);
        new Select($(MINUTES)).selectByVisibleText(minutes);
    }

    public void selectTime(String hours, String minutes) {
        log.info("Select date: " + hours + minutes);
        selectHours(hours);
        selectMinutes(minutes);
    }

    public void selectMonth(String month) {
        log.info("Select date: " + month);
        new Select($(MONTH)).selectByVisibleText(month);
    }

    public void selectYear(String year) {
        log.info("Select date: " + year);
        new Select($(YEAR)).selectByVisibleText(year);
    }

    public void selectDay(String day) {
        log.info("Select date: " + day);
        $(By.xpath(String.format(DAY, day))).click();
    }

    public void clickUpdateButton() {
        log.info("Press Update Mood button");
        $(UPDATE_BUTTON).click();
    }
}
