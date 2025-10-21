package com.web.selenium.config.automationWeb.driver;

import com.web.selenium.config.automationWeb.config.GlobalConfig;
import org.openqa.selenium.WebDriver;

public interface SeleniumDriverInterface {

    void setDriver(WebDriver webDriver);

    WebDriver getDriver();

//    void setDataMapper(DataMapper obj);
//
//    DataMapper getDataMapper();

    void setGlobalConfig(GlobalConfig globalConfig);
    GlobalConfig getGlobalConfig();


}
