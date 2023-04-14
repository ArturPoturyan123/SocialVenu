package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class CustomizationRewardsTabPointsActivitiesPage extends BasePage<CustomizationRewardsTabPointsActivitiesPage> {

    private final List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    public List<SelenideElement> activities = Selenide.elements("div>[style*='display']");
    private SelenideElement toggles = Selenide.element("span>input[name='undefinedToggle']");

    private final SelenideElement pointsGoalInput = Selenide.element("[name='points']");
    private final SelenideElement phonePoint = Selenide.element("span+div[class*='sv-dashboard']>p:last-child");


    public void setRandomRewardPointGoal(int randomNumber) {
        String valueString = "value=" + randomNumber;
        pointsGoalInput.sendKeys(valueString);
    }

    public int getPhonePoints() {
        return Integer.parseInt(phonePoint.text().split("/")[1].trim());
    }


    public int getActivitiesCount() throws InterruptedException {
        Thread.sleep(3000);
        return activities.size();
    }

    private SelenideElement getToggleByIndex(int toggleIndex) {
        return element("span>input[name='undefinedToggle']", toggleIndex);
    }


    public int getAllToggles() throws InterruptedException {
        Thread.sleep(3000);
        return pointsToggle.size();
    }

    public void clickAllToggles() throws InterruptedException {
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
