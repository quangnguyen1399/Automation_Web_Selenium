package com.web.selenium.config.automationWeb.data;

import com.web.selenium.config.automationWeb.utils.JsonParser;

public class DataMapper {
    private TestData testData;

    public DataMapper(String path) {

        testData = new JsonParser<TestData>().parse(path,TestData.class);
    }

    public TestData getTestData(){
        return testData;
    }
}
