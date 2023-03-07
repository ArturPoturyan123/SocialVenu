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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CustomizationRewardsPage extends BasePage<CustomizationRewardsPage> {

    private final List<SelenideElement> pointsToggle = Selenide.elements("div>[class*='MuiFormGroup-root']");
    private final SelenideElement toggle = element("span>input[name='undefinedToggle']");
    private SelenideElement saveButton = Selenide.elements("button[type='button']").get(3);
    private SelenideElement chat = Selenide.element("a[aria-label='Open chat']");

    public void openBot() {
        chat.shouldBe(Condition.visible).click();
    }


    public void clickOnSaveButton() {
        if (saveButton.exists()) {
            saveButton.click(ClickOptions.usingJavaScript());
        } else {
            System.out.println("error");
        }
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
