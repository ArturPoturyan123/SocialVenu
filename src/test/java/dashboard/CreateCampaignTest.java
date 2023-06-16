package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.CampaignsMainPage;
import pages.dashboard.CreateCampaignPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static pages.BasePage.*;

public class CreateCampaignTest extends DashboardTestBase {


    @Epic("Regression Tests")
    @Test(testName = "Verify the functionality of the shows Top Bar on the Create Campaign page ")
    public void verifyFunctionalityOfTheAppearTopBarInTheCreateCampaignFlow() {
        CampaignsMainPage campaignsMainPage = new CampaignsMainPage();
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        campaignsMainPage.open();
        campaignsMainPage.clickCreateNewCampaignButton();
        Assert.assertTrue(isElementDisplayed(createCampaignPage.goBackButton),
                "Error: go back button is not present");
        Assert.assertTrue(isElementDisplayed(createCampaignPage.createACampaignTitle),
                "Error: Title is not present ");
        Assert.assertTrue(isElementDisplayed(createCampaignPage.saveCreateButton),
                "Error: save & create button is not present ");
    }

    @Test(testName = "Verify the functionality of return to campaign list ")
    public void verifyFunctionalityOfReturnToCampaignListWithoutChange() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        CampaignsMainPage campaignsMainPage = new CampaignsMainPage();
        createCampaignPage.open();
        WaitHelper.waitElementToPresent(createCampaignPage.createACampaignTitle,
                visible, Duration.ofSeconds(5));
        createCampaignPage.clickGoBackButton();
        Assert.assertTrue(isElementDisplayed(campaignsMainPage.createNewCampaign),
                "Error: Campaigns page is not present ");
    }

    @Test(testName = "Verify the functionality of show Unsaved changes modal ")
    public void verifyFunctionalityOfShowUnsavedChangesModal() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        CampaignsMainPage campaignsMainPage = new CampaignsMainPage();
        campaignsMainPage.open();
        WaitHelper.waitElementToPresent(campaignsMainPage.createNewCampaign, visible,
                Duration.ofSeconds(5));
        campaignsMainPage.clickCreateNewCampaignButton();
        clickBrowserBackButton();
        Assert.assertTrue(isElementDisplayed(createCampaignPage.unsavedChangesModal),
                "Error: the modal is not appear");
    }


    @Test(testName = "Verify the functionality of creating new default campaign ")
    public void verifyFunctionalityOfCreatingNewDefaultCampaign() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        createCampaignPage.open();
        createCampaignPage.openAllIncentiveCampaignSteps();
        createCampaignPage.clickCreateCampaignStep4();
        createCampaignPage.clickSelectButton();
        createCampaignPage.clickPhoneNumber();
        createCampaignPage.setRewardPhoneNumber();
        createCampaignPage.clickSaveAndCreateButton();
        WaitHelper.waitElementToPresent(createCampaignPage.editSmsInvitationButton, appear, Duration.ofSeconds(5));
        Assert.assertTrue(isElementDisplayed(createCampaignPage.editSmsInvitationButton),
                "Error: the campaign is not created by default");
    }


    @Test(testName = "Verify the functionality of step 4 is not displayed after selecting awareness type ")
    public void verifyFunctionalityOfStep4NotDisplayedAfterSelectingAwarenessType() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        createCampaignPage.open();
        createCampaignPage.clickAwarenessCampaignType();
        Assert.assertFalse(isElementDisplayed(createCampaignPage.campaignSte4),
                "Error: In the Create Campaign step 4 still shows in awareness type ");

    }

    @Test(testName = "Verify the functionality of step 4 displayed after selecting incentive type ")
    public void verifyFunctionalityOfStep4DisplayedAfterSelectingIncentiveType() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        createCampaignPage.open();
        scrollToElement(createCampaignPage.campaignSte4);
        WaitHelper.waitElementToPresent(createCampaignPage.campaignSte4, appear, Duration.ofSeconds(2));
        Assert.assertTrue(isElementDisplayed(createCampaignPage.campaignSte4),
                "Error: In the Create Campaign step 4 is not shows in incentive type ");
    }
}
