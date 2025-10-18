package com.web.selenium.config.automationWeb.api.driver;

import com.web.selenium.config.automationWeb.driver.SeleniumDriverInterface;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import com.web.selenium.config.automationWeb.selenium.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static void startDriver(){
        //SeleniumDriverManager.launchGridLocal();
        SeleniumDriverManager.startWebDriver();
    }

    public static void launchGridLocal(){
        SeleniumDriverManager.launchGridLocal();
    }

    public static WebDriver getSeleniumDriver(){
        WebDriver driver= SessionManager.getSession().getDriver();

        return driver;
    }
    public static void quit(){
        SessionManager.getSession().getDriver().quit();
    }



}
