package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class AccountPage extends BasePage<AccountPage>  {

    public SelenideElement rootElement = Selenide.element("div[class*='MuiDrawer-docked']");
    private final SelenideElement arrowButton = element("button[aria-label='Account settings'] > div");
    private final SelenideElement profileButton = elements("ul[class*='MuiList-root'] > li").get(0);
    private final SelenideElement logoutButton = elements("ul[class*='MuiList-root'] > li").get(1);

    public void arrowButtonClick() {
        arrowButton.click(ClickOptions.usingJavaScript());
        element("ul[class*='MuiList-root']").shouldBe(Condition.visible);
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Override
    public String getUrl() {
        return "profile/accounts";
    }

    @Override
    public void refreshPage() {

    }


}
