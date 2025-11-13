package com.web.selenium.config.automationWeb.listener;

import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult){
        DriverManager.startDriver();
    }
}
