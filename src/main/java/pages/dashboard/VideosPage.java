package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class VideosPage extends BasePage<AccountPage> {
    private SelenideElement videElement = Selenide.elements("tbody>tr[class*='MuiTableRow-root']").get(0);
        private SelenideElement videoPlayButton = Selenide.element("div>button>video[class*='MuiCardMedia-root']");


    public void clickPlayButton() {
        videoPlayButton.click(ClickOptions.usingJavaScript());
    }


    public void clickElement() {
        videElement.click(ClickOptions.usingJavaScript());
    }


    @Override
    public String getUrl() {
        return "content/all";
    }

    @Override
    public void refreshPage() {

    }

    @Override
    public void zoomPage() {

    }

    @Override
    public void resetZoom() {

    }
}