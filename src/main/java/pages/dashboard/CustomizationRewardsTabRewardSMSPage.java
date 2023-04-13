package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import java.time.Duration;

public class CustomizationRewardsTabRewardSMSPage extends BasePage<CustomizationRewardsTabRewardSMSPage> {


    private final SelenideElement sendSampleTextButton =
            Selenide.$x("//button[contains(text(),'Send a Sample Text')]");
    public SelenideElement sampleTextPopup =
            Selenide.$x("//div//p[contains(text(),'Send a sample SMS message to…')]");
    private final SelenideElement updateSmsMessageInput = Selenide.element("textarea[autocomplete='none']");


    public String setRewardsSmsMessage(String randomText) {
        String valueString = "Test Art " + randomText;
        updateSmsMessageInput.shouldBe(Condition.appear, Duration.ofSeconds(2));
        eraseAllTextField(updateSmsMessageInput);
        updateSmsMessageInput.sendKeys(valueString);
        return valueString;
    }

    public String getCurrentRewardSmsMessage() {
        return updateSmsMessageInput.getValue();
    }

    public void clickSendSampleButton() {
        sendSampleTextButton.click(ClickOptions.usingJavaScript());
    }


    @Override
    public String getUrl() {
        return "settings/incentive/reward-sms";
    }
}
