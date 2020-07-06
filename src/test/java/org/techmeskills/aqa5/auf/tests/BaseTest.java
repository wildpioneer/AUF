package org.techmeskills.aqa5.auf.tests;

import org.openqa.selenium.WebDriver;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public BrowsersService browsersService;
    public ReadProperties properties;
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        driver = browsersService.getDriver();
        driver.get(properties.getURL());
    }

    @AfterClass
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}