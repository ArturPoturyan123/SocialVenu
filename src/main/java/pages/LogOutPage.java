package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waitutils;


import static utils.DriverManager.getDriver;

public class LogOutPage extends BasePage {

    //    @FindBy(css = "data-testid=['KeyboardArrowDownIcon']")
//    private WebElement arrowButton;
    @FindBy(className = ".MuiIconButton-root")
    private WebElement arrowButton;


    @FindBy(css = "li[tabindex='-1']")
    private WebElement logOutButton;


    public void clickArrowButton() {
        /*
        given
        when
        then
         */
        //implicit and explicit
        //Actions class
        //Pagefactory
        Waitutils.getWait().until(ExpectedConditions.visibilityOf(arrowButton));

        new Actions(getDriver()).moveToElement(arrowButton).click().perform();
    }

    public void clickLogOutButton() {
        Waitutils.getWait().until(ExpectedConditions.visibilityOf(logOutButton));
        new Actions(getDriver()).moveToElement(logOutButton).click().perform();
    }
}
