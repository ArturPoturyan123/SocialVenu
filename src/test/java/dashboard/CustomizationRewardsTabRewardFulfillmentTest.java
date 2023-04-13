package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabRewardFulfillmentPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.isElementDisplayed;

public class CustomizationRewardsTabRewardFulfillmentTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of enabling Manual SMS option")
    public void verifyFunctionalityEnablingManualSMS() {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickManualSMSButton();
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        ToastHelper.waitForToastToAppear();
        ToastHelper.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster Manual SMS image is not appear",
                isElementDisplayed(customizationRewardsTabRewardFulfillmentPage.posterManualSMS));

    }

    @Test(testName = "Verify the functionality of enabling Automate SMS option")
    public void verifyFunctionalityEnablingAutomaticSMS() {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickAutomaticSMSButton();
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        ToastHelper.waitForToastToAppear();
        ToastHelper.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster Automatic SMS image is not appear",
                isElementDisplayed(customizationRewardsTabRewardFulfillmentPage.posterAutomaticSMS));

    }

    @Test(testName = "Verify the functionality of enabling WebHook SMS option")
    public void verifyFunctionalityEnablingWebHookSMS() {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        customizationRewardsTabRewardFulfillmentPage.clickWebHookButton();
        String newWebhookUrl = customizationRewardsTabRewardFulfillmentPage.setWebHookUrl();
        String getCurrentWebHookUrl = customizationRewardsTabRewardFulfillmentPage.getCurrentWebHookUrl();
        assertThat(newWebhookUrl).isEqualTo(getCurrentWebHookUrl);
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        ToastHelper.waitForToastToAppear();
        ToastHelper.waitForToastToDisappear();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster web Hook image is not appear",
                isElementDisplayed(customizationRewardsTabRewardFulfillmentPage.incentiveWebHook));

    }
}
