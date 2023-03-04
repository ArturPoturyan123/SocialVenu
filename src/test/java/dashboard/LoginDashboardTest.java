package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.AccountPage;
import pages.dashboard.DashboardLoginPage;

public class LoginDashboardTest extends DashboardTestBase {

    @BeforeMethod
    public void removeAuthToken() {
        Selenide.localStorage().removeItem("authToken");
    }

    @Test(testName = "Sign in into SV Dashboard")
    public void loginSvDashboard() throws InterruptedException {
        DashboardLoginPage loginPage = new DashboardLoginPage().open();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();
        new AccountPage().rootElement.shouldBe(Condition.visible);
    }
}
