package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class VideosPage extends BasePage<VideosPage> {
    private final SelenideElement videElement = Selenide.elements("tbody>tr[class*='MuiTableRow-root']").get(0);
    private final SelenideElement videoPlayButton = Selenide.element("div>button>video[class*='MuiCardMedia-root']");
    private final SelenideElement closeVideoPreview = Selenide.element("button[aria-label='Close modal']");


    public void clickPlayButton() {
        videoPlayButton.click(ClickOptions.usingJavaScript());
    }

    public void closeModal() {
        closeVideoPreview.click(ClickOptions.usingJavaScript());
    }


    public void clickElement() {
        videElement.click(ClickOptions.usingJavaScript());
    }


    @Override
    public String getUrl() {
        return "content/all";
    }


}
