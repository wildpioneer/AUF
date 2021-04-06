package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class LoginPage extends BasePage {
    protected final static By emailSelector = By.id("name");
    protected final static By passwordSelector = By.id("password");
    protected final static By loginSelector = By.id("button_primary");

    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {
        driver.get(browsersService.getBaseUrl());
    }

    @Override
    public boolean isPageOpened() {
        return getLoginButton().isDisplayed();
    }

    public UIElement getEmailField() {
        return new UIElement(browsersService, emailSelector);
    }

    public UIElement getPasswordField() {
        return new UIElement(browsersService, passwordSelector);
    }

    public UIElement getLoginButton() {
        return new UIElement(browsersService, loginSelector);
    }
}
