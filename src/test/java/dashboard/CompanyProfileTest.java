package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CompanyProfilePage;
import utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Epic("Regression Tests")
public class CompanyProfileTest extends DashboardTestBase {


    @Test(testName = "Verify Functionality after saving Company Name any random texts")
    public void verifyFunctionalitySavingNewCompanyName() throws InterruptedException {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyName(randomText);
        companyProfilePage.zoomPage();
        Thread.sleep(2000);
        companyProfilePage.clickOnSaveButton(companyProfilePage.saveButton);
        companyProfilePage.resetZoom();
        String currentCompanyName = companyProfilePage.setRandomCompanyName(randomText);
        String getCurrentCompanyName = companyProfilePage.getCurrentCompanyName();
        assertThat(currentCompanyName).isEqualTo(getCurrentCompanyName);

    }

    @Test(testName = "Verify Functionality after saving Company Address any random texts")

    public void verifyFunctionalitySavingNewCompanyAddress() throws InterruptedException {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyAddress(randomText);
        companyProfilePage.zoomPage();
        companyProfilePage.clickOnSaveButton(companyProfilePage.saveButton);
        companyProfilePage.resetZoom();
        String currentCompanyAddress = companyProfilePage.setRandomCompanyAddress(randomText);
        String getCurrentCompanyAddress = companyProfilePage.getCurrentCompanyAddress();
        assertThat(currentCompanyAddress).isEqualTo(getCurrentCompanyAddress);

    }

    @Test(testName = "Verify Functionality after saving Company Address any random City")
    public void verifyFunctionalitySavingNewCityName() throws InterruptedException {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String newCityName = companyProfilePage.setRandomCityName();
        companyProfilePage.zoomPage();
        Thread.sleep(2000);
        companyProfilePage.clickOnSaveButton(companyProfilePage.saveButton);
        companyProfilePage.resetZoom();
        String getCurrentCityName = companyProfilePage.getCurrentCityName();
        assertThat(newCityName).isEqualTo(getCurrentCityName);


    }
}
