package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import utils.RandomUtils;

import java.util.Random;

public class CompanyProfilePage extends BasePage<CompanyProfilePage> {
    private final SelenideElement companyNameField = Selenide.element("[name='name']");
    private final SelenideElement addressNameField = Selenide.element("[name='address']");
    public final SelenideElement cityNameField = Selenide.element("[name='city']");
    public final SelenideElement webSiteField = Selenide.element("[name='website']");
    public final SelenideElement zipCodeField = Selenide.element("[name='zip']");


    public String setRandomCompanyName(String randomText){
        eraseAllTextField(companyNameField);
        String valueString = "Test Automation Company Name " + randomText;
        companyNameField.sendKeys(valueString);
        return valueString;
    }


    public String setRandomCityName() {
        eraseAllTextField(cityNameField);
        String[] cityNames = {"New York", "Los Angeles", "Chicago", "Houston", "Philadelphia"};
        String randomCityName = cityNames[RandomUtils.getInt(cityNames.length)];
        cityNameField.sendKeys(randomCityName);
        return randomCityName;
    }

    public String setRandomCompanyWebsite() throws InterruptedException {
        eraseAllTextField(webSiteField);
        Thread.sleep(3000);
        String[] companyWebsites = {"youtube.com", "sv.com", "nike.com", "adidas.com", "fresh.com"};
        String randomWebsite = "https://" + companyWebsites[RandomUtils.getInt(companyWebsites.length)];
        webSiteField.sendKeys(randomWebsite);
        return randomWebsite;
    }


    public String setRandomCompanyAddress(String randomText){
        eraseAllTextField(addressNameField);
        String valueString = "Test Automation Company Address " + randomText;
        addressNameField.sendKeys(valueString);
        return valueString;
    }


    public String setRandomZipCode() {
        eraseAllTextField(zipCodeField);
        String randomZipCode = String.valueOf(10000 + new Random().nextInt(90000));
        zipCodeField.setValue(randomZipCode);
        return randomZipCode;
    }

    public String getCurrentCompanyName() {
        return companyNameField.getValue();
    }

    public String getCurrentCompanyAddress() {
        return addressNameField.getValue();
    }

    public String getCurrentCityName() {
        return cityNameField.getValue();
    }

    public String getCurrentWebSiteUrl() {
        return "https://" + webSiteField.getValue();
    }

    public String getCurrentZipCode() {
        return zipCodeField.getValue();
    }


    @Override
    public String getUrl() {
        return "accounts/company";
    }
}
