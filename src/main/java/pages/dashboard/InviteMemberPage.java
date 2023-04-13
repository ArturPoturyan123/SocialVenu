package pages.dashboard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.element;

public class InviteMemberPage extends BasePage<InviteMemberPage> {

    private final SelenideElement nameField = element(By.id("name"));
    private final SelenideElement lastNameField = element(By.id("lastName"));
    private final SelenideElement emailField = element(By.id("email"));
    private final SelenideElement phoneNumberField = element(By.id("phone"));

    private final SelenideElement inviteButton = element("[class*='MuiButton-containedPrimary']");

    private final SelenideElement backButton = element("[class*='MuiButton-outlined']");
    private final SelenideElement emptyArea = element("[class*='MuiGrid-spacing-xs-undefined']");


    @Override
    public String getUrl() {
        return "members/invite";
    }


    public InviteMemberPage setFirstName(String name) {
        this.nameField.setValue(name);
        return this;
    }

    public InviteMemberPage setLastName(String name) {
        this.lastNameField.setValue(name);
        return this;
    }

    public InviteMemberPage setEmailField(String emailField) {
        this.emailField.setValue(emailField);
        return this;
    }

    public InviteMemberPage setPhone(String phone) {
        this.phoneNumberField.setValue(phone);
        return this;
    }

    public void clickInviteButton() {
        inviteButton.shouldBe().click();
    }

    public InviteMemberPage clickEmptyArea() {
        emptyArea.click();
        return this;
    }

}
