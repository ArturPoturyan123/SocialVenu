package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabPointsActivitiesPage;
import utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("Regression Tests")

public class CustomizationRewardsTabPointsActivitiesTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of all toggles enable and disabled functionality")
    public void verifyFunctionalityAllRewardsTogglesEnableAndDisable() {
        CustomizationRewardsTabPointsActivitiesPage customizationRewardsPage =
                new CustomizationRewardsTabPointsActivitiesPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickSaveButton();
        ToastHelper.waitForToastToAppear();
        customizationRewardsPage.resetZoom();
        ToastHelper.waitForToastToDisappear();
        int activitiesSize = customizationRewardsPage.getActivitiesCount();
        int togglesSize = customizationRewardsPage.getAllToggles();
        assertThat(togglesSize).isEqualTo(activitiesSize + 1);
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickSaveButton();
        ToastHelper.waitForToastToAppear();
        customizationRewardsPage.resetZoom();
        ToastHelper.waitForToastToDisappear();
        assertThat(togglesSize).isNotEqualTo(activitiesSize);
    }

    @Test(testName = "Verify the functionality of set your Rewards Points Goal")
    public void verifyFunctionalitySetRewardsPointsGoal() {
        CustomizationRewardsTabPointsActivitiesPage customizationRewardsPage =
                new CustomizationRewardsTabPointsActivitiesPage();
        customizationRewardsPage.open();
        int randomNumber = RandomUtils.getInt();
        customizationRewardsPage.setRandomRewardPointGoal(randomNumber);
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickSaveButton();
        customizationRewardsPage.resetZoom();
        assertThat(randomNumber).isEqualTo(customizationRewardsPage.getPhonePoints());


    }
}
