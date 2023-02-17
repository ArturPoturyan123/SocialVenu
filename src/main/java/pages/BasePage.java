package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;
import utils.Waitutils;

import static utils.DriverManager.getDriver;

public class BasePage {
    private WebDriver driver;

    public void open() {
        driver.get(Utils.BASE_URL + getPagePath());
    };

    String getPagePath() {
        return "";
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        Waitutils.getWait().until(ExpectedConditions.stalenessOf(element));
        Waitutils.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void setText(WebElement element, String text) {
        Waitutils.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }
}
