package com.web.selenium.config.automationWeb.driver;

import com.web.selenium.config.automationWeb.config.GlobalConfig;
import com.web.selenium.config.automationWeb.data.DataMapper;
import com.web.selenium.config.automationWeb.data.TestData;
import org.openqa.selenium.WebDriver;

public class SeleniumDriver implements SeleniumDriverInterface {

    private TestData testData;
    private GlobalConfig globalConfig;
    private WebDriver webDriver;

    @Override
    public void setDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public WebDriver getDriver() {
        return webDriver;
    }

    @Override
    public void setTestData(TestData testData) {
        this.testData = testData;
    }

    @Override
    public TestData getTestData() {
        return testData;
    }

    @Override
    public void setGlobalConfig(GlobalConfig config) {
        this.globalConfig = config;
    }

    @Override
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }



}
