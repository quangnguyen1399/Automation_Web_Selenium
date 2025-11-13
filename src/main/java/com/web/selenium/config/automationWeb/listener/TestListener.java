package com.web.selenium.config.automationWeb.listener;

import com.web.selenium.config.automationWeb.api.driver.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onTestStart ITestContext");
        DriverManager.startDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish ITestContext");
        DriverManager.quit();
    }



}
