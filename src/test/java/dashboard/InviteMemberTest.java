package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.InviteUserPage;
import pages.dashboard.MemberManagementPage;
import pages.dashboard.MemberProfilePage;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("Regression Tests")

public class InviteMemberTest extends DashboardTestBase {

    @Test(testName = "Verify invite team member added without any issues")

    public void verifyInvitationFunctionality() throws InterruptedException {
        Faker faker = new Faker();
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        memberManagementPage.open();
        Thread.sleep(3000);
        int rowSize = memberManagementPage.getRowCount();
        new InviteUserPage().open()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPhone(faker.phoneNumber().cellPhone())
                .clickEmptyArea() //bug should be fixed https://socialvenu.atlassian.net/browse/SV-166
                .clickInviteButton();
        Thread.sleep(3000);
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize + 1);

    }

    @Test(testName = "Verify to delete Member from Member Management list")
    public void verifyDeleteMemberFunctionality() throws InterruptedException {
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
        memberManagementPage.open();
        Thread.sleep(5000);
        int rowSize = memberManagementPage.getRowCount();
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        memberProfilePage.deleteUserPopup.shouldBe(Condition.visible);
        memberProfilePage.deleteMember();
        Thread.sleep(3000);
        memberManagementPage.refreshPage();
        Thread.sleep(4000);
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize - 1);

    }
}
