package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationVideoAppTabVideoPlaybackPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.*;

public class CustomizationVideoAppTabVideoPlaybackTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the 'say hello to your Video App' modal appear on Video Playback section")
    public void verifyFunctionalitySayHelloToYourVideoAppModalAppear() {
        CustomizationVideoAppTabVideoPlaybackPage customizationVideoAppTabVideoPlaybackPage =
                new CustomizationVideoAppTabVideoPlaybackPage();
        customizationVideoAppTabVideoPlaybackPage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(sayHelloToYourVideoAppModal, appear, Duration.ofSeconds(3));
        assertThat("Say hello to your Video App Text in not present ",
                isElementDisplayed(sayHelloToYourVideoAppModal));
    }
}
