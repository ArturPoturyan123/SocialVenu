package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import pages.BasePage;
import utils.RandomUtils;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.empty;

public class CompanyProfilePage extends BasePage<CompanyProfilePage> {
    private final SelenideElement companyNameField = Selenide.element("[name='name']");
    private final SelenideElement addressNameField = Selenide.element("[name='address']");
    public final SelenideElement cityNameField = Selenide.element("[name='city']");
    public final SelenideElement webSiteField = Selenide.element("[name='website']");
    public final SelenideElement zipCodeField = Selenide.element("[name='zip']");


    public String setRandomCompanyName(String randomText) {
        eraseAllTextField(companyNameField);
        WaitHelper.waitTextFiledShouldBeEmpty(companyNameField,empty,Duration.ofSeconds(2));
        String valueString = "Test Automation Company Name " + randomText;
        companyNameField.sendKeys(valueString);
        return valueString;
    }


    public String setRandomCityName() {
        eraseAllTextField(cityNameField);
        WaitHelper.waitTextFiledShouldBeEmpty(cityNameField,empty,Duration.ofSeconds(2));
        String[] cityNames = {"New York", "Los Angeles", "Chicago", "Houston", "Philadelphia"};
        String randomCityName = cityNames[RandomUtils.getInt(cityNames.length)];
        cityNameField.sendKeys(randomCityName);
        return randomCityName;
    }

    public String setRandomCompanyWebsite() {
        eraseAllTextField(webSiteField);
        WaitHelper.waitTextFiledShouldBeEmpty(webSiteField, empty, Duration.ofSeconds(2));
        webSiteField.shouldBe(empty, Duration.ofSeconds(2));
        String[] companyWebsites = {"youtube.com", "sv.com", "nike.com", "adidas.com", "fresh.com"};
        String randomWebsite = "https://" + companyWebsites[RandomUtils.getInt(companyWebsites.length)];
        webSiteField.sendKeys(randomWebsite);
        return randomWebsite;
    }


    public String setRandomCompanyAddress(String randomText) {
        eraseAllTextField(addressNameField);
        WaitHelper.waitTextFiledShouldBeEmpty(addressNameField, empty, Duration.ofSeconds(2));
        String valueString = "Test Automation Company Address " + randomText;
        addressNameField.sendKeys(valueString);
        return valueString;
    }


    public String setRandomZipCode() {
        eraseAllTextField(zipCodeField);
        WaitHelper.waitTextFiledShouldBeEmpty(zipCodeField, empty, Duration.ofSeconds(2));
        String randomZipCode = String.valueOf(10000 + new Random().nextInt(90000));
        zipCodeField.setValue(randomZipCode);
        return randomZipCode;
    }

    public String getCompanyName() {
        return companyNameField.getValue();
    }

    public String getCompanyAddress() {
        return addressNameField.getValue();
    }

    public String getCityName() {
        return cityNameField.getValue();
    }

    public String getWebSiteUrl() {
        return "https://" + webSiteField.getValue();
    }

    public String getZipCode() {
        return zipCodeField.getValue();
    }


    @Override
    public String getUrl() {
        return "accounts/company";
    }
}
