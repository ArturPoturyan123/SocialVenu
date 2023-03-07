package config;

public interface Config {
    String DASHBOARD_STAGE_URL = PropertyLoader.getProperty("dashboardStageUrl");
    String DASHBOARD_RELEASE_URL = PropertyLoader.getProperty("dashboardReleaseUrl");
    String WEB_APP_URL = PropertyLoader.getProperty("webAppUrl");
    String BACKEND_URL = PropertyLoader.getProperty("backEndUrl");
    String BROWSER = PropertyLoader.getProperty("browser");
    String EMAIL = PropertyLoader.getProperty("email");
    String PASSWORD = PropertyLoader.getProperty("password");

}
