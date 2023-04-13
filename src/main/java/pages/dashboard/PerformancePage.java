package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import org.openqa.selenium.By;
import pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.testng.AssertJUnit.assertEquals;

public class PerformancePage extends BasePage<PerformancePage> {

    public SelenideElement statisticBlockVideos = Selenide.element(By.id("statistic-block-Videos"));
    public SelenideElement statisticBlockShares = Selenide.element(By.id("statistic-block-Shares"));
    public SelenideElement statisticBlockViews = Selenide.element(By.id("statistic-block-Views"));
    public SelenideElement statisticBlockClicks = Selenide.element(By.id("statistic-block-Clicks"));
    public SelenideElement statisticBlockCreators = Selenide.element(By.id("statistic-block-Creators"));
    public SelenideElement topBarTitle = Selenide.element(By.id("chart-topbar-title"));
    private final SelenideElement calendarButton = Selenide.element("div>svg[data-testid='CalendarTodayIcon']");
    public static SelenideElement sinceBeginningButton = Selenide.element(By.id("since_beginning-date-range-button"));


    public void clickCalendarButton() {
        calendarButton.click(ClickOptions.usingJavaScript());

    }


    public void clickStatisticBlock(SelenideElement statisticBlock, String expectedTopBarTitle) {
        WaitHelper.waitElementToPresent(statisticBlock,appear, Duration.ofSeconds(2));
        statisticBlock.click();
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(expectedTopBarTitle, actualTopBarTitle);
    }


    public void clickAllStatisticBlocks()  {
        SelenideElement[] statisticBlocks = {statisticBlockVideos, statisticBlockShares,
                statisticBlockViews, statisticBlockClicks, statisticBlockCreators};
        String[] expectedTitles = {"Videos", "Shares", "Views", "Clicks", "Creators"};

        for (int i = 0; i < statisticBlocks.length; i++) {
            clickStatisticBlock(statisticBlocks[i], expectedTitles[i]);
        }
    }


    @Override
    public String getUrl() {
        return "dashboard/creators";
    }
}
