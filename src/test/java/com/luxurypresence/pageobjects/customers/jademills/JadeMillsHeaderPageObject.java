package com.luxurypresence.pageobjects.customers.jademills;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JadeMillsHeaderPageObject extends BasePageObject {
    private final By header = By.xpath("//*[@class='navbar-header']");

    //Buttons
    private final By ourPropertiesButton = By.xpath(".//a[contains(text(),'Our Properties')]");
    private final By MLSSearchButton = By.xpath(".//a[contains(text(),'MLS Search')]");
    private final By contactButton = By.xpath(".//a[contains(text(),'Contact')]");
    private final By menuButton = By.xpath(".//a[contains(text(),'Menu')]");


    public JadeMillsHeaderPageObject(WebDriver driver) {
        super(driver);
        if (!driver.findElement(header).isDisplayed()) {
            throw new IllegalStateException("Header absent on Jade Mills page");
        }
    }

    public void clickOurPropertiesButton(){
        getDriver().findElement(header).findElement(ourPropertiesButton).click();
    }

    public void clickMLSSearchButton(){
        getDriver().findElement(header).findElement(MLSSearchButton).click();
    }

    public void clickContactButton(){
        getDriver().findElement(header).findElement(contactButton).click();
    }

    public void clickMenuButton(){
        getDriver().findElement(header).findElement(menuButton).click();
    }




}
