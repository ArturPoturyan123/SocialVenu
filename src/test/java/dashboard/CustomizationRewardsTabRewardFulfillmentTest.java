package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabRewardFulfillmentPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.*;

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
//        ToastHelper.waitForToastToDisappear();
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
//        ToastHelper.waitForToastToDisappear();
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
        customizationRewardsTabRewardFulfillmentPage.setWebHookUrl();
        String getNewWebHookUrl = customizationRewardsTabRewardFulfillmentPage.getCurrentWebHookUrl();
        String getCurrentWebHookUrl = customizationRewardsTabRewardFulfillmentPage.getCurrentWebHookUrl();
        assertThat(getNewWebHookUrl).isEqualTo(getCurrentWebHookUrl);
        customizationRewardsTabRewardFulfillmentPage.zoomPage();
        customizationRewardsTabRewardFulfillmentPage.clickSaveButton();
        customizationRewardsTabRewardFulfillmentPage.resetZoom();
        assertThat("Error: poster web Hook image is not appear",
                isElementDisplayed(customizationRewardsTabRewardFulfillmentPage.incentiveWebHook));
    }

    @Test(testName = "Verify the functionality of the 'Reward Your Customer' modal appear on Fulfilment section ")
    public void verifyFunctionalityRewardYourCustomerModalAppear() {
        CustomizationRewardsTabRewardFulfillmentPage customizationRewardsTabRewardFulfillmentPage =
                new CustomizationRewardsTabRewardFulfillmentPage();
        customizationRewardsTabRewardFulfillmentPage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(rewardYourCustomerModal, appear, Duration.ofSeconds(3));
        assertThat("Reward your Customer Text in not present ", isElementDisplayed(rewardYourCustomerModal));
    }
}
