package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public abstract class BasePage<T> {
    private final SelenideElement saveButton = Selenide.$(By.id("bottom-bar-save-action"));


    public abstract String getUrl();


    public void refreshPage() {
        Selenide.refresh();
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

    public void eraseAllTextField(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(3000);
        if (!isElementDisplayed(saveButton)) {
            throw new NoSuchElementException("Save button not found ");
        } else {
            saveButton.click(ClickOptions.usingJavaScript());
        }
    }

    public boolean isElementDisplayed(SelenideElement element) {
        return element.exists() && element.isDisplayed();
    }

    public void scrollToElement(String elementId) {
        boolean isElementPresent = false;
        while (!isElementPresent) {
            try {
                Selenide.element(elementId).shouldBe(visible);
                isElementPresent = true;
            } catch (ElementNotFound e) {
                executeJavaScript("window.scrollBy(0, 500)");
            }
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
