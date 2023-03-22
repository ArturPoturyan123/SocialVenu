package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.BasePage;

public class CompanyProfilePage extends BasePage<CompanyProfilePage> {
    private SelenideElement companyName = Selenide.element("[name='name']");
    private SelenideElement filedCompanyName = Selenide.element("div>input[name='name']");


    public void setRandomCompanyName(String randomText) {
        String valueString = "Test Art Automation=" + randomText;
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(valueString);
    }


    @Override
    public String getUrl() {
        return "accounts/company";
    }
}
