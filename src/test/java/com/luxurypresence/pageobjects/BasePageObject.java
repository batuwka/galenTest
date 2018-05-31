package com.luxurypresence.pageobjects;

import com.luxurypresence.url.CustomersUrl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePageObject {

    private final WebDriver driver;

    private final Wait<WebDriver> wait;

    protected String iFrameRemoveJavaScript = "document.getElementsByTagName('iframe')[0].remove();";
    protected String removeBackgroundVideoJavaScript = "document.getElementsByTagName('video')[0].remove();";

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilElementNotVisible(element);
    }

    protected void removeElementFromDom(String javaScript){
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    protected void setElementAttributeByTagName(String tagName, String attr, String val){
        ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('" + tagName + "').setAttribute('" + attr + "', '" + val + "'));");
    }

    protected void stopVideoByTagName(String tagName){
        String jscript = "document.getElementsByTagName('" + tagName + "')[0].pause();";
        ((JavascriptExecutor) driver).executeScript(jscript);
    }

    protected void waitUntilElementNotVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebDriver getDriver(){
        return this.driver;
    }
}
