package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.Test;
import pages.DashboardLoginPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LoginDashboardTest extends DashboardTestBase {


    @Test(testName = "Sign in into SV Dashboardtest")
    public void loginSvDashboard() {

        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.open();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();
        assertThat(WebDriverRunner.driver().url()).contains("/profile/accounts");

    }
}
