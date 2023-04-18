package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.WaitHelper;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.empty;

public class SocialVersePage extends BasePage<SocialVersePage> {

    public static SelenideElement createNewSocialVerseButton = Selenide.element(By.id("create-socialv-button"));
    public static SelenideElement createSocialVerseButton = Selenide.element("div>button[id='create-sv-button']");
    private final SelenideElement createCardsSocialVerseButton = Selenide.element(By.id("create-sv-card-btn"));
    private final SelenideElement createSpheresSocialVerseButton = Selenide.element(By.id("create-sv-spheres-btn"));
    public SelenideElement inputSocialVerseName = Selenide.element(("div>input[name='name']"));
    public SelenideElement errorText = Selenide.element(("div>p[id='input-meta-title-helper-text']"));
    private final SelenideElement createSvButtonModal = Selenide.element(By.id("create-sv-btn-modal"));
    public static SelenideElement deleteCardButton = Selenide.element(By.id("delete-card-button-0"));
    private final SelenideElement editCardButton = Selenide.element(By.id("edit-card-button-0"));
    private final SelenideElement socialVerseNameInput = Selenide.element(By.id("socialverse-name-input-0"));
    private final SelenideElement yesDeleteButton = Selenide.element(By.id("confirm-delete-socialverse-button"));
    private final SelenideElement arrowBackButton = Selenide.element("div>button>span>svg[data-testid='ArrowBackIcon']");
    public static SelenideElement socialVerseRecordVideos = Selenide.element("div>[data-rbd-droppable-id='droppable']");
    private final SelenideElement addVideoButton = Selenide.element(By.id("add-video-button-0"));

    private final SelenideElement addVideosEditButton = Selenide.element(By.id("add-videos-button-0"));


    public void clickNewSocialVerseButton() {
        WaitHelper.waitElementToPresent(createNewSocialVerseButton, appear, Duration.ofSeconds(5));
        if (isElementDisplayed(createNewSocialVerseButton)) {
            createNewSocialVerseButton.click(ClickOptions.usingJavaScript());
        } else {
            createSocialVerseButton.click(ClickOptions.usingJavaScript());
        }

    }


    public void clickAddVideoEditButton() {
        addVideosEditButton.click(ClickOptions.usingJavaScript());
    }

    public void clickAddVideoButton() {
        scrollToAndClick(addVideoButton);
    }

    public void deleteSocialVerseModalYesButton() {
        yesDeleteButton.click(ClickOptions.usingJavaScript());
        WaitHelper.waitElementToPresent(createNewSocialVerseButton, appear, Duration.ofSeconds(2));

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

    public String getSocialVerseName() {
        return socialVerseNameInput.getValue();
    }

    public void clickCreateSocialVerseButton() {
        createSvButtonModal.shouldBe(Condition.visible);
        createSvButtonModal.click(ClickOptions.usingJavaScript());
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
        WaitHelper.waitTextFiledShouldBeEmpty(inputSocialVerseName, empty, Duration.ofSeconds(2));
    }

    public void writeSocialVerseShortText() {
        String text = "Te";
        inputSocialVerseName.setValue(text);
    }


    public void clickCardsSocialVerseButton() {
        createCardsSocialVerseButton.shouldBe(Condition.visible);
        createCardsSocialVerseButton.click(ClickOptions.usingJavaScript());

    }

    public void clickSpheresSocialVerseButton() {
        createSpheresSocialVerseButton.shouldBe(Condition.visible);
        createSpheresSocialVerseButton.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return "socialverse";
    }
}
