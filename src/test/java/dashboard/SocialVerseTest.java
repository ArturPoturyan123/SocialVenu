package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.SocialVersePage;

public class SocialVerseTest extends DashboardTestBase {


    @Epic("Regression Tests")

    @Test(testName = "Verify Functionality after saving Company Name any random texts")

    public void test (){
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();

    }
}
