package org.techmeskills.auf.baseEntity;

import org.openqa.selenium.WebDriver;
import org.techmeskills.auf.core.BrowsersService;
import org.techmeskills.auf.core.ReadProperties;
import org.techmeskills.auf.utils.Listener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
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