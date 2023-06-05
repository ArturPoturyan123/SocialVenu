package dashboard;

import base.DashboardTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.MemberManagementPage;
import pages.dashboard.MemberProfilePage;



public class MemberProfileTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of delete Member from Member Management list")
    public void verifyFunctionalityDeleteMember() throws InterruptedException {
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
        memberManagementPage.open();
        Thread.sleep(3000);
        int currentRowSize = memberManagementPage.getRowCount();
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        memberProfilePage.deleteMember();
        Thread.sleep(3000);
        int newRowSize = memberManagementPage.getRowCount();
        Assert.assertEquals(newRowSize,currentRowSize - 1);
    }
}
