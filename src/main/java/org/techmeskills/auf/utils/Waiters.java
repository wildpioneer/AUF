package org.techmeskills.auf.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.techmeskills.auf.core.ReadProperties;

public class Waiters {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waiters(WebDriver driver, int timeOut) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
    }

    public Waiters(WebDriver driver) {
        this.driver = driver;
        ReadProperties readProperties = new ReadProperties();
        wait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForInvisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForInvisibility(WebElement webElement, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitForChangeAttribute(By by, String attribute, String attributeValue, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.attributeContains(by, attribute, attributeValue));
    }
}
