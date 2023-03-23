package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
        Selenide.executeJavaScript("document.body.style.zoom='150%'");

    }


    public void resetZoom() {
        Selenide.executeJavaScript("document.body.style.zoom='100%'");

    }

    public void eraseAllTextField(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public void clickOnSaveButton(SelenideElement element) throws InterruptedException {
        Thread.sleep(3000);
        if (!IsButtonDisplayed(element)) {
            throw new NoSuchElementException("Save button not found ");
        } else {
            element.click(ClickOptions.usingJavaScript());
        }
    }


    public boolean IsButtonDisplayed(SelenideElement element) {
        return element.isDisplayed();
    }

}
