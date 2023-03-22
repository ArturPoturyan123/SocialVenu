package pages;

import com.codeborne.selenide.Selenide;

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
}
