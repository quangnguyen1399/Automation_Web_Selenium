package com.web.selenium.config.automationWeb.selenium;

import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import com.web.selenium.config.automationWeb.driver.SeleniumDriverInterface;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import com.web.selenium.config.automationWeb.enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.web.selenium.config.automationWeb.constants.GlobalConstants.DRIVER_DOWNLOADED;

public class SeleniumDriverManager {

    public static void startWebDriver(){
//        EnhancedDriverImp driver = null;
//		if(Boolean.valueOf(GlobalConfigBuilder.getInstace().getConfig().get("isLocalExecution"))) {
//			driver = initLocalWebDriver();
//		}else {
//			driver = initRemoteWebDriver(GlobalConfigBuilder.getInstace().getConfig().get("hubURL"));
//		}
//        String hub = null;
//        if(Boolean.valueOf(GlobalConfigBuilder.getInstance().getConfig().get("isLocalExecution"))){
//            hub = "http://localhost:4444";
//        }else {
//            hub = GlobalConfigBuilder.getInstance().getConfig().get("hubURL");
//        }
        WebDriver driver = initLocalWebDriver();
        SeleniumDriverInterface e = SessionManager.getSession();
        SessionManager.getSession().setDriver(driver);
        WebDriver d =  SessionManager.getSession().getDriver();
        SeleniumDriverInterface a = SessionManager.getSession();

        System.out.println(d);
    }
    public static void launchGridLocal(){
        WebDriverManager.chromedriver().cachePath(DRIVER_DOWNLOADED).avoidTmpFolder().setup();
        WebDriverManager.edgedriver().cachePath(DRIVER_DOWNLOADED).avoidTmpFolder().setup();
        WebDriverManager.firefoxdriver().cachePath(DRIVER_DOWNLOADED).avoidTmpFolder().setup();
        try {
            System.out.println("🚀 Starting Selenium Grid standalone on port 4444...");
            Main.main(new String[]{
                    "standalone",
                    "--port", "4444",
                    "--override-max-sessions", "true",
                    "--max-sessions", "5",
                    "--session-timeout", "600"
            });
            Thread.sleep(2000L); // chờ Grid khởi động
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static WebDriver initLocalWebDriver() {
        try {
            SeleniumConfig sc = new SeleniumConfig();
            Browsers browser = Browsers.valueOf(DriverManager.getGlobalConfig().get("browserName").toUpperCase());
            WebDriver driver = switch (browser) {
                case CHROME  -> new ChromeDriver(sc.getChromeOptions());
                case FIREFOX -> new FirefoxDriver(sc.getFirefoxOptions());
                case EDGE    -> new EdgeDriver(sc.getEdgeOptions());
                default      -> new ChromeDriver(sc.getChromeOptions());
            };
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));
            driver.get("about:blank");
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to init local WebDriver: " + e.getMessage(), e);
        }
    }

    private static WebDriver initRemoteWebDriver(String hub) {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(hub), new SeleniumConfig().getChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid gridUrl: " + hub, e);
        }
        return driver;
    }


}
