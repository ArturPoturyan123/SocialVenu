package dashboard;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static utils.Utils.*;

public class LogOutTest extends TestBase {


    @Test(testName = "Logout from Sv dashboard")
    public void logOutSvDashboard() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.pressSignInButton();
        LogOutPage logOutPage = new LogOutPage();
        logOutPage.clickArrowButton();
        logOutPage.clickLogOutButton();
        Assert.assertEquals(logOutPage.getTitle(), "SocialVenu Dashboard", "Page title doesn't match");
    }
}
