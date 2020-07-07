package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;

public class AddProjectPage extends BasePage {
    protected By PAGEOPENEDIDENTIFIER = By.id("accept");

    protected By addProjectButtonSelector = By.id("accept");
    protected By nameSelector = By.id("name");
    protected By suiteModeSingleSelector = By.id("suite_mode_single");
    protected By suiteModeSingleBaselineSelector = By.id("suite_mode_single_baseline");
    protected By suiteModeMultiSelector = By.id("suite_mode_multi");

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

    public WebElement getNameField() {
        return driver.findElement(nameSelector);
    }

    public WebElement getSuiteModeSingleOption() {
        return driver.findElement(suiteModeSingleSelector);
    }

    public WebElement getSuiteModeSingleBaselineOption() {
        return driver.findElement(suiteModeSingleBaselineSelector);
    }

    public WebElement getSuiteModeMultiSelectorOption()  {
        return driver.findElement(suiteModeMultiSelector);
    }
}
