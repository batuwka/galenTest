package com.luxurypresence.pageobjects.customers.jademills;

import com.luxurypresence.pageobjects.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JadeMillsMainPageObject extends BasePageObject {

    private JadeMillsHeaderPageObject jadeMillsHeaderPageObject;

    private final String videoTagName = "video";
    private final By backgroundVideo = By.id("bgvid");

    private final By movingItems = By.id("items");
    private final String removeMovingItemsJavaScript = "document.getElementById('items').remove();";

    private final By singleIframe = By.xpath("//iframe");

    public JadeMillsMainPageObject(WebDriver driver) {
        super(driver);
        jadeMillsHeaderPageObject = new JadeMillsHeaderPageObject(driver);
        if (!"Jade Mills: Beverly Hills Real Estate Agent | Luxury Homes | Bel Air Real Estate".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the main Jade Mills page");
        }
    }

    public JadeMillsPropertiesPageObject clickOurPropertiesHeaderButton(){
        jadeMillsHeaderPageObject.clickOurPropertiesButton();
        return new JadeMillsPropertiesPageObject(getDriver());
    }

    public JadeMillsMLSSearchPageObject clickMLSSearchHeaderButton(){
        jadeMillsHeaderPageObject.clickMLSSearchButton();
        return new JadeMillsMLSSearchPageObject(getDriver());
    }

    public void clickContactHeaderButton(){
        jadeMillsHeaderPageObject.clickContactButton();
    }

    public void clickMenuHeaderButton(){
        jadeMillsHeaderPageObject.clickMenuButton();
    }

    public void stopBackgroundVideo(){
        waitUntilElementNotVisible(getDriver().findElement(backgroundVideo));
        stopVideoByTagName(videoTagName);
    }

    public void removeBackgroundVideo(){
        waitUntilElementNotVisible(getDriver().findElement(backgroundVideo));
        removeElementFromDom(removeBackgroundVideoJavaScript);
    }

    public void removeLocationIframe(){
        waitUntilElementNotVisible(getDriver().findElement(singleIframe));
        removeElementFromDom(iFrameRemoveJavaScript);
    }

    public void removeMovingItems(){
        waitUntilElementNotVisible(getDriver().findElement(movingItems));
        removeElementFromDom(removeMovingItemsJavaScript);
    }


}
