package org.example;

import org.example.BaseWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        BaseWebDriver.initializeDriver();
    }

    @AfterClass
    public void tearDown() {
        BaseWebDriver.quitDriver();
    }
}
