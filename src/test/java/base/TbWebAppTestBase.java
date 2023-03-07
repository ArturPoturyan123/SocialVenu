package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;

public class TbWebAppTestBase extends TestBase {
    @BeforeMethod
    public void initWebApp() {
        Configuration.baseUrl = Config.DASHBOARD_STAGE_URL.replace("{subDomain}","testdentartrel");
        Selenide.open();
    }
}