package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.*;
import pages.dashboard.SocialVersePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.BasePage.isElementDisplayed;
import static pages.dashboard.SocialVersePage.createNewSocialVerseButton;
import static pages.dashboard.SocialVersePage.socialVerseRecordVideos;

@Epic("Regression Tests")
public class SocialVerseTest extends DashboardTestBase {


    @BeforeMethod
    public void deleteSocialVerseCard() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        if (!isElementDisplayed(createNewSocialVerseButton)) {
            socialVersePage.deleteTheSocialVerseCard();
            socialVersePage.deleteSocialVerseModalYesButton();
        }
    }


    @Test(testName = "Verify the functionality of creating and removing SocialVerse card type")

    public void verifyFunctionalityOfCreatingSocialVerseCardAndRemove() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        String newCreatedSocialVerseCardName = socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String getCurrentSocialVerseName = socialVersePage.getCurrentSocialVerseName();
        assertThat(newCreatedSocialVerseCardName).isEqualTo(getCurrentSocialVerseName);
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                isElementDisplayed(createNewSocialVerseButton));
    }

    @Test(testName = "Verify the functionality of creating and removing SocialVerse Sphere type")
    public void verifyFunctionalityOfCreatingSocialVerseSpheresAndRemove() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        String newCreatedSocialVerseCardName = socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String getCurrentSocialVerseName = socialVersePage.getCurrentSocialVerseName();
        assertThat(newCreatedSocialVerseCardName).isEqualTo(getCurrentSocialVerseName);
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                isElementDisplayed(createNewSocialVerseButton));
    }

    @Test(testName = "Verify the functionality of creating a " +
            "socialVerse with empty text should trigger an error alert")
    public void verifyFunctionalityOfCreateSocialVerseWithoutText() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseTextAndDeleteField();
        socialVersePage.errorText.shouldHave(Condition.text("name is a required field"));

    }

    @Test(testName = "Verify the functionality of SocialVerse name with less than 3 letters triggers error alert")
    public void verifyFunctionalityOfCreateSocialVerseUsingShortText() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseShortText();
        socialVersePage.errorText.shouldHave(Condition.text("Name must be at least 3 characters long"));

    }

    @Test(testName = "Verify the functionality of Adding video in socialVerse list")
    public void verifyFunctionalityOfAddingVideoInSocialVeuList() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickAddVideoButton();
        WaitHelper.waitElementToPresent(socialVerseRecordVideos, appear, Duration.ofSeconds(2));
        assertThat("The Video is not appear in socialVerse List ",
                isElementDisplayed(socialVerseRecordVideos));
    }
}
