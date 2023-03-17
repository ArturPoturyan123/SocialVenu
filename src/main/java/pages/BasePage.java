package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage<T>  {
    public T open() {

        Selenide.open(getUrl());
        return (T) this;
    }

    public abstract String getUrl();

    public abstract void refreshPage();

    public abstract void zoomPage();

    public abstract void resetZoom();


}
