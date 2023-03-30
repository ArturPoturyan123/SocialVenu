package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.RandomUtils;

public class SocialVersePage extends BasePage<SocialVersePage> {

    public SelenideElement createNewSocialVerseButton = Selenide.element(By.id("create-socialv-button"));
    private final SelenideElement createCardsSocialVerseButton = Selenide.element(By.id("create-sv-card-btn"));
    private final SelenideElement createSpheresSocialVerseButton = Selenide.element(By.id("create-sv-spheres-btn"));
    public SelenideElement inputSocialVerseName = Selenide.element(("div>input[name='name']"));
    public SelenideElement errorText = Selenide.element(("div>p[id='input-meta-title-helper-text']"));
    private final SelenideElement createSocialVerseButton = Selenide.element(By.id("create-sv-btn-modal"));
    private final SelenideElement deleteCardButton = Selenide.element(By.id("delete-card-button-0"));
    private final SelenideElement editCardButton = Selenide.element(By.id("edit-card-button-0"));
    private final SelenideElement socialVerseNameInput = Selenide.element(By.id("socialverse-name-input-0"));
    private final SelenideElement yesDeleteButton = Selenide.element(By.id("confirm-delete-socialverse-button"));
    private final SelenideElement arrowBackButton = Selenide.element("div>button>span>svg[data-testid='ArrowBackIcon']");


    public void clickNewSocialVerseButton() throws InterruptedException {
        Thread.sleep(2000);

        createNewSocialVerseButton.click(ClickOptions.usingJavaScript());

    }

    public void deleteSocialVerseModalYesButton() throws InterruptedException {
        yesDeleteButton.click(ClickOptions.usingJavaScript());
        Thread.sleep(5000);

    }

    public void deleteTheSocialVerseCard() {
        deleteCardButton.click(ClickOptions.usingJavaScript());
    }


    public void editCardButton() {
        editCardButton.click(ClickOptions.usingJavaScript());
    }

    public void clickArrowBackButton() {
        arrowBackButton.click(ClickOptions.usingJavaScript());

    }

    public String getCurrentSocialVerseName() {
        return socialVerseNameInput.getValue();
    }

    public void clickCreateSocialVerseButton() {
        createSocialVerseButton.click(ClickOptions.usingJavaScript());
    }

    public String setRandomSocialVerseName() {
        String[] socialVerseName = {"game", "football", "iPhone", "Android", "fresh"};
        String randomSocialVerseName = socialVerseName[RandomUtils.getInt(socialVerseName.length)];
        inputSocialVerseName.setValue(randomSocialVerseName);
        return randomSocialVerseName;
    }

    public void writeSocialVerseTextAndDeleteField() {
        String text = "Test";
        inputSocialVerseName.setValue(text);
        eraseAllTextField(inputSocialVerseName);
    }

    public void writeSocialVerseShortText() {
        String text = "Te";
        inputSocialVerseName.setValue(text);
    }


    public void clickCardsSocialVerseButton() {
        createCardsSocialVerseButton.click(ClickOptions.usingJavaScript());

    }

    public void clickSpheresSocialVerseButton() {
        createSpheresSocialVerseButton.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return "socialverse";
    }
}
