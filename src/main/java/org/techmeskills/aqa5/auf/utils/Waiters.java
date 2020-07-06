package org.techmeskills.aqa5.auf.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waiters(WebDriver driver, int timeOut) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
