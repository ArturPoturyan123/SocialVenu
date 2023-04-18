package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationVideoAppTabTrackingPixelPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.*;

public class CustomizationVideoAppTabTrackingPixelTest extends DashboardTestBase {



    @Test(testName = "Verify the functionality of the 'Tracking Pixels' modal appear on Tracking Pixels section")
    public void verifyFunctionalitySayHelloToYourVideoAppModalAppear() {
        CustomizationVideoAppTabTrackingPixelPage customizationVideoAppTabTrackingPixelPage =
                new CustomizationVideoAppTabTrackingPixelPage();
        customizationVideoAppTabTrackingPixelPage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(trackingPixelsModal, appear, Duration.ofSeconds(3));
        assertThat("Tracking Pixels Text in not present ",
                isElementDisplayed(trackingPixelsModal));
    }
}
