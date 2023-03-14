package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Interactable;
import com.github.javafaker.Code;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CustomizationRewardsPage extends BasePage<CustomizationRewardsPage> {

    private final List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    private final SelenideElement toggle = element("span>input[name='undefinedToggle']");
    private SelenideElement saveButton = $x("//div//button[contains(text(),'Save')]");
    private SelenideElement chat = Selenide.element("a[aria-label='Open chat']");

    public void openBot() {
        chat.shouldBe(visible).click();
    }


    public void clickOnSaveButton() {

        saveButton.shouldBe(Condition.visible).click();
    }

    public int getAllToggles() {
        return pointsToggle.size();
    }

    private SelenideElement getToggleByIndex(int toggleIndex) {
        return element("span>input[name='undefinedToggle']", toggleIndex);
    }

    public void clickAllToggles() {
        for (int i = 0; i < getAllToggles(); i++) {
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

    }


}
