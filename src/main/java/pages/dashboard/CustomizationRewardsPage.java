package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.RandomUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CustomizationRewardsPage extends BasePage<CustomizationRewardsPage> {

    private final List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    private final List<SelenideElement> activities = Selenide.elements("div>[style*='display']");
    private SelenideElement toggles = Selenide.element("span>input[name='undefinedToggle']");
    public SelenideElement saveButton = Selenide.$(By.id("bottom-bar-save-action"));

    private final SelenideElement chat = Selenide.element("a[aria-label='Open chat']");
    private final SelenideElement rewardsSms = Selenide.$x("//div[contains (text(), 'Reward SMS')]");
    private final SelenideElement rewardFulFillMeant = Selenide.$x("//div[contains (text(), 'Reward Fulfillment')]");
    private final SelenideElement pointsGoalInput = Selenide.element("[name='points']");
    private final SelenideElement phonePoint = Selenide.element("span+div[class*='sv-dashboard']>p:last-child");


    public void setRandomRewardPointGoal(int randomNumber) {

        String valueString = "value=" + randomNumber;
        pointsGoalInput.sendKeys(valueString);
    }

    public int getPhonePoints() {
        return Integer.parseInt(phonePoint.text().split("/")[1].trim());
    }


    public void openChatBot() {
        chat.shouldBe(visible).click();
    }

    public int getActivitiesCount() {
        return activities.size();
    }

    public void clickRewardFulFillMeant() {
        rewardFulFillMeant.click(ClickOptions.usingJavaScript());
    }

    public void clickRewardsSms() {
        rewardsSms.click(ClickOptions.usingJavaScript());
    }


    public void clickOnSaveButton() {
        if (!isSaveButtonDisplayed()) {
            throw new NoSuchElementException("Save button not found ");
        } else {
            saveButton.click(ClickOptions.usingJavaScript());
        }
    }


    public boolean isSaveButtonDisplayed() {
        return saveButton.isDisplayed();
    }


    private SelenideElement getToggleByIndex(int toggleIndex) {
        return element("span>input[name='undefinedToggle']", toggleIndex);
    }


    public int getAllToggles() {
        return pointsToggle.size();
    }

    public void clickAllToggles() {
        int toggleCount = getAllToggles();
        for (int i = 0; i < toggleCount; i++) {
            toggles = getToggleByIndex(i);
            toggles.click(ClickOptions.usingJavaScript());
        }
    }

    @Override
    public String getUrl() {
        return "settings/incentive/points";
    }



}
