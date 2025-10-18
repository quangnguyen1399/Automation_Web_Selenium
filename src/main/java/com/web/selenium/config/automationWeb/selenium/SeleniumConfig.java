package com.web.selenium.config.automationWeb.selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumConfig {
    public boolean isHealess() {
        return Boolean.valueOf(System.getProperty("isHeadLess", "false"));
    }
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications", "--disable-infobars", "--window-size=1400,1000", "--no-sandbox", "--disable-dev-shm-usage");
        if (isHealess()) options.addArguments("--headless=new");
        return options;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications", "--disable-infobars", "--window-size=1400,1000", "--no-sandbox", "--disable-dev-shm-usage");
        if (isHealess()) options.addArguments("--headless=new");
        return options;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications", "--disable-infobars", "--window-size=1400,1000", "--no-sandbox", "--disable-dev-shm-usage");
        if (isHealess()) options.addArguments("--headless=new");
        return options;
    }
}
