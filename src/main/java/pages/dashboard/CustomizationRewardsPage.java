package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CustomizationRewardsPage extends BasePage<CustomizationRewardsPage> {

    private List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    private SelenideElement toggle = Selenide.element("span>input[name='undefinedToggle']");
    public SelenideElement saveButton = $(new By.ByCssSelector("button[type='button']"));
    private SelenideElement chat = Selenide.element("a[aria-label='Open chat']");
    private SelenideElement rewardsSms = Selenide.$x("//div[contains (text(), 'Reward SMS')]");
    private SelenideElement rewardFulFillMeant = Selenide.$x("//div[contains (text(), 'Reward Fulfillment')]");

    public void openBot() {
        chat.shouldBe(visible).click();
    }


    public void clickRewardFulFillMeant() {
        rewardFulFillMeant.click(ClickOptions.usingJavaScript());
    }

    public void clickRewardsSms() {
        rewardsSms.click(ClickOptions.usingJavaScript());
    }


    public void clickOnSaveButton() {
        saveButton.click(ClickOptions.usingJavaScript());


    }


    private SelenideElement getToggleByIndex(int toggleIndex) {
        return element("span>input[name='undefinedToggle']", toggleIndex);
    }

    private SelenideElement getActionButtonIndex(int actionButtonIndex) {
        return element("div>button[class*='MuiButton-containedPrimary']", actionButtonIndex);
    }

    public int getAllToggles() {
        return pointsToggle.size();
    }

    public void clickAllToggles() {
        int toggleCount = getAllToggles();
        for (int i = 0; i < toggleCount; i++) {
            SelenideElement toggle = getToggleByIndex(i);
            if (toggle != null) {
                toggle.click(ClickOptions.usingJavaScript());
            } else {
                throw new NoSuchElementException("Toggle element not found for index " + i);
            }
        }
    }

    @Override
    public String getUrl() {
        return "settings/incentive/points";
    }

    @Override
    public void refreshPage() {
        Selenide.refresh();

    }
}
