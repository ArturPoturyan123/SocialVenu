package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Interactable;
import pages.BasePage;

import java.util.List;

public class CustomizationRewardsPage extends BasePage<CustomizationRewardsPage> {

    private final List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    private final SelenideElement createVideoToggle = Selenide.element("span>input[name='undefinedToggle']", 0);
    private final SelenideElement sharesToggle = Selenide.element("span>input[name='undefinedToggle']", 1);
    private final SelenideElement clicksToggle = Selenide.element("span>input[name='undefinedToggle']", 2);

    private final SelenideElement transactionsToggle = Selenide.element("span>input[name='undefinedToggle']", 3);
    private final SelenideElement bonusPointsToggle = Selenide.element("span>input[name='undefinedToggle']", 4);
    private final SelenideElement saveButton = Selenide.element("div>button[class*='MuiButton-contained']");


    public int getAllToggles() {
        return pointsToggle.size();
    }

    public void clickOnSaveButton() {
        saveButton.shouldBe(Interactable.visible).click();


    }

    public void clickAllToggles() {
        createVideoToggle.click(ClickOptions.usingJavaScript());
        sharesToggle.click(ClickOptions.usingJavaScript());
        clicksToggle.click(ClickOptions.usingJavaScript());
        transactionsToggle.click(ClickOptions.usingJavaScript());
        bonusPointsToggle.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return "settings/incentive/points";
    }

    @Override
    public void refreshPage() {

    }
}
