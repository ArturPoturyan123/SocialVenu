package helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class WaitHelper {

    public static void waitElementToPresent(SelenideElement element, Condition condition, Duration seconds) {
        element.shouldBe(condition, seconds);
    }

    public static void waitTextFiledShouldBeEmpty(SelenideElement element, Condition condition, Duration seconds) {
        element.shouldBe(condition, seconds);
    }
}
