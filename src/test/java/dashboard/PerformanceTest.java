package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.PerformancePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.testng.AssertJUnit.assertEquals;
import static pages.BasePage.isElementDisplayed;
import static pages.dashboard.PerformancePage.sinceBeginningButton;
import static pages.dashboard.PerformancePage.topBarTitle;

@Epic("Regression Tests")
public class PerformanceTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of clicking the Videos statistic block")
    public void verifyFunctionalityOfClickVideosStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickVideoStatisticBlock();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(actualTopBarTitle, "Videos");
    }

    @Test(testName = "Verify the functionality of clicking the Shares statistic block")
    public void verifyFunctionalityOfClickSharesStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickSharesStatisticBlock();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(actualTopBarTitle, "Shares");
    }

    @Test(testName = "Verify the functionality of clicking the Views statistic block")
    public void verifyFunctionalityOfClickViewsStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickViewsStatisticBlock();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(actualTopBarTitle, "Views");
    }

    @Test(testName = "Verify the functionality of clicking the Clicks statistic block")
    public void verifyFunctionalityOfClickClicksStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickClicksStatisticBlock();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(actualTopBarTitle, "Clicks");
    }

    @Test(testName = "Verify the functionality of clicking the Creators statistic block")
    public void verifyFunctionalityOfClickCreatorsStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickCreatorsStatisticBlock();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(actualTopBarTitle, "Creators");
    }


    @Test(testName = "Verify the functionality of opening Calendar")
    public void verifyFunctionalityOfOpeningCalendar() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickCalendarButton();
        WaitHelper.waitElementToPresent(sinceBeginningButton, appear, Duration.ofSeconds(2));
        Assert.assertTrue(isElementDisplayed
                (sinceBeginningButton),"Error: Calendar is not opens");
    }
}

