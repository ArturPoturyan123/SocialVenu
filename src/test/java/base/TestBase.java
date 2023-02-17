package base;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.DriverManager;
import utils.Utils;


import static utils.DriverManager.getDriver;

public class TestBase {


    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.gecko.driver", Utils.FIREFOX_DRIVER_LOCATION);
        DriverManager.setDriver(new FirefoxDriver());
    }


    @AfterSuite
    public  void cleanUp() {
        getDriver().manage().deleteAllCookies();
        getDriver().close();
    }
}
