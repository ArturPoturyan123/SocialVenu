package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import helper.WaitHelper;
import org.testng.annotations.Test;
import pages.dashboard.MemberManagementPage;
import pages.dashboard.MemberProfilePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.dashboard.MemberManagementPage.editButton;
import static pages.dashboard.MemberProfilePage.deleteUserPopup;

public class MemberProfileTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of delete Member from Member Management list")
    public void verifyFunctionalityDeleteMember() {
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
        memberManagementPage.open();
        WaitHelper.waitElementToPresent(editButton, appear, Duration.ofSeconds(2));
        int rowSize = memberManagementPage.getRowCount();
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        WaitHelper.waitElementToPresent(deleteUserPopup, appear, Duration.ofSeconds(2));
        memberProfilePage.deleteMember();
        ToastHelper.waitForToastToAppear();
        ToastHelper.waitForToastToDisappear();
        memberManagementPage.refreshPage();
        WaitHelper.waitElementToPresent(editButton, appear, Duration.ofSeconds(2));
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize - 1);

    }
}
