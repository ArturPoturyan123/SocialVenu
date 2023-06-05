package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.VideoAppTabQrCodePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static pages.BasePage.inviteYourCustomerModal;
import static pages.BasePage.isElementDisplayed;

public class VideoAppTabQrCodeTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the opens QR Code section")
    public void verifyFunctionalityInviteYourCustomerModalAppear() {
        VideoAppTabQrCodePage videoAppTabQrCodePage = new VideoAppTabQrCodePage();
        videoAppTabQrCodePage.open();
        WaitHelper.waitElementToPresent(inviteYourCustomerModal, appear, Duration.ofSeconds(3));
        Assert.assertTrue(isElementDisplayed(inviteYourCustomerModal),
                "Invite your Customer Text in not present ");
    }
}
