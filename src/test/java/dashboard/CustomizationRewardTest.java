package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.CustomizationRewardsPage;

public class CustomizationRewardTest extends DashboardTestBase {

    @BeforeMethod
    public void setVenue() {
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
        Selenide.refresh();

    }

    @Test (testName = "Verify to open reward page")
    public void verify () throws InterruptedException {
        CustomizationRewardsPage customizationRewardsPage = new CustomizationRewardsPage();
        customizationRewardsPage.open();
        customizationRewardsPage.clickAllToggles();
        customizationRewardsPage.clickOnSaveButton();



    }


}
