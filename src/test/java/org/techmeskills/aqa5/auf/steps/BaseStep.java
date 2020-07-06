package org.techmeskills.aqa5.auf.steps;

import org.openqa.selenium.WebDriver;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.utils.Waiters;

public class BaseStep {
    public WebDriver driver;
    public Waiters waiters;

    public BaseStep(BrowsersService browsersService) {
        this.driver = browsersService.getDriver();
        this.waiters = browsersService.getWaiters();
    }
}
