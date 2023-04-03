package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.MyProfilePage;
import utils.RandomUtils;

public class MyProfileTest extends DashboardTestBase {


    @Epic("Regression Tests")

    @Test(testName = "Verify the functionality ")

    public void test() throws InterruptedException {
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.open();
        String currentAccountName = RandomUtils.getString();
        myProfilePage.updateNameOnAccount(currentAccountName);







    }
}
