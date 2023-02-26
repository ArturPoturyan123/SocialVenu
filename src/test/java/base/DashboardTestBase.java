package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.JsonObject;
import config.Config;
import org.testng.annotations.BeforeMethod;
import utils.ApiUtils;

public class DashboardTestBase extends TestBase {
    @BeforeMethod
    public void initDashboard() {
        Configuration.baseUrl = Config.DASHBOARD_URL;
        Selenide.open(Configuration.baseUrl);
        JsonObject jsonObject = ApiUtils.loginDashboard("arthurp@doublecoconut.com", "123456");
        jsonObject.addProperty("accounts", 10);
        Selenide.localStorage().setItem("authToken", jsonObject.getAsJsonPrimitive("accessToken").getAsString());
        Selenide.localStorage().setItem("authResponse", jsonObject.toString());
        Selenide.localStorage().setItem("selectedVenue", null);
        Selenide.localStorage().setItem("refreshToken", null);
        Selenide.refresh();
    }
}
