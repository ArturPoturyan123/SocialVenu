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
import static pages.BasePage.isElementDisplayed;
import static pages.BasePage.saveButton;

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
    public void verifyFunctionalityUpdateSMSMessage(){
        CustomizationRewardsTabRewardSMSPage customizationRewardsTabRewardSMSPage
                = new CustomizationRewardsTabRewardSMSPage();
        customizationRewardsTabRewardSMSPage.open();
        String randomText = RandomUtils.getString();
        customizationRewardsTabRewardSMSPage.zoomPage();
        customizationRewardsTabRewardSMSPage.setRewardsSmsMessage(randomText);
        waitElementToPresent(saveButton, appear, Duration.ofSeconds(2));
        customizationRewardsTabRewardSMSPage.clickSaveButton();
        customizationRewardsTabRewardSMSPage.resetZoom();
        String currentRewardsSmsText = customizationRewardsTabRewardSMSPage.setRewardsSmsMessage(randomText);
        String getCurrentRewardsSmsText = customizationRewardsTabRewardSMSPage.getCurrentRewardSmsMessage();
        AssertionsForClassTypes.assertThat(currentRewardsSmsText).isEqualTo(getCurrentRewardsSmsText);


    }

}
