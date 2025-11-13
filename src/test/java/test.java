import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import com.web.selenium.config.automationWeb.config.GlobalConfig;
import com.web.selenium.config.automationWeb.config.GlobalConfigBuilder;
import com.web.selenium.config.automationWeb.data.DataMapper;
import com.web.selenium.config.automationWeb.data.InjectData;
import com.web.selenium.config.automationWeb.data.TestData;
import com.web.selenium.config.automationWeb.driver.SeleniumDriver;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() {
//        DriverManager.startSession();
//        DriverManager.setGlobalConfig(GlobalConfigBuilder.getInstance("Chrome-local-config.properties").getConfig());
//        TestData test = new DataMapper("C:\\quang\\Automation_Web_Selenium\\src\\test\\test.json").getTestData();
//        //SessionManager.getSession().setTestData(test);
//        DriverManager.startDriver();
//    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        DriverManager.quit();
//    }

    @Test
    @InjectData(JsonPath = "")
    public void openHome() {
        //DriverManager.startDriver();
        DriverManager.getDriver().navigate().to("https://www.google.com");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //DriverManager.quit();
        System.out.println("test 0");
    }

    @Test
    @InjectData(JsonPath = "")
    public void openHome1() {
        //DriverManager.startDriver();
        DriverManager.getDriver().navigate().to("https://www.facebook.com/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //DriverManager.quit();
        System.out.println("test 1");
    }

}
