package com.web.selenium.config.automationWeb.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {
    private Properties properties;

    public void reader(String filePath){
        setProperties(new Properties());
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(filePath);
            getProperties().load(stream);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            // close objects
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public Properties getProperties(){
        return properties;
    }
}
