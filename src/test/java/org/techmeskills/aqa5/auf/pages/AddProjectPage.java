package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

import java.util.List;

public class AddProjectPage extends BasePageFactory {

    @FindBy(id = "accept")
    public WebElement addProjectButton;

    @FindBys({
            @FindBy (className = "form-group"),
            @FindBy (css = "input.form-control[name='name']")
    })
    public WebElement name;

    @FindBys({
            @FindBy (className = "form-group"),
            @FindBy (css = "input.form-control[name='name']")
    })
    public List<WebElement> nameList;

    @FindBy(id = "suite_mode_single")
    public WebElement suiteModeSingle;

    @FindBys({
        @FindBy(className = "radio"),
        @FindBy(css = "input[value='1']")
    })
    public List<WebElement> suiteModeSingleList;

    @FindBy(id = "suite_mode_single_baseline")
    public WebElement suiteModeSingleBaseline;

    @FindBy(id = "suite_mode_multi")
    public WebElement suiteModeMulti;

/*
    protected By addProjectButtonSelector = By.id("accept");
    protected By nameSelector = By.id("name");
    protected By suiteModeSingleSelector = By.id("suite_mode_single");
    protected By suiteModeSingleBaselineSelector = By.id("suite_mode_single_baseline");
    protected By suiteModeMultiSelector = By.id("suite_mode_multi");
*/

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return new UIElement(browsersService, By.id("accept")).isDisplayed();
    }

/*
    public UIElement getAddProjectButton() {
        return new UIElement(browsersService, addProjectButtonSelector);
    }

    public UIElement getNameField() {
        return new UIElement(browsersService, nameSelector);
    }

    public UIElement getSuiteModeSingleOption() {
        return new UIElement(browsersService, suiteModeSingleSelector);
    }

    public UIElement getSuiteModeSingleBaselineOption() {
        return new UIElement(browsersService, suiteModeSingleBaselineSelector);
    }

    public UIElement getSuiteModeMultiSelectorOption()  {
        return new UIElement(browsersService, suiteModeMultiSelector);
    }
*/


}
