package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;


public class DashboardLoginPage extends BasePage<DashboardLoginPage> {

    private final SelenideElement emailField = Selenide.element(By.id("email"));

    public SelenideElement emailErrorText = Selenide.element(By.id("email-helper-text"));
    private final SelenideElement passwordField = Selenide.element("[name='password']");

    public SelenideElement passwordErrorText = Selenide.element(By.id("input-meta-title-helper-text"));

    private final SelenideElement signInButton = Selenide.element("[type='submit']");
    public static SelenideElement allAccountsButton = Selenide.$x(("//p[contains(text(),'All Accounts')]"));


    public void enterEmail(String text) {
        this.emailField.sendKeys(text);
    }

    public void enterPassword(String text) {
        this.passwordField.sendKeys(text);
    }

    public void pressSignInButton() {
        this.signInButton.shouldBe(Condition.enabled).pressEnter();
    }

    @Override
    public String getUrl() {
        return "login";
    }


}
