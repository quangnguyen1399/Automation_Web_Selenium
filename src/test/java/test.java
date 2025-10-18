import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import com.web.selenium.config.automationWeb.driver.SeleniumDriver;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SessionManager.setSesson(new SeleniumDriver());
        DriverManager.startDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quit();
    }

    @Test
    public void openHome() {
        DriverManager.getSeleniumDriver().navigate().to("https://www.google.com");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
