package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class VideoAppTabBrandingStylePage extends BasePage<VideoAppTabBrandingStylePage> {

    public static SelenideElement uploadImage = Selenide.$x("//div//p[contains(text(),'Upload Media')]");


    @Override
    public String getUrl() {
        return "webapp/branding-style";
    }
}
