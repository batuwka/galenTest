package com.luxurypresence.pageobjects.customers.luxurypresence;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageObject extends BasePageObject {

    HeaderPageObject headerPageObject;

    //Url
    String Url = "http://www.luxurypresence.com/";

    //Iframes
    By supportIframe = By.xpath("//*[@id = 'hubspot-messages-iframe-container']//iframe");
    By supportWidgetButton = By.xpath(".//*[@class='widget']//button");

    //Buttons
    By webDesignButton = By.xpath("//*[@id='page-content']//a[contains(text(),'Web Design')]");

    private final WebDriver driver;

    public MainPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerPageObject = new HeaderPageObject(driver);
        if (!"Luxury Presence - Award-Winning Real Estate Websites & Marketing".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the main Luxury Presence page");
        }
    }

    public void clickWebDesignMenuButton(){
        headerPageObject.clickWebDesignButton();
    }

    public WebDesignPageObject clickWebDesignButton(){
        driver.findElement(webDesignButton).click();
        return new WebDesignPageObject(driver);
    }

    public void clickCloseSupportWidgetButton(){
        waitUntilElementNotVisible(driver.findElement(supportIframe));
        driver.switchTo().frame(driver.findElement(supportIframe));
        waitUntilElementNotVisible(driver.findElement(supportWidgetButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(supportWidgetButton).click();
        driver.switchTo().defaultContent();
    }

    public WebElement getSupportIframeElement (){
        return driver.findElement(supportIframe);
    }

    public void removeSupportIframe(){
        waitUntilElementNotVisible(driver.findElement(supportIframe));
        removeElementFromDom(supportIframeRemoveJavaScript);
    }
}
