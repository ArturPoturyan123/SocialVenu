package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;


public class MemberManagementPage extends BasePage<MemberManagementPage> {

    private final List<SelenideElement> tableRows = Selenide.elements("tbody[class*='MuiTableBody-root'] > tr");

    private final SelenideElement editButtonIndex = Selenide.elements("tr>td>svg[data-testid='EditIcon']").get(0);
    public static SelenideElement editButton = Selenide.element("tr>td>svg[data-testid='EditIcon']");

    public int getRowCount() {
        return tableRows.size();
    }


    public void clickEditButton() {
        WaitHelper.waitElementToPresent(editButton, appear, Duration.ofSeconds(2));
        editButtonIndex.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return "accounts/members";
    }


}
