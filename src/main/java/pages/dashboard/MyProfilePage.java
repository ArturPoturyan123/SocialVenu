package pages.dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class MyProfilePage extends BasePage<MyProfilePage> {


    private final SelenideElement name = Selenide.element("div>input[name='name']");


    public String updateNameOnAccount(String randomText){
        eraseAllTextField(name);
        String valueString = "Artur Poturyan " + randomText;
        name.sendKeys(valueString);
        return valueString;
    }




    public String getCurrentAccountName() {
        return name.getValue();
    }

    @Override
    public String getUrl() {
        return "accounts/profile";
    }
}
