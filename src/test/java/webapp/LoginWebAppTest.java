package webapp;

import base.SvWebAppTestBase;
import org.testng.annotations.Test;
import pages.webapp.SvWebAppLoginPage;

public class LoginWebAppTest extends SvWebAppTestBase {


    @Test (testName = "Sign in into SV web app")
    public void loginWebApp () throws InterruptedException {
        SvWebAppLoginPage svWebApp = new SvWebAppLoginPage();
        svWebApp.open();
        svWebApp.loginButton();

    }

}
