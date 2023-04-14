package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Selenide;
import config.Config;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.DashboardLoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.BasePage.isElementDisplayed;
import static pages.dashboard.DashboardLoginPage.allAccountsButton;


@Epic("Regression Tests")

public class DashboardLoginTest extends DashboardTestBase {

    @BeforeMethod
    public void removeAuthToken() {
        Selenide.localStorage().removeItem("authToken");
    }

    @Test(testName = "Verify the functionality of Sign in into SV Dashboard")
    public void verifyFunctionalitySignInSvDashboard() {
        DashboardLoginPage dashboardLoginPage = new DashboardLoginPage().open();
        dashboardLoginPage.enterEmail(Config.EMAIL);
        dashboardLoginPage.enterPassword(Config.PASSWORD);
        dashboardLoginPage.pressSignInButton();
        WaitHelper.waitElementToPresent(allAccountsButton, appear, Duration.ofSeconds(2));
        assertThat("Error: The user is not sign in ", isElementDisplayed(allAccountsButton));

    }
}
