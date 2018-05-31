package com.luxurypresence.tests.customers.jademills;

import com.luxurypresence.pageobjects.customers.jademills.JadeMillsMLSSearchPageObject;
import com.luxurypresence.pageobjects.customers.jademills.JadeMillsMainPageObject;
import com.luxurypresence.tests.GalenTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class JadeMillsMLSSearchTest extends GalenTestBase {

    protected JadeMillsMainPageObject jadeMillsMainPageObject;
    protected JadeMillsMLSSearchPageObject jadeMillsMLSSearchPageObject;

    @Test(dataProvider = "devices")
    public void mainPage_imageComparison_onDevice(TestDevice device) throws IOException {
        load(customersUrl.JADE_MILLS_URL);
        this.jadeMillsMainPageObject = new JadeMillsMainPageObject(getDriver());
        jadeMillsMainPageObject.removeBackgroundVideo();
        jadeMillsMainPageObject.removeLocationIframe();
        jadeMillsMainPageObject.removeMovingItems();
        jadeMillsMLSSearchPageObject = jadeMillsMainPageObject.clickMLSSearchHeaderButton();
        checkLayout("/specs/customers/jademills/mLSSearch/MLSSearchPageImage.spec", device.getTags());
    }
}
