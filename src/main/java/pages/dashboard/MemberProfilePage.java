package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class MemberProfilePage extends BasePage<MemberProfilePage> {
    private SelenideElement revokeInviteButton = Selenide.element("p.MuiTypography-root.MuiTypography-body1.css-1gollgz");



    public void clickOnRevokeInviteButton (){

        revokeInviteButton.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return null;
    }
}
