package com.web.selenium.config.automationWeb.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumDriver implements SeleniumDriverInterface {

    //    private DataMapper dataMapper;
//    private GlobalConfig globalConfig;
    private WebDriver webDriver;
    //    @Override
//    public void setDataMapper(DataMapper dataMapper) {
//        this.dataMapper = dataMapper;
//    }
//
//    @Override
//    public DataMapper getDataMapper() {
//        return dataMapper;
//    }
    @Override
    public void setDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Override
    public WebDriver getDriver() {
        return webDriver;
    }


}
