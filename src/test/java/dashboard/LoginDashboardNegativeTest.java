package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import config.Config;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.DashboardLoginPage;


@Epic("Regression Tests")

public class LoginDashboardNegativeTest extends DashboardTestBase {

    @Test(testName = "Verify the functionality of Sign in into SV Dashboard without password")
    public void verifyFunctionalityLoginSvDashboardWithoutPassword() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.pressSignInButton();
        loginPage.passwordErrorText.shouldHave(Condition.text("Incorrect password"));
    }

    @Test(testName = "Verify the functionality of Sign in into SV Dashboard without email")
    public void verifyFunctionalityLoginSvDashboardWithoutEmail() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();
        loginPage.emailErrorText.shouldHave(Condition.text("Invalid Email"));
    }

    @Test(testName = "Verify the functionality of Sign in into SV Dashboard with invalid email")
    public void verifyFunctionalityLoginSvDashboardWithInvalidEmail() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail("test");
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.pressSignInButton();
        loginPage.emailErrorText.shouldHave(Condition.text("Invalid Email"));
    }

    @Test(testName = "Verify the functionality of Sign in into SV Dashboard with invalid credentials")
    public void verifyFunctionalityLoginSvDashboardWithInvalidCredentials() {
        DashboardLoginPage loginPage = new DashboardLoginPage();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD + "incorrect");
        loginPage.pressSignInButton();
        loginPage.emailErrorText.shouldHave(Condition.text("Your username and/or password do not match. Try again."));
    }
}
