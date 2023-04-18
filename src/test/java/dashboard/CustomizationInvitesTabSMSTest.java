package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationInvitesTabSMSPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.*;

public class CustomizationInvitesTabSMSTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the 'invite your customer' modal appear on invites SMS section")
    public void verifyFunctionalityInviteYourCustomerModalAppear() {
        CustomizationInvitesTabSMSPage customizationInvitesTabSMSPage = new CustomizationInvitesTabSMSPage();
        customizationInvitesTabSMSPage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(inviteYourCustomerModal, appear, Duration.ofSeconds(3));
        assertThat("Invite your Customer Text in not present ",
                isElementDisplayed(inviteYourCustomerModal));
    }
}
