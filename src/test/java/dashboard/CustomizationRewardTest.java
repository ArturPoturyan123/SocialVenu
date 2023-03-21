package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomizationRewardTest extends DashboardTestBase {


    @Test(testName = "Verify to all toggles enable and disabled functionality")
    public void verifyAllRewardsTogglesEnableAndDisable() throws InterruptedException {
        CustomizationRewardsPage customizationRewardsPage = new CustomizationRewardsPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton();
        customizationRewardsPage.resetZoom();
        Thread.sleep(5000);
        int activitiesSize = customizationRewardsPage.getActivitiesCount();
        int togglesSize = customizationRewardsPage.getAllToggles();
        assertThat(togglesSize).isEqualTo(activitiesSize + 1);
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton();
        customizationRewardsPage.resetZoom();
        Thread.sleep(3000);
        assertThat(togglesSize).isNotEqualTo(activitiesSize);
    }

    @Test(testName = "Verify set your Rewards Points Goal")
    public void verifySetRewardsPointsGoal() {
        CustomizationRewardsPage customizationRewardsPage = new CustomizationRewardsPage();
        customizationRewardsPage.open();
        customizationRewardsPage.setRandomRewardPointGoal();
        int number = customizationRewardsPage.setRandomRewardPointGoal();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton();
        customizationRewardsPage.resetZoom();
        assertThat(number).isEqualTo(customizationRewardsPage.getPhonePoints());


    }
}
