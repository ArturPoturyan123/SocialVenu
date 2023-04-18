package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static org.testng.AssertJUnit.assertEquals;

public class PerformancePage extends BasePage<PerformancePage> {

    public SelenideElement statisticBlockVideos = Selenide.element(By.id("statistic-block-Videos"));
    public SelenideElement statisticBlockShares = Selenide.element(By.id("statistic-block-Shares"));
//    public SelenideElement statisticBlockViews = Selenide.element(By.id("statistic-block-Views"));
    public SelenideElement views = Selenide.$x("//div//p[contains(text(),'Views')]");
    public SelenideElement statisticBlockClicks = Selenide.element(By.id("statistic-block-Clicks"));
    public SelenideElement statisticBlockCreators = Selenide.element(By.id("statistic-block-Creators"));
    public static SelenideElement topBarTitle = Selenide.element(By.id("chart-topbar-title"));
    private final SelenideElement calendarButton = Selenide.element("div>svg[data-testid='CalendarTodayIcon']");
    public static SelenideElement sinceBeginningButton = Selenide.element(By.id("since_beginning-date-range-button"));


    public void clickCalendarButton() {
        calendarButton.click(ClickOptions.usingJavaScript());

    }

    public void clickSharesStatisticBlock() {
        statisticBlockShares.shouldBe(appear).click();
    }

    public void clickViewsStatisticBlock() {
        views.click(ClickOptions.usingJavaScript());
    }

    public void clickClicksStatisticBlock() {
        statisticBlockClicks.shouldBe(appear).click();
    }

    public void clickVideoStatisticBlock() {
        statisticBlockVideos.shouldBe(appear).click();
    }

    public void clickCreatorsStatisticBlock() {
        statisticBlockCreators.shouldBe(appear).click();
    }


    @Override
    public String getUrl() {
        return "dashboard/creators";
    }
}
