package org.techmeskills.aqa5.auf.baseEntity;

import org.openqa.selenium.WebDriver;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.utils.Waiters;

public abstract class BasePage {
    public WebDriver driver;
    public Waiters waiters;
    public BrowsersService browsersService;
    public ReadProperties readProperties;
    public String BASE_URL;

    public BasePage(BrowsersService browsersService, boolean openPageByUrl) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        this.waiters = browsersService.getWaiters();
        this.readProperties = new ReadProperties();
        this.BASE_URL = readProperties.getURL();
        this.driver = browsersService.getDriver();

        if (openPageByUrl) {
            openPage();
        }
        waitForOpen();
    }

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    /**
     * Waiting for page opening
     */
    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < readProperties.getTimeOut()) {
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}