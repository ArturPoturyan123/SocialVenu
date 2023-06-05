package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.MyProfilePage;
import utils.RandomUtils;

public class MyProfileTest extends DashboardTestBase {


    @Epic("Regression Tests")

    @Test(testName = "Verify the functionality of saving new account name")

    public void verifyFunctionalitySavingNewAccountName() {
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.open();
        String randomText = RandomUtils.getString();
        myProfilePage.setNameOnAccount(randomText);
        String currentCompanyAddress = myProfilePage.getAccountName();
        myProfilePage.clickSaveChangesButton();
        ToastHelper.waitForToastToAppear();
        String getCurrentCompanyAddress = myProfilePage.getAccountName();
        Assert.assertEquals(currentCompanyAddress,getCurrentCompanyAddress);
    }
}
