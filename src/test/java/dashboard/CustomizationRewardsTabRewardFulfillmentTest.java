package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabRewardFulfillmentPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomizationRewardsTabRewardFulfillmentTest extends DashboardTestBase {


    @Test(testName = "verify the functionality of enabling Manual SMS option")
    public void verifyFunctionalityEnablingManualSMS() throws InterruptedException {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickManualSMSButton();
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToAppear();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster Manual SMS image is not appear",
                customizationRewardsTabRewardFulfillmentPage.isButtonDisplayed
                        (customizationRewardsTabRewardFulfillmentPage.posterManualSMS));

    }

    @Test(testName = "verify the functionality of enabling Automate SMS option")
    public void verifyFunctionalityEnablingAutomaticSMS() throws InterruptedException {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickAutomaticSMSButton();
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToAppear();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster Automatic SMS image is not appear",
                customizationRewardsTabRewardFulfillmentPage.isButtonDisplayed
                        (customizationRewardsTabRewardFulfillmentPage.posterAutomaticSMS));

    }

    @Test(testName = "verify the functionality of enabling WebHook SMS option")
    public void verifyFunctionalityEnablingWebHookSMS() throws InterruptedException {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickWebHookButton();
        String newWebhookUrl = customizationRewardsTabRewardFulfillmentPage.setWebHookUrl();
        String getCurrentWebHookUrl = customizationRewardsTabRewardFulfillmentPage.getCurrentWebHookUrl();
        assertThat(newWebhookUrl).isEqualTo(getCurrentWebHookUrl);
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToAppear();
        customizationRewardsTabRewardFulfillmentPage.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster web Hook image is not appear",
                customizationRewardsTabRewardFulfillmentPage.isButtonDisplayed
                        (customizationRewardsTabRewardFulfillmentPage.incentiveWebHook));

    }
}
