package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.*;

public class TestBase {
    @BeforeSuite
    public void initSuite() {

        Configuration.browser = Config.BROWSER;
        Configuration.browserSize = "1600x950";
        Configuration.driverManagerEnabled = true;

    }


    @AfterMethod
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}
