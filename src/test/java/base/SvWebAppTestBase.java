package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;

public class SvWebAppTestBase extends TestBase {
    @BeforeMethod
    public void initWebApp() {
        Configuration.baseUrl = Config.WEB_APP_URL.replace("{subDomain}","testarttusv");
        Selenide.open();
    }
}