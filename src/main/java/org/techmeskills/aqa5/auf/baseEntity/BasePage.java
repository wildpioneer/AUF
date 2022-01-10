package org.techmeskills.aqa5.auf.baseEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.utils.Waits;

public class BasePage {
    public WebDriver driver;
    public Waits waits;
    public BrowsersService browsersService;

    public BasePage(BrowsersService browsersService) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        this.waits = browsersService.getWaiters();
    }

    public boolean isPageOpened(By by) {
        return waits.waitForVisibility(by).isDisplayed();
    }
}