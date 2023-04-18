package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CompanyProfilePage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static helper.WaitHelper.waitElementToPresent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.saveButton;


@Epic("Regression Tests")
public class CompanyProfileTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of saving Company Name")
    public void verifyFunctionalitySavingNewCompanyName() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyName(randomText);
        String setNewCompanyName = companyProfilePage.getCompanyName();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentCompanyName = companyProfilePage.getCompanyName();
        assertThat(setNewCompanyName).isEqualTo(getCurrentCompanyName);
    }

    @Test(testName = "Verify the functionality of saving Company Address")

    public void verifyFunctionalitySavingNewCompanyAddress() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyAddress(randomText);
        String setNewCompanyAddress = companyProfilePage.getCompanyAddress();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentCompanyAddress = companyProfilePage.getCompanyAddress();
        assertThat(setNewCompanyAddress).isEqualTo(getCurrentCompanyAddress);
    }

    @Test(testName = "Verify the functionality of saving City name")
    public void verifyFunctionalitySavingNewCityName() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        companyProfilePage.setRandomCityName();
        String newCityName = companyProfilePage.getCityName();
        companyProfilePage.zoomPage();
        waitElementToPresent(saveButton, appear, Duration.ofSeconds(4));
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentCityName = companyProfilePage.getCityName();
        assertThat(newCityName).isEqualTo(getCurrentCityName);
    }

    @Test(testName = "Verify the functionality of saving Company Web site url")
    public void verifyFunctionalitySavingNewCompanyWebSite() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        companyProfilePage.setRandomCompanyWebsite();
        String newWebsiteUrl = companyProfilePage.getWebSiteUrl();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentWebSiteUrl = companyProfilePage.getWebSiteUrl();
        assertThat(newWebsiteUrl).isEqualTo(getCurrentWebSiteUrl);
    }

    @Test(testName = "Verify the functionality of saving Zip Code")
    public void verifyFunctionalitySavingNewZipCode() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        companyProfilePage.setRandomZipCode();
        String newZipCode = companyProfilePage.getZipCode();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentZipCode = companyProfilePage.getZipCode();
        assertThat(newZipCode).isEqualTo(getCurrentZipCode);
    }
}
