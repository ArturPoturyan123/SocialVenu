package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.SocialVersePage;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SocialVerseTest extends DashboardTestBase {


    @Epic("Regression Tests")

    @Test(testName = "Verify the functionality after adding and removing SocialVerse card type")

    public void verifyFunctionalityOfAddSocialVerseCardAndRemove() throws InterruptedException {
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
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        SelenideElement createButton = socialVersePage.createNewSocialVerseButton;
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                createButton.exists() && createButton.isDisplayed());
    }

    @Test(testName = "Verify the functionality after adding and removing SocialVerse Sphere type")

    public void verifyFunctionalityOfAddSocialVerseSpheresAndRemove() throws InterruptedException {
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
        socialVersePage.deleteTheSocialVerseCard();
        socialVersePage.deleteSocialVerseModalYesButton();
        SelenideElement createButton = socialVersePage.createNewSocialVerseButton;
        assertThat("Error: The create new SocialVerse button does not exist or is not visible.",
                createButton.exists() && createButton.isDisplayed());
    }

    @Test(testName = "Verifying the functionality of creating a socialVerse with empty text should trigger an error alert")
    public void createSocialVerseWithoutText() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseTextAndDeleteField();
        socialVersePage.errorText.shouldHave(Condition.text("name is a required field"));

    }

    @Test(testName = "Verify entering a SocialVerse name with less than 3 letters triggers error alert")
    public void createSocialVerseUsingShortText() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseShortText();
        socialVersePage.errorText.shouldHave(Condition.text("Name must be at least 3 characters long"));

    }
}
