package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;

public abstract class BasePage<T> {
    public T open() {
        Selenide.open(getUrl());
        return (T) this;
    }

    public abstract String getUrl();


    public void refreshPage() {
        Selenide.refresh();
    }


    public void zoomPage() {
        try {
            Selenide.executeJavaScript("document.body.style.zoom='150%'");
        } catch (JavascriptException e) {
            System.out.println("Failed to zoom page: " + e.getMessage());
        }
    }

    public void resetZoom() {
        try {
            Selenide.executeJavaScript("document.body.style.zoom='100%'");
        } catch (JavascriptException e) {
            System.out.println("Failed to reset zoom: " + e.getMessage());
        }
    }

    public void eraseAllTextField(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public void clickOnSaveButton(SelenideElement element) throws InterruptedException {
        Thread.sleep(3000);
        if (!isButtonDisplayed(element)) {
            throw new NoSuchElementException("Save button not found ");
        } else {
            element.click(ClickOptions.usingJavaScript());
        }
    }

    public boolean isButtonDisplayed(SelenideElement element) {
        return element.exists() && element.isDisplayed();
    }
}
