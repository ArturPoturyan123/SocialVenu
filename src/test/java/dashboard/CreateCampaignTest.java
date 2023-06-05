package dashboard;

import base.DashboardTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.CampaignsMainPage;
import pages.dashboard.CreateCampaignPage;

import static pages.BasePage.isElementDisplayed;

public class CreateCampaignTest extends DashboardTestBase {

    @Test
    public void verifyFunctionalityTopBarCreateCampaign() {
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
}
