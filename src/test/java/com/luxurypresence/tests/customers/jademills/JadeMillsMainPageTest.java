package com.luxurypresence.tests.customers.jademills;

import com.luxurypresence.pageobjects.customers.jademills.JadeMillsMainPageObject;
import com.luxurypresence.pageobjects.customers.luxurypresence.MainPageObject;
import com.luxurypresence.tests.GalenTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class JadeMillsMainPageTest extends GalenTestBase {

    private final String URL = "https://www.jademillsestates.com/";

    protected JadeMillsMainPageObject jadeMillsMainPageObject;

    @Test(dataProvider = "devices")
    public void mainPage_imageComparison_onDevice(TestDevice device) throws IOException {
        load(URL);
        this.jadeMillsMainPageObject = new JadeMillsMainPageObject(getDriver());
        jadeMillsMainPageObject.removeBackgroundVideo();
        jadeMillsMainPageObject.removeLocationIframe();
        jadeMillsMainPageObject.removeMovingItems();
        checkLayout("/specs/customers/jademills/mainPage/mainPageImageSpec.spec", device.getTags());
    }

}
