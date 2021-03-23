package org.techmeskills.auf.pages;

import org.openqa.selenium.By;
import org.techmeskills.auf.baseEntity.BasePage;
import org.techmeskills.auf.core.BrowsersService;
import org.techmeskills.auf.elements.UIElement;

public class LoginPage extends BasePage {
    protected By PAGEOPENEDIDENTIFIER = By.id("button_primary");

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public LoginPage(BrowsersService browsersService) {
        super(browsersService);
    }

    public boolean isPageOpened() {
        return !super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public UIElement getEmailField() {
        return new UIElement(driver, emailSelector);
    }

    public UIElement getPasswordField() {
        return new UIElement(driver, passwordSelector);
    }

    public UIElement getLoginButton() {
        return new UIElement(driver, loginSelector);
    }
}
