package dashboard;

import base.DashboardTestBase;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.PerformancePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;
import static pages.dashboard.PerformancePage.sinceBeginningButton;

@Epic("Regression Tests")
public class PerformanceTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of clicking all statistic blocks")
    public void verifyFunctionalityOfClickAllStatisticBlocks() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickAllStatisticBlocks();
    }

    @Test(testName = "Verify the functionality of clicking the Videos statistic block")
    public void verifyFunctionalityOfClickVideosStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockVideos, "Videos");
    }

    @Test(testName = "Verify the functionality of clicking the Shares statistic block")
    public void verifyFunctionalityOfClickSharesStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockShares, "Shares");
    }

    @Test(testName = "Verify the functionality of clicking the Views statistic block")
    public void verifyFunctionalityOfClickViewsStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockViews, "Views");
    }

    @Test(testName = "Verify the functionality of clicking the Clicks statistic block")
    public void verifyFunctionalityOfClickClicksStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockClicks, "Clicks");
    }

    @Test(testName = "Verify the functionality of clicking the Creators statistic block")
    public void verifyFunctionalityOfClickCreatorsStatisticBlock() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockCreators, "Creators");
    }


    @Test(testName = "Verify the functionality of opening Calendar")
    public void verifyFunctionalityOfOpeningCalendar() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickCalendarButton();
        WaitHelper.waitElementToPresent(sinceBeginningButton, appear, Duration.ofSeconds(2));
        assertThat("Error: Calendar is not opens", performancePage.isElementDisplayed
                (sinceBeginningButton));

    }
}

