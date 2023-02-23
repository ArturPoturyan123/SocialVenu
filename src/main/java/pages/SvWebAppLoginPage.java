package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SvWebAppLoginPage extends BasePage<SvWebAppLoginPage> {


    private SelenideElement login = Selenide.element("button[class*='MuiButton-text']");


    public void loginButton() {
        this.login.shouldBe(Condition.enabled).pressEnter();
    }

    @Override
    public String getUrl() {
        return "";
    }
}
