package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboard.AccountPage;
import pages.dashboard.DashboardLoginPage;


public class LoginDashboardNegativeTest extends DashboardTestBase {

    @BeforeMethod
    public void removeAuthToken() {
        Selenide.localStorage().removeItem("authToken");
        Selenide.refresh();
    }

    @Test(testName = "Sign in into SV Dashboard without password")
    public void loginSvDashboardWithoutPassword() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.pressSignInButton();

        loginPage.passwordErrorText.shouldHave(Condition.text("Incorrect password"));
    }

    @Test(testName = "Sign in into SV Dashboard without email")
    public void loginSvDashboardWithoutEmail() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();

        loginPage.emailErrorText.shouldHave(Condition.text("Invalid Email"));
    }

    @Test(testName = "Sign in into SV Dashboard with invalid email")
    public void loginSvDashboardWithInvalidEmail() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail("sassa");
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();

        loginPage.emailErrorText.shouldHave(Condition.text("Invalid Email"));
    }

    @Test(testName = "Sign in into SV Dashboard with invalid credentials")
    public void loginSvDashboardWithInvalidCredentials() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD + "dummy");
        loginPage.pressSignInButton();

        loginPage.emailErrorText.shouldHave(Condition.text("Your username and/or password do not match. Try again."));
    }
}
