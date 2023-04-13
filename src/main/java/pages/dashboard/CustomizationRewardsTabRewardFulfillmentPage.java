package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import pages.BasePage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.empty;

public class CustomizationRewardsTabRewardFulfillmentPage extends
        BasePage<CustomizationRewardsTabRewardFulfillmentPage> {


    private final SelenideElement manualSMSButton = Selenide.$x("//p[contains(text(),'Manual SMS')]");
    private final SelenideElement automaticSMSButton = Selenide.$x("//p[contains(text(),'Automatic SMS')]");
    private final SelenideElement webHookButton = Selenide.$x("//p[contains(text(),'Webhook')]");
    public SelenideElement incentiveWebHook = Selenide.$x("//p[contains(text(),'How to setup incentive webhook')]");
    private final SelenideElement webHookUrlInput = Selenide.element("input[name='webhookUrl']");
    public SelenideElement posterManualSMS = Selenide.element("div>img[alt='reward-fulfillment-poster-manual-sms']");
    public SelenideElement posterAutomaticSMS = Selenide.element("div>img[alt='reward-fulfillment-poster-automatic-sms']");


    public void clickManualSMSButton() {
        manualSMSButton.click(ClickOptions.usingJavaScript());

    }

    public String setWebHookUrl() {
        eraseAllTextField(webHookUrlInput);
        WaitHelper.waitTextFiledShouldBeEmpty(webHookUrlInput, empty, Duration.ofSeconds(2));
        String[] companyWebsites = {"youtube.com", "sv.com", "nike.com", "adidas.com", "fresh.com"};
        String randomWebsite = "https://" + companyWebsites[RandomUtils.getInt(companyWebsites.length)];
        webHookUrlInput.sendKeys(randomWebsite);
        return randomWebsite;

    }

    public String getCurrentWebHookUrl() {
        return "https://" + webHookUrlInput.getValue();
    }

    public void clickAutomaticSMSButton() {
        automaticSMSButton.click(ClickOptions.usingJavaScript());


    }

    public void clickWebHookButton() {
        webHookButton.click(ClickOptions.usingJavaScript());


    }


    @Override
    public String getUrl() {
        return "settings/incentive/reward-fulfillment";
    }
}
