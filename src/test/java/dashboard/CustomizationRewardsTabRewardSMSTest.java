package dashboard;

import base.DashboardTestBase;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabRewardSMSPage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static helper.WaitHelper.waitElementToPresent;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.*;
public class CustomizationRewardsTabRewardSMSTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of opening Sample Text popup")
    public void verifyFunctionalityOpeningSampleTextPopup() {
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage
                = new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        customizationRewardsTabRewardSMSPage.clickSendSampleButton();
        assertThat("Error: Sample Text popup is not present ",
                isElementDisplayed(customizationRewardsTabRewardSMSPage.sampleTextPopup));
    }

    @Test(testName = "Verify the functionality of update SMS message")
    public void verifyFunctionalityUpdateSMSMessage() {
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage
                = new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        String randomText = RandomUtils.getString();
        customizationRewardsTabRewardSMSPage.setRewardsSmsMessage(randomText);
        String currentRewardsSmsText = customizationRewardsTabRewardSMSPage.getCurrentRewardSmsMessage();
        customizationRewardsTabRewardSMSPage.zoomPage();
        waitElementToPresent(saveButton, appear, Duration.ofSeconds(5));
        customizationRewardsTabRewardSMSPage.clickSaveButton();
        customizationRewardsTabRewardSMSPage.resetZoom();
        String getCurrentRewardsSmsText = customizationRewardsTabRewardSMSPage.getCurrentRewardSmsMessage();
        AssertionsForClassTypes.assertThat(currentRewardsSmsText).isEqualTo(getCurrentRewardsSmsText);
    }

    @Test(testName = "Verify the functionality of the 'Reward Your Customer' modal appear on Reward SMS section ")
    public void verifyFunctionalityRewardYourCustomerModalAppear() {
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage =
                new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        clickHelpButton();
        assertThat("Reward your Customer Text in not present ", isElementDisplayed(rewardYourCustomerText));
    }
}
