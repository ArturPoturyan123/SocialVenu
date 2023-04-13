package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.PerformancePage;

import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Regression Tests")
public class PerformanceTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of clicking all statistic blocks")
    public void verifyFunctionalityOfClickAllStatisticBlocks() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickAllStatisticBlocks();
    }

    @Test(testName = "verify the functionality of clicking the Videos statistic block")
    public void verifyFunctionalityOfClickVideosStatisticBlock() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockVideos, "Videos");
    }

    @Test(testName = "verify the functionality of clicking the Shares statistic block")
    public void verifyFunctionalityOfClickSharesStatisticBlock() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockShares, "Shares");
    }

    @Test(testName = "verify the functionality of clicking the Views statistic block")
    public void verifyFunctionalityOfClickViewsStatisticBlock() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockViews, "Views");
    }

    @Test(testName = "verify the functionality of clicking the Clicks statistic block")
    public void verifyFunctionalityOfClickClicksStatisticBlock() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockClicks, "Clicks");
    }

    @Test(testName = "verify the functionality of clicking the Creators statistic block")
    public void verifyFunctionalityOfClickCreatorsStatisticBlock() throws InterruptedException {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickStatisticBlock(performancePage.statisticBlockCreators, "Creators");
    }


    @Test(testName = "verify the functionality of opening Calendar")
    public void verifyFunctionalityOfOpeningCalendar() {
        PerformancePage performancePage = new PerformancePage();
        performancePage.open();
        performancePage.clickCalendarButton();
        assertThat("Error: Calendar is not opens", performancePage.isElementDisplayed
                (performancePage.sinceBeginningButton));

    }
}

