package pages.dashboard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.element;

public class InviteUserPage extends BasePage<InviteUserPage> {

    private SelenideElement name = element(By.id("name"));
    private SelenideElement lastName = element(By.id("lastName"));
    private SelenideElement email = element(By.id("email"));
    private SelenideElement phoneNumber = element(By.id("phone"));

    private SelenideElement inviteButton = element("[class*='MuiButton-containedPrimary']");

    private SelenideElement backButton = element("[class*='MuiButton-outlined']");
    private SelenideElement emptyArea = element("[class*='MuiGrid-spacing-xs-undefined']");


    @Override
    public String getUrl() {
        return "members/invite";
    }

    public InviteUserPage setFirstName(String name) {
        this.name.setValue(name);
        return this;
    }

    public InviteUserPage setLastName(String name) {
        this.lastName.setValue(name);
        return this;
    }

    public InviteUserPage setEmail(String email) {
        this.email.setValue(email);
        return this;
    }

    public InviteUserPage setPhone(String phone) {
        this.phoneNumber.setValue(phone);
        return this;
    }

    public void clickInviteButton() {
        inviteButton.click();
    }

    public InviteUserPage clickEmptyArea() {
        emptyArea.click();
        return this;
    }


}
