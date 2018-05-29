package com.luxurypresence.pageobjects.customers.luxurypresence;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDesignPageObject extends BasePageObject {

    private final WebDriver driver;

    HeaderPageObject headerPageObject;

    //Buttons
    By viewOurPortfolioButton = By.xpath("(//*[contains(@class,'tatsu-module tatsu-button-wrap  ')]/a)[1]");

    public WebDesignPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerPageObject = new HeaderPageObject(driver);
        if (!"Luxury Real Estate Website Design by Luxury Presence".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Website Design by Luxury Presence page");
        }
    }

    public void clickViewOurPortfolioButton(){
        driver.findElement(viewOurPortfolioButton).click();
    }
}