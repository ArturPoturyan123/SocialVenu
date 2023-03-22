package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.Random;

public class CompanyProfilePage extends BasePage<CompanyProfilePage> {
    private final SelenideElement companyName = Selenide.element("[name='name']");
    private final SelenideElement addressName = Selenide.element("[name='address']");
    public SelenideElement saveButton = Selenide.$(By.id("bottom-bar-save-action"));
    public final SelenideElement cityName = Selenide.element("[name='city']");


    public String setRandomCompanyName(String randomText) {
        eraseAllTextField(companyName);
        String valueString = "Test Automation Company Name " + randomText;
        companyName.sendKeys(valueString);
        return valueString;
    }

    public String setRandomCityName() {
        eraseAllTextField(cityName);

        String[] cityNames = {"New York", "Los Angeles", "Chicago", "Houston", "Philadelphia"};
        int randomIndex = new Random().nextInt(cityNames.length);
        String randomCityName = cityNames[randomIndex];
        cityName.setValue(randomCityName);
        return randomCityName;
    }

    public String setRandomCompanyAddress(String randomText) {
        eraseAllTextField(addressName);
        String valueString = "Test Automation Company Address " + randomText;
        addressName.sendKeys(valueString);
        return valueString;
    }

    public String getCurrentCompanyName() {
        return companyName.getValue();
    }

    public String getCurrentCompanyAddress() {
        return addressName.getValue();
    }

    public String getCurrentCityName() {
        return cityName.getValue();
    }


    @Override
    public String getUrl() {
        return "accounts/company";
    }
}
