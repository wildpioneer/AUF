package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

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
        return !super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public UIElement getAddProjectButton() {
        return new UIElement(driver, addProjectButtonSelector);
        //return driver.findElement(addProjectButtonSelector);
    }

    public UIElement getNameField() {
        return new UIElement(driver, nameSelector);
    }

    public UIElement getSuiteModeSingleOption() {
        return new UIElement(driver, suiteModeSingleSelector);
    }

    public UIElement getSuiteModeSingleBaselineOption() {
        return new UIElement(driver, suiteModeSingleBaselineSelector);
    }

    public UIElement getSuiteModeMultiSelectorOption()  {
        return new UIElement(driver, suiteModeMultiSelector);
    }


}
