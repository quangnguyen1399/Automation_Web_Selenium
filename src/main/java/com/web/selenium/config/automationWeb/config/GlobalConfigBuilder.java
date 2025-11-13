package com.web.selenium.config.automationWeb.config;

import com.web.selenium.config.automationWeb.constants.GlobalConstants;
import com.web.selenium.config.automationWeb.driver.SeleniumDriver;
import com.web.selenium.config.automationWeb.driver.SeleniumDriverInterface;
import com.web.selenium.config.automationWeb.utils.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.Properties;

public class GlobalConfigBuilder extends SeleniumDriver {
    private GlobalConfig globalConfig;
    private static GlobalConfigBuilder configBuilder;

    public GlobalConfigBuilder(String path) {
        globalConfig = new GlobalConfig();
        if (path == null || path.isBlank()) {
            path = GlobalConstants.CHROME_CONFIG;
        } else {
            path = GlobalConstants.RESOURCES_SLUG_CONFIG + path;
        }
        PropertiesFileReader reader = new PropertiesFileReader();
        reader.reader(path);
        if (reader.getProperties() == null || reader.getProperties().isEmpty()) {
            throw new IllegalStateException("No properties loaded from: " + path);
        }
        for (final String name : reader.getProperties().stringPropertyNames()) {
            globalConfig.put(name, reader.getProperties().getProperty(name));
        }
    }
    public static GlobalConfigBuilder getInstance(String path) {
        if (configBuilder == null) {
            configBuilder = new GlobalConfigBuilder(path);
        }
        return configBuilder;
    }

    public static GlobalConfigBuilder getInstance(ISuite iSuite) {
        String path = iSuite.getParameter("config");
        return getInstance(path);
    }

    public GlobalConfig getConfig() {
        return globalConfig;
    }

    public void setConfig(GlobalConfig config) {
        this.globalConfig = config;
    }

}
