package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabPointsActivitiesPage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.saveButton;


@Epic("Regression Tests")

public class CustomizationRewardsTabPointsActivitiesTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of all toggles enable and disabled functionality")
    public void verifyFunctionalityAllRewardsTogglesEnableAndDisable() throws InterruptedException {
        CustomizationRewardsTabPointsActivitiesPage customizationRewardsPage =
                new CustomizationRewardsTabPointsActivitiesPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        WaitHelper.waitElementToPresent(saveButton, appear, Duration.ofSeconds(2));
        customizationRewardsPage.clickSaveButton();
        customizationRewardsPage.resetZoom();
        Thread.sleep(3000);
        int togglesSize = customizationRewardsPage.getAllToggles();
        int activitiesSize = customizationRewardsPage.getActivitiesCount();
        assertThat(togglesSize).isEqualTo(activitiesSize + 1);
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        WaitHelper.waitElementToPresent(saveButton, appear, Duration.ofSeconds(2));
        customizationRewardsPage.clickSaveButton();
        customizationRewardsPage.resetZoom();
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
