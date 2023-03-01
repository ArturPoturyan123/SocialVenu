package pages;

import com.codeborne.selenide.Selenide;

import java.util.concurrent.TimeUnit;


public abstract class BasePage<T> {
    public T open() {
        Selenide.open(getUrl());
        return (T) this;
    }

    public abstract String getUrl();

    public void refreshPage(){

        Selenide.refresh();
    }
}
