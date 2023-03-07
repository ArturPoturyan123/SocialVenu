package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MemberProfilePage extends BasePage<MemberProfilePage> {
    private SelenideElement revokeInviteButton = Selenide.element("p.MuiTypography-root.MuiTypography-body1.css-1gollgz");
    private SelenideElement deleteThisUserButton = $x("//p[contains(text(), 'Delete This User')][not(contains(., 'Delete This User?'))]");
    public SelenideElement deleteUserPopup = Selenide.element("div>[class*='sv-dashboard-jss921']");



    public void deleteMember() {
        deleteThisUserButton.shouldBe(Condition.visible).click();


    }



    public void clickOnRevokeInviteButton (){

        revokeInviteButton.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return null;
    }
}
