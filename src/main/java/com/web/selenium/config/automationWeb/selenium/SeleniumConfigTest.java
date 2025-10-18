//package com.web.selenium.config.automationWeb.selenium;
//
//import com.web.selenium.config.automationWeb.enums.Browsers;
//import com.web.selenium.config.automationWeb.enums.RunMode;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.nio.file.Paths;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//
//public class SeleniumConfigTest {
//    public static final RunMode RUN_MODE = RunMode.fromSysProp();
//    //public static final Browsers BROWSER = Browsers.fromSysProp();
//
//
//    public static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "false"));
//    public static final String GRID_URL = System.getProperty("gridUrl", "http://localhost:4444");
//    public static final String DOWNLOAD_DIR = System.getProperty(
//            "downloadDir",
//            Paths.get(System.getProperty("user.dir"), "downloads").toString()
//    );
//    public static final String BROWSER_VERSION = System.getProperty("browserVersion", "").trim();
//    public static final String PLATFORM_NAME = System.getProperty("platformName", "").trim();
//
//    private SeleniumConfigTest() {
//    }
//
//    // ----------------- Common -----------------
//    private static void commonPostInit(WebDriver driver) {
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        try {
//            if (!HEADLESS) driver.manage().window().maximize();
//        } catch (Exception ignored) {
//        }
//    }
//
//    // ----------------- Chrome -----------------
//    private static WebDriver buildChrome() {
//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.addArguments("--disable-notifications", "--disable-infobars", "--window-size=1400,1000", "--no-sandbox", "--disable-dev-shm-usage");
//        if (HEADLESS) options.addArguments("--headless=new");
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", DOWNLOAD_DIR);
//        prefs.put("download.prompt_for_download", false);
//        options.setExperimentalOption("prefs", prefs);
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);
//        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
//        options.setCapability("goog:loggingPrefs", logPrefs);
//        if (!BROWSER_VERSION.isEmpty()) options.setBrowserVersion(BROWSER_VERSION);
//        if (!PLATFORM_NAME.isEmpty()) options.setPlatformName(PLATFORM_NAME);
//        return RUN_MODE == RunMode.REMOTE ? remote(options) : localChrome(options);
//    }
//
//    private static WebDriver localChrome(ChromeOptions options) {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver(options);
//        commonPostInit(driver);
//        return driver;
//    }
//
//    // ----------------- Edge -----------------
//    private static WebDriver buildEdge() {
//        EdgeOptions options = new EdgeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.addArguments("--window-size=1400,1000", "--disable-notifications");
//        if (HEADLESS) options.addArguments("--headless=new");
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", DOWNLOAD_DIR);
//        prefs.put("download.prompt_for_download", false);
//        options.setExperimentalOption("prefs", prefs);
//        if (!BROWSER_VERSION.isEmpty()) options.setBrowserVersion(BROWSER_VERSION);
//        if (!PLATFORM_NAME.isEmpty()) options.setPlatformName(PLATFORM_NAME);
//        return RUN_MODE == RunMode.REMOTE ? remote(options) : localEdge(options);
//    }
//
//
//    private static WebDriver localEdge(EdgeOptions options) {
//        WebDriverManager.edgedriver().setup();
//        EdgeDriver driver = new EdgeDriver(options);
//        commonPostInit(driver);
//        return driver;
//    }
//
//    // ----------------- Firefox -----------------
//    private static WebDriver buildFirefox() {
//        FirefoxOptions options = new FirefoxOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        if (HEADLESS) options.addArguments("-headless");
//
//        options.addPreference("browser.download.folderList", 2);
//        options.addPreference("browser.download.dir", DOWNLOAD_DIR);
//        options.addPreference("browser.download.useDownloadDir", true);
//        options.addPreference("pdfjs.disabled", true);
//        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream,application/zip,text/csv");
//        if (!BROWSER_VERSION.isEmpty()) options.setBrowserVersion(BROWSER_VERSION);
//        if (!PLATFORM_NAME.isEmpty()) options.setPlatformName(PLATFORM_NAME);
//
//
//        return RUN_MODE == RunMode.REMOTE ? remote(options) : localFirefox(options);
//    }
//
//
//    private static WebDriver localFirefox(FirefoxOptions options) {
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxDriver driver = new FirefoxDriver(options);
//        commonPostInit(driver);
//        return driver;
//    }
//
//    // ----------------- Remote -----------------
//    private static WebDriver remote(org.openqa.selenium.Capabilities options) {
//        try {
//            RemoteWebDriver driver = new RemoteWebDriver(new URL(GRID_URL), options);
//            commonPostInit(driver);
//            return driver;
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Invalid gridUrl: " + GRID_URL, e);
//        }
//    }
//
//    public static WebDriver createDriver() {
//        return switch (BROWSER) {
//            case EDGE -> buildEdge();
//            case FIREFOX -> buildFirefox();
//            case CHROME -> buildChrome();
//        };
//    }
//}
