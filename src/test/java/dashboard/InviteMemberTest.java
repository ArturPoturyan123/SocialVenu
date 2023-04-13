package dashboard;

import base.DashboardTestBase;
import com.github.javafaker.Faker;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.InviteMemberPage;
import pages.dashboard.MemberManagementPage;


import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.dashboard.MemberManagementPage.editButton;

@Epic("Regression Tests")

public class InviteMemberTest extends DashboardTestBase {

    @Test(testName = "Verify the functionality of invite team member added without any issues")

    public void verifyFunctionalityOFInvitationMember() {
        Faker faker = new Faker();
        MemberManagementPage memberManagementPage = new MemberManagementPage();
        memberManagementPage.open();
        WaitHelper.waitElementToPresent(editButton, appear, Duration.ofSeconds(2));
        int rowSize = memberManagementPage.getRowCount();
        new InviteMemberPage().open()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmailField(faker.internet().emailAddress())
                .setPhone(faker.phoneNumber().cellPhone())
                .clickEmptyArea()
                .clickInviteButton();
        WaitHelper.waitElementToPresent(editButton, appear, Duration.ofSeconds(2));
        assertThat(memberManagementPage.getRowCount()).isEqualTo(rowSize + 1);

    }
}
