package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationVideoAppTabBrandingStylePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.*;

public class CustomizationVideoAppTabBrandingStyleTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the 'say hello to your Video App' modal appear on Branding Style section")
    public void verifyFunctionalitySayHelloToYourVideoAppModalAppear() {
        CustomizationVideoAppTabBrandingStylePage customizationVideoAppTabBrandingStylePage = new
                CustomizationVideoAppTabBrandingStylePage();
        customizationVideoAppTabBrandingStylePage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(sayHelloToYourVideoAppModal, appear, Duration.ofSeconds(3));
        assertThat("Say hello to your Video App Text in not present ",
                isElementDisplayed(sayHelloToYourVideoAppModal));
    }
}
