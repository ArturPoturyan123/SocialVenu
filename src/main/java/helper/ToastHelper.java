package helper;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;

public class ToastHelper {

    private static final SelenideElement toastNotificationSuccess =
            Selenide.element("div[class*='react-toast-notifications__toast--success']");

    private static SelenideElement getToastElement() {
        return toastNotificationSuccess;
    }

    public static void waitForToastToAppear() {
        SelenideElement toast = getToastElement();
        toast.shouldBe(appear);
    }

    public static void waitForToastToDisappear() {
        SelenideElement toast = getToastElement();
        toast.shouldBe(disappear, Duration.ofSeconds(5));
    }
}