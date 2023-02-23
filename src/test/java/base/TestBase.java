package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.*;

public class TestBase {
    @BeforeSuite
    public void initSuite(){
        Configuration.browser = Config.BROWSER;
        Configuration.browserSize = "1920x1080";
        Configuration.driverManagerEnabled = true;

    }


    @AfterMethod
    public  void cleanUp() {
        Selenide.closeWebDriver();
    }
}
