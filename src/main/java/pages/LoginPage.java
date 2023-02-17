package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Waitutils;

import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {

    @Override
    String getPagePath() {
        return "/";
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;


    @FindBy(css = ".MuiButton-contained")
    private WebElement sign_in_button;


    public void enterEmail(String text) {

        this.email.sendKeys(text);
    }

    public void enterPassword(String text) {

        this.password.sendKeys(text);
    }

    public void pressSignInButton() {
        Waitutils.getWait().until(ExpectedConditions.visibilityOf(sign_in_button));
        this.sign_in_button.click();
    }

}
