package org.techmeskills.aqa5.auf.baseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest extends Parent {

    public Logger mainLogger = LogManager.getLogger();

    public BrowsersService browsersService;
    public ReadProperties properties;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        browsersService.getDriver().get(properties.getURL());
    }

    @AfterClass
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}