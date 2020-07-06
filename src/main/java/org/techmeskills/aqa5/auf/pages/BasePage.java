package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened(By by) {
        return driver.findElement(by).isDisplayed();
    }
}