package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.SocialVersePage;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("Regression Tests")
public class SocialVerseTest extends DashboardTestBase {


    public void creatingSocialVerseSpheresType() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickSpheresSocialVerseButton();
        String newCreatedSocialVerseSpheresName = socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String getCurrentSocialVerseSpheresName = socialVersePage.getCurrentSocialVerseName();
        assertThat(newCreatedSocialVerseSpheresName).isEqualTo(getCurrentSocialVerseSpheresName);
    }

    public void creatingSocialVerseCardType() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        String newCreatedSocialVerseCardName = socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String getCurrentSocialVerseName = socialVersePage.getCurrentSocialVerseName();
        assertThat(newCreatedSocialVerseCardName).isEqualTo(getCurrentSocialVerseName);
    }


    @Test(testName = "Verify the functionality of creating and removing SocialVerse card type")

    public void verifyFunctionalityOfCreatingSocialVerseCardAndRemove() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        creatingSocialVerseCardType();
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                socialVersePage.isElementDisplayed(socialVersePage.createNewSocialVerseButton));
    }

    @Test(testName = "Verify the functionality of creating and removing SocialVerse Sphere type")
    public void verifyFunctionalityOfCreatingSocialVerseSpheresAndRemove() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        creatingSocialVerseSpheresType();
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                socialVersePage.isElementDisplayed(socialVersePage.createNewSocialVerseButton));
    }

    @Test(testName = "Verifying the functionality of creating a " +
            "socialVerse with empty text should trigger an error alert")
    public void verifyFunctionalityOfCreateSocialVerseWithoutText() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseTextAndDeleteField();
        socialVersePage.errorText.shouldHave(Condition.text("name is a required field"));

    }

    @Test(testName = "Verify the entering a SocialVerse name with less than 3 letters triggers error alert")
    public void verifyFunctionalityOfCreateSocialVerseUsingShortText() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseShortText();
        socialVersePage.errorText.shouldHave(Condition.text("Name must be at least 3 characters long"));

    }

    @Test(testName = "Verify the functionality of Adding video in socialVerse list")
    public void verifyFunctionalityOfAddingVideoInSocialVeuList() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        creatingSocialVerseCardType();
        socialVersePage.clickAddVideoEditButton();
        socialVersePage.clickAddVideoButton();
        assertThat("The Video is not appear in socialVerse List ",
                socialVersePage.isElementDisplayed(socialVersePage.socialVerseRecordVideos));
        socialVersePage.clickArrowBackButton();
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
    }
}
