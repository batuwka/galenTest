package com.luxurypresence.tests.customers.luxurypresence;

import com.luxurypresence.pageobjects.customers.luxurypresence.MainPageObject;
import com.luxurypresence.tests.GalenTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageTest extends GalenTestBase {
    protected MainPageObject mainPageObject;

    @Test(dataProvider = "devices")
    public void mainPage_imageComparison_onDevice(TestDevice device) throws IOException {
        load(customersUrl.LUXURY_PRESENCE_URL);
        this.mainPageObject = new MainPageObject(getDriver());
        mainPageObject.removeSupportIframe();
        checkLayout("/specs/customers/luxurypresence/mainPage/mainPageScreenshot.spec", device.getTags());
    }
}
