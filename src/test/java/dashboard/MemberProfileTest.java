package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.MemberManagementPage;
import pages.dashboard.MemberProfilePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MemberProfileTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of delete Member from Member Management list")
    public void verifyFunctionalityDeleteMember(){
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
        memberManagementPage.open();
        int currentRowSize = memberManagementPage.getRowCount();
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        memberProfilePage.deleteMember();
        int newRowSize = memberManagementPage.getRowCount();
        assertThat(newRowSize).isEqualTo(currentRowSize - 1);
    }
}
