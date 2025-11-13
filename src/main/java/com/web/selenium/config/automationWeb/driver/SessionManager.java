package com.web.selenium.config.automationWeb.driver;

public class SessionManager {

    private static final ThreadLocal<SeleniumDriverInterface> sessionService = new ThreadLocal<>();


    public static SeleniumDriverInterface getSession(){
        if(sessionService.get() == null){
            throw new RuntimeException("Session isn't instantiate yet.");
        }
        return sessionService.get();
    }

    public static void setSession(SeleniumDriverInterface session){
        sessionService.set(session);
    }

    public static Boolean isDriverRunning() {
        return sessionService.get() == null;
    }

    public static void removeThread(){
        sessionService.remove();
    }

}
