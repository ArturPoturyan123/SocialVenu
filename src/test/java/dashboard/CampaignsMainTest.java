package dashboard;

import base.DashboardTestBase;
import pages.dashboard.CampaignsMainPage;
import org.testng.annotations.Test;


public class CampaignsMainTest extends DashboardTestBase {




    @Test
    public void test (){
        CampaignsMainPage campaignsPage = new CampaignsMainPage();
        campaignsPage.open();
        campaignsPage.clickCreateNewCampaignButton();
    }
}
