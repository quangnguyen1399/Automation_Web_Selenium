package com.web.selenium.config.automationWeb.api.driver;

import com.web.selenium.config.automationWeb.config.GlobalConfig;
import com.web.selenium.config.automationWeb.driver.SeleniumDriver;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import com.web.selenium.config.automationWeb.selenium.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static void startDriver(){
        SeleniumDriverManager.startWebDriver();
    }

    public static void quit(){
        SessionManager.getSession().getDriver().quit();
    }

    public static void launchGridLocal(){
        SeleniumDriverManager.launchGridLocal();
    }

    public static WebDriver getDriver(){
        return SessionManager.getSession().getDriver();
    }

    public static void startSession(){
        SessionManager.setSesson(new SeleniumDriver());
    }

    public  static void setGlobalConfig(GlobalConfig globalConfig){
        SessionManager.getSession().setGlobalConfig(globalConfig);
    }
    public static GlobalConfig getGlobalConfig(){
        return SessionManager.getSession().getGlobalConfig();
    }



}
