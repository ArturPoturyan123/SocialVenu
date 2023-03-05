package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.InviteUserPage;
import pages.dashboard.MemberManagementPage;
import pages.dashboard.MemberProfilePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InviteMemberTest extends DashboardTestBase {

    @BeforeMethod
    public void setVenue() {
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
        Selenide.refresh();
    }

    @Test(testName = "Verify invite team member added without any issues")
    public void verifyInvitationFunctionality() throws InterruptedException {
        Faker faker = new Faker();
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
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
        memberManagementPage.inviteTeamMember.shouldBe(Condition.visible);
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize + 1);
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        memberProfilePage.deleteMember();


    }

    @Test(testName = "Verify to delete Member from Member Management list")
    public void verifyDeleteMember() throws InterruptedException {
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        MemberProfilePage memberProfilePage = new MemberProfilePage();
        memberManagementPage.open();
        Thread.sleep(3000);
        int rowSize = memberManagementPage.getRowCount();
        memberManagementPage.clickEditButton();
        memberProfilePage.clickOnRevokeInviteButton();
        memberProfilePage.deleteUserPopup.shouldBe(Condition.visible);
        memberProfilePage.deleteMember();
        Thread.sleep(3000);
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize - 1);

    }
}
