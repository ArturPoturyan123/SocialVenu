package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.AccountPage;
import pages.dashboard.InviteUserPage;
import pages.dashboard.MemberManagementPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InviteMemberTest extends DashboardTestBase {

    @BeforeMethod
    public void setVenue() {
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
        Selenide.refresh();
    }

    @Test (testName = "Verify invite team member added without any issues")
    public void verifyInvitationFunctionality() {
        Faker faker = new Faker();
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        memberManagementPage.open();
        memberManagementPage.inviteTeamMember.shouldBe(Condition.visible);
        int rowSize = memberManagementPage.getRowCount();
        new InviteUserPage().open()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPhone(faker.phoneNumber().cellPhone())
                .clickEmptyArea() //bug should be fix
                .clickInviteButton();
        memberManagementPage.inviteTeamMember.shouldBe(Condition.visible);
        assertThat(rowSize + 1).isEqualTo(memberManagementPage.getRowCount());
    }
}
