package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    protected By PAGEOPENEDIDENTIFIER = By.id("button_primary");

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailSelector);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordSelector);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginSelector);
    }
}
