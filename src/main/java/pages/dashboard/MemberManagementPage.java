package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.List;


public class MemberManagementPage extends BasePage<MemberManagementPage> {

    private List<SelenideElement> tableRows = Selenide.elements("tbody[class*='MuiTableBody-root'] > tr");
    public SelenideElement inviteTeamMember = Selenide.element("button[class*='MuiButton-textPrimary']");
    private SelenideElement toastMessage = Selenide.element("[class*='react-toast-notifications__container']");

    private SelenideElement editButton = Selenide.element("tbody[data-testid='EditIcon']");

    public int getRowCount() {

        return tableRows.size();
    }

    public void clickEditButton() {
        editButton.shouldBe(Condition.visible).click();
    }


    public void toastMessageAppear() {
        toastMessage.shouldBe(Condition.visible);
    }


    @Override
    public String getUrl() {
        return "accounts/members";
    }
}
