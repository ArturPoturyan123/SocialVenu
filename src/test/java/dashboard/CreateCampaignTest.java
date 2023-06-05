package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.CampaignsMainPage;
import pages.dashboard.CreateCampaignPage;

import java.time.Duration;

import static pages.BasePage.isElementDisplayed;

public class CreateCampaignTest extends DashboardTestBase {


    @Epic("Regression Tests")
    @Test(testName = "Verify the functionality of the shows Top Bar on the Create Campaign page")
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
    public void verifyFunctionalityOfReturnToCampaignList() {
        CreateCampaignPage createCampaignPage = new CreateCampaignPage();
        CampaignsMainPage campaignsMainPage = new CampaignsMainPage();
        createCampaignPage.open();
        WaitHelper.waitElementToPresent(createCampaignPage.createACampaignTitle,
                Condition.visible, Duration.ofSeconds(5));
        createCampaignPage.clickGoBackButton();
        Assert.assertTrue(isElementDisplayed(campaignsMainPage.createNewCampaign),
                "Error: Campaigns page is not present ");
    }
}
