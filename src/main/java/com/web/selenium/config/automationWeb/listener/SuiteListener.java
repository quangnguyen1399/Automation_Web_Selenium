package com.web.selenium.config.automationWeb.listener;

import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import com.web.selenium.config.automationWeb.config.GlobalConfig;
import com.web.selenium.config.automationWeb.config.GlobalConfigBuilder;
import com.web.selenium.config.automationWeb.driver.SeleniumDriver;
import com.web.selenium.config.automationWeb.driver.SessionManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        SessionManager.setSession(new SeleniumDriver());
        SessionManager.getSession().setGlobalConfig(GlobalConfigBuilder.getInstance(iSuite).getConfig());
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}
