package com.luxurypresence.pageobjects.customers.jademills;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JadeMillsMLSSearchPageObject extends BasePageObject {

    By searchModal = By.id("modal-search");

    public JadeMillsMLSSearchPageObject(WebDriver driver) {
        super(driver);
        waitUntilElementNotVisible(driver.findElement(searchModal));
        if (!driver.findElement(searchModal).isDisplayed()) {
            throw new IllegalStateException("This is not the properties Jade Mills page");
        }
    }
}
