package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.BeforeMethod;

public class DashboardTestBase extends TestBase {
    @BeforeMethod
    public void initDashboard() {
        Configuration.baseUrl = Config.DASHBOARD_URL;
        Selenide.open();
    }
}
