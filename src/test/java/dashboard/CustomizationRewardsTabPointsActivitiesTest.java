package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsTabPointsActivitiesPage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.*;


@Epic("Regression Tests")

public class CustomizationRewardsTabPointsActivitiesTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of all toggles enable and disabled functionality")
    public void verifyFunctionalityAllRewardsTogglesEnableAndDisable() throws InterruptedException {
        CustomizationRewardsTabPointsActivitiesPage customizationRewardsPage =
                new CustomizationRewardsTabPointsActivitiesPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickSaveButton();
        customizationRewardsPage.resetZoom();
        int initialTogglesCount = customizationRewardsPage.getAllToggles();
        int activitiesCount = customizationRewardsPage.getActivitiesCount();
        assertThat(initialTogglesCount).isEqualTo(activitiesCount + 1);
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.zoomPage();
        customizationRewardsPage.clickSaveButton();
        Thread.sleep(3000);
        customizationRewardsPage.resetZoom();
        assertThat(initialTogglesCount).isNotEqualTo(activitiesCount);
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

    @Test(testName = "Verify the functionality of the 'Reward Your Customer' modal appear on Points/Activities section")
    public void verifyFunctionalityRewardYourCustomerModalAppear() {
        CustomizationRewardsTabPointsActivitiesPage customizationRewardsTabPointsActivitiesPage =
                new CustomizationRewardsTabPointsActivitiesPage();
        customizationRewardsTabPointsActivitiesPage.open();
        clickHelpButton(helpButton);
        WaitHelper.waitElementToPresent(rewardYourCustomerModal, appear, Duration.ofSeconds(3));
        MatcherAssert.assertThat("Reward your Customer Text in not present ",
                isElementDisplayed(rewardYourCustomerModal));
    }
}
