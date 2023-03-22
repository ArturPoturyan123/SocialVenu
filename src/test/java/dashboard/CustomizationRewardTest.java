package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsPage;
import utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("Regression Tests")

public class CustomizationRewardTest extends DashboardTestBase {


    @Test(testName = "Verify to all toggles enable and disabled functionality")
    public void verifyAllRewardsTogglesEnableAndDisable() throws InterruptedException {
        CustomizationRewardsPage customizationRewardsPage = new CustomizationRewardsPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton(customizationRewardsPage.saveButton);
        customizationRewardsPage.resetZoom();
        Thread.sleep(5000);
        int activitiesSize = customizationRewardsPage.getActivitiesCount();
        int togglesSize = customizationRewardsPage.getAllToggles();
        assertThat(togglesSize).isEqualTo(activitiesSize + 1);
        Thread.sleep(2000);
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton(customizationRewardsPage.saveButton);
        customizationRewardsPage.resetZoom();
        Thread.sleep(3000);
        assertThat(togglesSize).isNotEqualTo(activitiesSize);
    }

    @Test(testName = "Verify set your Rewards Points Goal")
    public void verifySetRewardsPointsGoal() {
        CustomizationRewardsPage customizationRewardsPage = new CustomizationRewardsPage();
        customizationRewardsPage.open();
        int randomNumber = RandomUtils.getInt();
        customizationRewardsPage.setRandomRewardPointGoal(randomNumber);
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickOnSaveButton(customizationRewardsPage.saveButton);
        customizationRewardsPage.resetZoom();
        assertThat(randomNumber).isEqualTo(customizationRewardsPage.getPhonePoints());


    }
}
