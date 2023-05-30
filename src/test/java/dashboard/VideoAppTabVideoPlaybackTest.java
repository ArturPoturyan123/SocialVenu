package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.VideoAppTabVideoPlaybackPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class VideoAppTabVideoPlaybackTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of the opens Video Playback section")
    public void verifyFunctionalitySayHelloToYourVideoAppModalAppear() {
        VideoAppTabVideoPlaybackPage customizationVideoAppTabVideoPlaybackPage =
                new VideoAppTabVideoPlaybackPage();
        customizationVideoAppTabVideoPlaybackPage.open();

    }
}
