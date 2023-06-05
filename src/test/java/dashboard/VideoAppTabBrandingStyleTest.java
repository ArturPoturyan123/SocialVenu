package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.VideoAppTabBrandingStylePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static pages.BasePage.*;
import static pages.dashboard.VideoAppTabBrandingStylePage.uploadImage;

public class VideoAppTabBrandingStyleTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the opens Branding Style section")
    public void verifyFunctionalitySayHelloToYourVideoAppModalAppear() {
        VideoAppTabBrandingStylePage customizationVideoAppTabBrandingStylePage = new
                VideoAppTabBrandingStylePage();
        customizationVideoAppTabBrandingStylePage.open();
        WaitHelper.waitElementToPresent(uploadImage, appear, Duration.ofSeconds(3));
        Assert.assertTrue(  isElementDisplayed(uploadImage),
                "ERROR: Upload image text is not present ");
    }
}
