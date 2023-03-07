package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage<T> {
    public T open()  {

        Selenide.open(getUrl());
        return (T) this;
    }

    public abstract String getUrl();

 }
