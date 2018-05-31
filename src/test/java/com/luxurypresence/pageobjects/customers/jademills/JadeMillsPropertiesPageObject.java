package com.luxurypresence.pageobjects.customers.jademills;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JadeMillsPropertiesPageObject extends BasePageObject {

    By propertiesModal = By.id("modal-properties");

    public JadeMillsPropertiesPageObject(WebDriver driver) {
        super(driver);
        waitUntilElementNotVisible(driver.findElement(propertiesModal));
        if (!driver.findElement(propertiesModal).isDisplayed()) {
            throw new IllegalStateException("This is not the properties Jade Mills page");
        }
    }
}
