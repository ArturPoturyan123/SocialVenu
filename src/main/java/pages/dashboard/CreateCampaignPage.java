package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import org.openqa.selenium.By;
import pages.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static utils.RandomUtils.generateRandomNumber;

public class CreateCampaignPage extends BasePage<CreateCampaignPage> {

    public SelenideElement goBackButton = Selenide.element(By.id("go-back-button"));
    public SelenideElement createACampaignTitle = Selenide.$x("//div//p[contains(text()," + "'Create a Campaign')]");
    public SelenideElement unsavedChangesModal = Selenide.$x("//div//p[contains(text()," + "'Unsaved Changes')]");
    public SelenideElement editSmsInvitationButton = Selenide.element(By.id("edit-sms-invitation-button"));
    public SelenideElement campaignNameInput = Selenide.element(By.id("campaign-name-input"));

    public SelenideElement saveCreateButton = Selenide.element(By.id("save-and-create-button"));
    public SelenideElement createCampaignStep2 = Selenide.element(By.id("create_campaign_step_2"));
    public SelenideElement createCampaignStep3 = Selenide.element(By.id("create_campaign_step_3"));
    public SelenideElement createCampaignStep4 = Selenide.element(By.id("create_campaign_step_4"));
    public SelenideElement createCampaignStep5 = Selenide.element(By.id("create_campaign_step_5"));
    public SelenideElement createCampaignStep6 = Selenide.element(By.id("create_campaign_step_6"));
    public SelenideElement saveAndCreateButton = Selenide.element(By.id("save-and-create-button"));
    public SelenideElement rewardPhoneNumberInput = Selenide.element(By.id("reward-phone-number-input"));
    public SelenideElement contactMethodSelectButton = Selenide.$x("//div[contains(text(),'Select...')]");
    public SelenideElement phoneNumber = Selenide.$x("//div[contains(text(),'Phone Number')]");
    public SelenideElement incentiveCampaignType = Selenide.element(By.id("campaign-type-change-button-Incentive-Campaign"));
    public SelenideElement awarenessCampaignType = Selenide.element(By.id("campaign-type-change-button-Awareness-Campaign"));
    public SelenideElement campaignSte4 = Selenide.$x("//p[contains(text(),'How would you like to reward creators?')]");
    private final List<SelenideElement> createCampaignSteps = new ArrayList<>();


    public void clickIncentiveCampaignType() {
        WaitHelper.waitElementToPresent(incentiveCampaignType, appear, Duration.ofSeconds(2));
        incentiveCampaignType.click(ClickOptions.usingJavaScript());
    }

    public void clickAwarenessCampaignType() {
        WaitHelper.waitElementToPresent(awarenessCampaignType, appear, Duration.ofSeconds(2));
        awarenessCampaignType.click(ClickOptions.usingJavaScript());
    }

    public void clickSaveAndCreateButton() {
        WaitHelper.waitElementToPresent(saveAndCreateButton, enabled, Duration.ofSeconds(3));
        saveAndCreateButton.click(ClickOptions.usingJavaScript());
    }

    public void setCampaignName(String randomText) {
        eraseAllTextField(campaignNameInput);
        WaitHelper.waitTextFiledShouldBeEmpty(campaignNameInput, empty, Duration.ofSeconds(2));
        String valueString = "Test campaign " + randomText;
        campaignNameInput.sendKeys(valueString);
    }

    public String getCampaignName() {
        return campaignNameInput.getValue();
    }


    public void setRewardPhoneNumber() {
        eraseAllTextField(rewardPhoneNumberInput);
        WaitHelper.waitTextFiledShouldBeEmpty(rewardPhoneNumberInput, empty, Duration.ofSeconds(2));
        String valueString = String.valueOf(generateRandomNumber());
        rewardPhoneNumberInput.sendKeys(valueString);
    }


    public void clickSelectButton() {
        WaitHelper.waitElementToPresent(contactMethodSelectButton, appear, Duration.ofSeconds(2));
        contactMethodSelectButton.click(ClickOptions.usingJavaScript());
    }

    public void clickPhoneNumber() {
        WaitHelper.waitElementToPresent(phoneNumber, appear, Duration.ofSeconds(2));
        phoneNumber.click(ClickOptions.usingJavaScript());
    }

    public CreateCampaignPage() {
        createCampaignSteps.add(Selenide.element(By.id("create_campaign_step_2")));
        createCampaignSteps.add(Selenide.element(By.id("create_campaign_step_3")));
        createCampaignSteps.add(Selenide.element(By.id("create_campaign_step_4")));
        createCampaignSteps.add(Selenide.element(By.id("create_campaign_step_5")));
        createCampaignSteps.add(Selenide.element(By.id("create_campaign_step_6")));
    }

    public void openAllIncentiveCampaignSteps() {
        for (SelenideElement createCampaignStep : createCampaignSteps) {
            WaitHelper.waitElementToPresent(createCampaignStep, appear, Duration.ofSeconds(2));
            createCampaignStep.click(ClickOptions.usingJavaScript());
        }
    }

    public void clickGoBackButton() {
        goBackButton.click(ClickOptions.usingJavaScript());
    }

    public void clickCreateCampaignStep2() {
        WaitHelper.waitElementToPresent(createCampaignStep2, appear, Duration.ofSeconds(2));
        createCampaignStep2.click(ClickOptions.usingJavaScript());

    }

    public void clickCreateCampaignStep3() {
        WaitHelper.waitElementToPresent(createCampaignStep3, appear, Duration.ofSeconds(2));
        createCampaignStep3.click(ClickOptions.usingJavaScript());

    }

    public void clickCreateCampaignStep4() {
        WaitHelper.waitElementToPresent(createCampaignStep4, appear, Duration.ofSeconds(2));
        createCampaignStep4.click(ClickOptions.usingJavaScript());

    }

    public void clickCreateCampaignStep5() {
        WaitHelper.waitElementToPresent(createCampaignStep5, appear, Duration.ofSeconds(2));
        createCampaignStep5.click(ClickOptions.usingJavaScript());

    }

    public void clickCreateCampaignStep6() {
        WaitHelper.waitElementToPresent(createCampaignStep6, appear, Duration.ofSeconds(2));
        createCampaignStep6.click(ClickOptions.usingJavaScript());

    }

    @Override
    public String getUrl() {
        return "new-campaign/campaign-objectives";
    }
}
