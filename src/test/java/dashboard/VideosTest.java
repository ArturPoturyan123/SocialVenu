package dashboard;

import base.DashboardTestBase;
import org.testng.annotations.Test;
import pages.dashboard.VideosPage;

public class VideosTest extends DashboardTestBase {



    @Test (testName = "Verify to all toggles enable and disabled functionality")
    public void testtt() {
        VideosPage videosPage = new VideosPage();
        videosPage.open();
        videosPage.clickElement();
        videosPage.clickPlayButton();
        videosPage.closeModal();

    }
}
