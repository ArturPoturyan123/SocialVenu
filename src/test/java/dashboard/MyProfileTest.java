package dashboard;

import base.DashboardTestBase;
import helper.ToastHelper;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.MyProfilePage;
import utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyProfileTest extends DashboardTestBase {


    @Epic("Regression Tests")

    @Test(testName = "Verify the functionality of saving new account name")

    public void verifyFunctionalitySavingNewAccountName() {
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.open();
        String randomText = RandomUtils.getString();
        myProfilePage.setNameOnAccount(randomText);
        myProfilePage.clickSaveChangesButton();
        ToastHelper.waitForToastToAppear();
//        ToastHelper.waitForToastToDisappear();
        String currentCompanyAddress = myProfilePage.setNameOnAccount(randomText);
        String getCurrentCompanyAddress = myProfilePage.getCurrentAccountName();
        assertThat(currentCompanyAddress).isEqualTo(getCurrentCompanyAddress);


    }
}
