package com.web.selenium.config.automationWeb.enums;

public enum RunMode {
    LOCAL,REMOTE, GRID, BROWSERSTACK, JENKINS;
    public static RunMode fromSysProp() {
        String v = System.getProperty("runMode", "local").trim().toLowerCase();
        return "remote".equals(v) ? REMOTE : LOCAL;
    }
}
