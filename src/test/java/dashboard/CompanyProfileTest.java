package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.CompanyProfilePage;
import utils.RandomUtils;

public class CompanyProfileTest extends DashboardTestBase {


    @Test(testName = "profile")
    public void test() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyName(randomText);

    }
}
