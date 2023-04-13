package dashboard;

import base.DashboardTestBase;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabRewardSMSPage;
import utils.RandomUtils;

import static org.hamcrest.MatcherAssert.assertThat;

public class CustomizationRewardsTabRewardSMSTest extends DashboardTestBase {


    @Test(testName = "verify the functionality of opening Sample Text popup")
    public void verifyFunctionalityOpeningSampleTextPopup() {
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage
                = new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        customizationRewardsTabRewardSMSPage.clickSendSampleButton();
        assertThat("Error: Sample Text popup is not present ",
                customizationRewardsTabRewardSMSPage.isElementDisplayed
                        (customizationRewardsTabRewardSMSPage.sampleTextPopup));


    }

    @Test(testName = "verify the functionality of update SMS message")
    public void verifyFunctionalityUpdateSMSMessage() {
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage
                = new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        String randomText = RandomUtils.getString();

        customizationRewardsTabRewardSMSPage.setRewardsSmsMessage(randomText);
        String currentRewardsSmsText = customizationRewardsTabRewardSMSPage.setRewardsSmsMessage(randomText);
        String getCurrentRewardsSmsText = customizationRewardsTabRewardSMSPage.getCurrentRewardSmsMessage();
        AssertionsForClassTypes.assertThat(currentRewardsSmsText).isEqualTo(getCurrentRewardsSmsText);


    }

}
