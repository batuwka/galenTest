package com.luxurypresence.tests.customers.jademills;

import com.luxurypresence.pageobjects.customers.jademills.JadeMillsMainPageObject;
import com.luxurypresence.pageobjects.customers.jademills.JadeMillsPropertiesPageObject;
import com.luxurypresence.tests.GalenTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class JadeMillsPropertiesPageTest extends GalenTestBase {

    protected JadeMillsMainPageObject jadeMillsMainPageObject;
    protected JadeMillsPropertiesPageObject jadeMillsPropertiesPageObject;

    @Test(dataProvider = "devices")
    public void mainPage_imageComparison_onDevice(TestDevice device) throws IOException {
        load(customersUrl.JADE_MILLS_URL);
        this.jadeMillsMainPageObject = new JadeMillsMainPageObject(getDriver());
        jadeMillsMainPageObject.removeBackgroundVideo();
        jadeMillsMainPageObject.removeLocationIframe();
        jadeMillsMainPageObject.removeMovingItems();
        jadeMillsPropertiesPageObject = jadeMillsMainPageObject.clickOurPropertiesHeaderButton();
        checkLayout("/specs/customers/jademills/propertiesPage/propertiesPageImage.spec", device.getTags());
    }
}
