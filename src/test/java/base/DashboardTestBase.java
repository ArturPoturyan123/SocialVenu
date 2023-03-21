package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.gson.JsonObject;
import config.Config;
import org.testng.annotations.BeforeMethod;
import utils.ApiUtils;

public class DashboardTestBase extends TestBase {
    @BeforeMethod
    public void initDashboard() {
        Configuration.baseUrl = Config.DASHBOARD_STAGE_URL;
        Selenide.open(Configuration.baseUrl);
        JsonObject jsonObject = ApiUtils.loginDashboard("arthurp@doublecoconut.com", "123456");
        Selenide.localStorage().setItem("authToken", jsonObject.getAsJsonPrimitive("accessToken").getAsString());
        Selenide.localStorage().setItem("selectedVenue", "02ecf7cc-75a0-4288-87e5-e5e868491fa6");
//        jsonObject.addProperty("accounts", 10);
        Selenide.localStorage().setItem("authResponse", jsonObject.toString());
        Selenide.refresh();
    }


}
