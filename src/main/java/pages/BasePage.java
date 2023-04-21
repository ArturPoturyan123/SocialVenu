package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import helper.ToastHelper;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.executeJavaScript;


public abstract class BasePage<T> {
    public static SelenideElement saveButton = Selenide.element(By.id("bottom-bar-save-action"));
    public static SelenideElement helpButton = Selenide.element(
            "button>svg[data-testid='HelpOutlineRoundedIcon']");
    public static SelenideElement rewardYourCustomerModal =
            Selenide.$x("//div//p[contains(text(),'Reward your customers')]");
    public static SelenideElement sayHelloToYourVideoAppModal =
            Selenide.$x("//div//h3[contains(text(),'Say hello to your Video App')]");
    public static SelenideElement trackingPixelsModal =
            Selenide.$x("//div//p[contains(text(),'Tracking Pixels')]");
    public static SelenideElement inviteYourCustomerModal =
            Selenide.$x("//div//p[contains(text(),'Upload Customer Information')]");


    public abstract String getUrl();


    public void refreshPage() {
        Selenide.refresh();
    }

    public static void clickHelpButton(SelenideElement element) {
        element.shouldBe(appear, Duration.ofSeconds(2)).click(ClickOptions.usingJavaScript());
    }


    public void eraseAllTextField(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public void clickSaveButton() {
        WaitHelper.waitElementToPresent(saveButton, appear, Duration.ofSeconds(5));
        if (!isElementDisplayed(saveButton)) {
            throw new NoSuchElementException("Save button not found ");
        } else {
            saveButton.click(ClickOptions.usingJavaScript());
            ToastHelper.waitForToastToDisappear();
        }
    }

    public static boolean isElementDisplayed(SelenideElement element) {
        return element.exists() && element.isDisplayed();
    }

    public void zoomPage() {
        try {
            executeJavaScript("document.body.style.zoom='150%'");
            Thread.sleep(3000);
        } catch (JavascriptException e) {
            System.out.println("Failed to zoom page: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void resetZoom() {
        try {
            executeJavaScript("document.body.style.zoom='100%'");
        } catch (JavascriptException e) {
            System.out.println("Failed to reset zoom: " + e.getMessage());
        }
    }


    public void scrollToElement(SelenideElement element) {
        if (!isElementDisplayed(element)){
            element.scrollIntoView(true).shouldBe(appear);
        }
    }

    public void scrollToAndClick(SelenideElement elementId) {
        boolean isElementPresent = false;
        while (!isElementPresent) {
            try {
                Selenide.element(elementId).click(ClickOptions.usingJavaScript());
                isElementPresent = true;
            } catch (ElementNotFound e) {
                executeJavaScript("window.scrollBy(0, 500)");
            }
        }
    }

    public T open() {
        Selenide.open(getUrl());
        return (T) this;
    }
}
