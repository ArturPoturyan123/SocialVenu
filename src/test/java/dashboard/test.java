package dashboard;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.singlton.SingletonBaseClass;

public class test {
    WebDriver driver1;
    WebDriver driver2;


    @BeforeClass
    public void setUp (){
        SingletonBaseClass.init();
    }


    @Test
    public void testCase (){
        driver1 = SingletonBaseClass.getDriver();
        driver1.get("https://dashboard-release.socialvenu.com/login");

    }
}
