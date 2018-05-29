package com.luxurypresence.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePageObject {

    private final WebDriver driver;

    private final Wait<WebDriver> wait;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilElementNotVisible(element);
    }

    protected void waitUntilElementNotVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
