package com.luxurypresence.pageobjects.customers.luxurypresence;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPageObject extends BasePageObject {

    //menu ID
    By menuPanel = By.xpath("//*[@id='menu']");
    By mobileMenu = By.xpath("//*[@title='Mobile Menu Controller']");

    //Buttons
    By webDesignButton = By.xpath(".//a[contains(text(),'Web Design')]");

    public HeaderPageObject(WebDriver driver) {
        super(driver);
        if (!driver.findElement(menuPanel).isDisplayed() && !driver.findElement(mobileMenu).isDisplayed()) {
            throw new IllegalStateException("Menu header is absent");
        }
    }

    protected void clickWebDesignButton(){
        getDriver().findElement(menuPanel).findElement(webDesignButton).click();
    }
}
