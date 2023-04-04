package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static org.testng.AssertJUnit.assertEquals;

public class PerformancePage extends BasePage<PerformancePage> {

    public SelenideElement statisticBlockVideos = Selenide.element(By.id("statistic-block-Videos"));
    public SelenideElement statisticBlockShares = Selenide.element(By.id("statistic-block-Shares"));
    public SelenideElement statisticBlockViews = Selenide.element(By.id("statistic-block-Views"));
    public SelenideElement statisticBlockClicks = Selenide.element(By.id("statistic-block-Clicks"));
    public SelenideElement statisticBlockCreators = Selenide.element(By.id("statistic-block-Creators"));
    public SelenideElement topBarTitle = Selenide.element(By.id("chart-topbar-title"));


    public void clickStatisticBlock(SelenideElement statisticBlock, String expectedTopBarTitle) throws InterruptedException {
        statisticBlock.shouldBe(Condition.visible).click();
        Thread.sleep(2000);
        String actualTopBarTitle = topBarTitle.getText();
        assertEquals(expectedTopBarTitle, actualTopBarTitle);
    }


    public void clickAllStatisticBlocks() throws InterruptedException {
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
