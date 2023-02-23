package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class DashboardLoginPage extends BasePage<DashboardLoginPage> {


    private SelenideElement email = Selenide.element(By.id("email"));
    private SelenideElement password = Selenide.element("[name='password']");
//    private SelenideElement signInButton = Selenide.element("button[class*='MuiButton-text']");
    private SelenideElement signInButton = Selenide.element("[type='submit']");


    public void enterEmail(String text) {

        this.email.sendKeys(text);
    }

    public void enterPassword(String text) {

        this.password.sendKeys(text);
    }

    public void pressSignInButton() {

        this.signInButton.shouldBe(Condition.enabled).pressEnter();
    }

    @Override
    public String getUrl() {
        return "login";
    }
}
