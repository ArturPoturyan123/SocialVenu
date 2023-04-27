package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestBase {
    @BeforeSuite
    public void initSuite() {

        Configuration.browser = Config.BROWSER;
        Configuration.browserSize = "1700x1000";
//        Configuration.browserSize = "1500x800";
        Configuration.driverManagerEnabled = true;
//        Configuration.headless = true;

        deleteAllureResultsFolder();
        deleteAllureReportFolder();
    }

    public void deleteAllureResultsFolder() {
        Path allureResultsPath = Paths.get("allure-results");
        if (Files.exists(allureResultsPath)) {
            File allureResultsFolder = allureResultsPath.toFile();
            deleteFolder(allureResultsFolder);
        }
    }

    public void deleteAllureReportFolder() {
        Path allureReportPath = Paths.get("allure-report");
        if (Files.exists(allureReportPath)) {
            File allureReportFolder = allureReportPath.toFile();
            deleteFolder(allureReportFolder);
        }
    }

    private void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    @AfterMethod
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}
