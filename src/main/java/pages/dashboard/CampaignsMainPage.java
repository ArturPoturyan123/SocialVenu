package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

public class CampaignsMainPage extends BasePage<CampaignsMainPage> {
    public SelenideElement createNewCampaign = Selenide.element(By.id("create-new-campaign-button"));


    public void clickCreateNewCampaignButton() {
        clickHelpButton(createNewCampaign);
    }

    @Override
    public String getUrl() {
        return "reward-campaigns";
    }
}
