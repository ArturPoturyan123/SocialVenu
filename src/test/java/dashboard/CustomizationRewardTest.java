package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomizationRewardTest extends DashboardTestBase {

    @BeforeMethod
    public void setVenue() {
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
        Selenide.refresh();

    }

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
}
