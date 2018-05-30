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


    public MainPageObject(WebDriver driver) {
        super(driver);
        headerPageObject = new HeaderPageObject(driver);
        if (!"Luxury Presence - Award-Winning Real Estate Websites & Marketing".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the main Luxury Presence page");
        }
    }

    public void clickWebDesignMenuButton(){
        headerPageObject.clickWebDesignButton();
    }

    public WebDesignPageObject clickWebDesignButton(){
        getDriver().findElement(webDesignButton).click();
        return new WebDesignPageObject(getDriver());
    }

    public void clickCloseSupportWidgetButton(){
        waitUntilElementNotVisible(getDriver().findElement(supportIframe));
        getDriver().switchTo().frame(getDriver().findElement(supportIframe));
        waitUntilElementNotVisible(getDriver().findElement(supportWidgetButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(supportWidgetButton).click();
        getDriver().switchTo().defaultContent();
    }

    public WebElement getSupportIframeElement (){
        return getDriver().findElement(supportIframe);
    }

    public void removeSupportIframe(){
        waitUntilElementNotVisible(getDriver().findElement(supportIframe));
        removeElementFromDom(iFrameRemoveJavaScript);
    }
}
