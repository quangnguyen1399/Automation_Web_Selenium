package com.web.selenium.config.automationWeb.driver;

import com.web.selenium.config.automationWeb.config.GlobalConfig;
import com.web.selenium.config.automationWeb.data.DataMapper;
import com.web.selenium.config.automationWeb.data.TestData;
import org.openqa.selenium.WebDriver;

public interface SeleniumDriverInterface {

    void setDriver(WebDriver webDriver);

    WebDriver getDriver();

    void setTestData(TestData testData);

    TestData getTestData();

    void setGlobalConfig(GlobalConfig globalConfig);
    GlobalConfig getGlobalConfig();


}
