import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardLogin {
    @Test
    public void Login() {

        WebElement password;
        WebElement email;
        WebElement signInButton;
        String Path_driver_firefox = "D:\\MavenNew\\MavenNew\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", Path_driver_firefox);
        WebDriver driver = new FirefoxDriver();


        String url = "https://dashboard.socialv.io";
        driver.get(url);
        driver.manage().window().maximize();

        email = driver.findElement(By.id("email"));
        email.click();
        email.clear();
        System.out.println("Entering the email");
        email.sendKeys("arthurp@doublecoconut.com");


        password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        System.out.println("entering the password");


        password.sendKeys("123456");

        signInButton = driver.findElement(By.cssSelector(".MuiButton-contained"));
        signInButton.click();

        String title = "SocialVenu Dashboard";

        String actualTitle = driver.getTitle();

        System.out.println("Verifying the page title has started");
        Assert.assertEquals(actualTitle,title,"Page title doesnt match");
        System.out.println("The page title has been successfully verified");
        System.out.println("User logged in successfully");
    }
}
