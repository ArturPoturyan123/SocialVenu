package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

public class CreateCampaignPage extends BasePage<CreateCampaignPage> {

    public  SelenideElement goBackButton = Selenide.element(By.id("go-back-button"));
    public  SelenideElement createACampaignTitle = Selenide.$x("//div//p[contains(text()," +
            "'Create a Campaign')]");

    public  SelenideElement saveCreateButton = Selenide.element(By.id("save-and-create-button"));


    @Override
    public String getUrl() {
        return "new-campaign/campaign-objectives";
    }
}
