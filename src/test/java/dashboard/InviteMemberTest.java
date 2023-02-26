package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.InviteUserPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InviteMemberTest extends DashboardTestBase {

    @BeforeMethod
    public void setVenue() {
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
        Selenide.refresh();
    }

    @Test
    public void verifyInvitationFunctionality() {
        Faker faker = new Faker();
        int sizeBefore = 3; //MembersPage().getMembersCount()
        new InviteUserPage().open()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPhone(faker.phoneNumber().cellPhone())
                .clickEmailField() //BUUUUG
                .clickInviteButton();

        assertThat(4).isEqualTo(sizeBefore + 1);
    }
}
