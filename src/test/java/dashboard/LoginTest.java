package dashboard;

import base.TestBase;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import static org.testng.Assert.assertEquals;

public class LoginTest extends TestBase {


    @Test(testName = "Sign in into SV Dashboard")
    public void loginSvDashboard() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterEmail(Utils.EMAIL);
        loginPage.enterPassword(Utils.PASSWORD);
        loginPage.pressSignInButton();
        assertEquals(loginPage.getTitle(), "SocialVenu Dashboard");
    }
}
