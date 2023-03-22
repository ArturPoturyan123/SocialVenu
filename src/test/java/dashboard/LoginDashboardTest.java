package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Config;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.AccountPage;
import pages.dashboard.DashboardLoginPage;


@Epic("Regression Tests")

public class LoginDashboardTest extends DashboardTestBase {

    @BeforeMethod
    public void removeAuthToken() {
        Selenide.localStorage().removeItem("authToken");
    }

    @Test(testName = "Sign in into SV Dashboard")
    public void loginSvDashboard()  {
        DashboardLoginPage loginPage = new DashboardLoginPage().open();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();
        new AccountPage().rootElement.shouldBe(Condition.visible);
    }
}
