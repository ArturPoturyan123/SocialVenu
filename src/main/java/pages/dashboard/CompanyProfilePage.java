package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.Countries;
import utils.RandomUtils;

import java.util.Random;

public class CompanyProfilePage extends BasePage<CompanyProfilePage> {
    private final SelenideElement companyName = Selenide.element("[name='name']");
    private final SelenideElement addressName = Selenide.element("[name='address']");
    public final SelenideElement cityName = Selenide.element("[name='city']");
    public final SelenideElement webSite = Selenide.element("[name='website']");
    public final SelenideElement zipCode = Selenide.element("[name='zip']");


    public String setRandomCompanyName(String randomText) throws InterruptedException {
        eraseAllTextField(companyName);
        String valueString = "Test Automation Company Name " + randomText;
        companyName.sendKeys(valueString);
        return valueString;
    }


    public String setRandomCityName() throws InterruptedException {
        eraseAllTextField(cityName);
        String[] cityNames = {"New York", "Los Angeles", "Chicago", "Houston", "Philadelphia"};
        String randomCityName = cityNames[RandomUtils.getInt(cityNames.length)];
        cityName.sendKeys(randomCityName);
        return randomCityName;
    }

    public String setRandomCompanyWebsite() throws InterruptedException {
        eraseAllTextField(webSite);
        Thread.sleep(3000);
        String[] companyWebsites = {"youtube.com", "sv.com", "nike.com", "adidas.com", "fresh.com"};
        String randomWebsite = "https://" + companyWebsites[RandomUtils.getInt(companyWebsites.length)];
        webSite.sendKeys(randomWebsite);
        return randomWebsite;
    }


    public String setRandomCompanyAddress(String randomText) throws InterruptedException {
        eraseAllTextField(addressName);
        String valueString = "Test Automation Company Address " + randomText;
        addressName.sendKeys(valueString);
        return valueString;
    }


    public String setRandomZipCode() throws InterruptedException {
        eraseAllTextField(zipCode);
        String randomZipCode = String.valueOf(10000 + new Random().nextInt(90000));
        zipCode.setValue(randomZipCode);
        return randomZipCode;
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

    public String getCurrentWebSiteUrl() {
        return "https://" + webSite.getValue();
    }

    public String getCurrentZipCode() {
        return zipCode.getValue();
    }


    @Override
    public String getUrl() {
        return "accounts/company";
    }
}
