package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.element;


public class MemberManagementPage extends BasePage<MemberManagementPage> {

    private List<SelenideElement> tableRows = Selenide.elements("tbody[class*='MuiTableBody-root'] > tr");
    public SelenideElement inviteTeamMember = Selenide.element("button[class*='MuiButton-textPrimary']");
    private SelenideElement toastMessage = Selenide.element("[class*='react-toast-notifications__container']");

    private SelenideElement editButton = Selenide.elements("tr>td>svg[data-testid='EditIcon']").get(0);

    public int getRowCount() {

        return tableRows.size();
    }


    public void clickEditButton() {
        element("tr>td>svg[data-testid='EditIcon']").shouldBe(Condition.visible);
        editButton.click(ClickOptions.usingJavaScript());
        element("tr>td>svg[data-testid='EditIcon']").should(disappear, Duration.ofSeconds(10));

    }


    public void toastMessageAppear() {
        toastMessage.shouldBe(visible);
    }


    @Override
    public String getUrl() {
        return "accounts/members";
    }
}
