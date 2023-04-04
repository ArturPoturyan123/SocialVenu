package base;

import com.codeborne.selenide.*;
import config.Config;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.BeforeMethod;

public class SvWebAppTestBase extends TestBase {
    @BeforeMethod
    public void initWebApp() {
        Configuration.baseUrl = Config.WEB_APP_URL.replace("{subDomain}", "testarttusv");
        Selenide.open(Configuration.baseUrl);
        Selenide.localStorage().setItem("authToken", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiNTExYzljZC1jM2JjLTRjMDYt" +
                "YWNhNy0xN" +
                "TQwN2I4NDMwOGYiLCJ2ZW51ZUlkIjoiMTU1YmE0NDgtZWJhZC00MzcyLTgwOWUtYTM4N2FlZjE5YmYxIiwiZW1haWwiOiJhc2R" +
                "kYWtra2tra2RAYXNkYWQucnUiLCJwaG9uZSI6IiszNzQ5ODA1OTUyNCIsIm5hbWUiOiJBcnR0dHR0dCIsImlhdCI6" +
                "MTY3NzE1NDgwOCwiZXhwIjoxN" +
                "jc5NzQ2ODA4fQ.wB5mNkudBTKCTp2zvllaxIcQnZoDqBN7L9qk8pP3Ufo");
        Selenide.refresh();
    }
}