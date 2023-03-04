package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage<T> {
    public T open() throws InterruptedException {

        Selenide.open(getUrl());
        Thread.sleep(3000);
        return (T) this;
    }

    public abstract String getUrl();

 }
