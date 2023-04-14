package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TbWebAppTestBase extends TestBase {
    @BeforeMethod
    public void initWebApp() {
        Configuration.baseUrl = Config.DASHBOARD_URL.replace("{subDomain}","testdentartrel");
        Selenide.open();
    }
}