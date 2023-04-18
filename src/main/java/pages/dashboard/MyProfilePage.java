package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

public class MyProfilePage extends BasePage<MyProfilePage> {


    private final SelenideElement name = Selenide.element("div>input[name='name']");
    private final SelenideElement saveChangesButton = Selenide.element(By.id("save-changes-button"));


    public String setNameOnAccount(String randomText) {
        eraseAllTextField(name);
        String valueString = "Artur Poturyan " + randomText;
        name.sendKeys(valueString);
        return valueString;
    }

    public void clickSaveChangesButton() {
        saveChangesButton.shouldBe(Condition.enabled).click(ClickOptions.usingJavaScript());
    }


    public String getAccountName() {
        return name.getValue();
    }

    @Override
    public String getUrl() {
        return "accounts/profile";
    }
}
