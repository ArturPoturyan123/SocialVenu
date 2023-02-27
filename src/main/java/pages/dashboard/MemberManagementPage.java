package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.List;

public class MemberManagementPage extends BasePage<MemberManagementPage> {

    private List<SelenideElement> tableRows = Selenide.elements("tbody[class*='MuiTableBody-root'] > tr");
    public SelenideElement inviteTeamMember = Selenide.element("button[class*='MuiButton-textPrimary']");


    public int getRowCount() {

        return tableRows.size();
    }

    @Override
    public String getUrl() {
        return "accounts/members";
    }
}
