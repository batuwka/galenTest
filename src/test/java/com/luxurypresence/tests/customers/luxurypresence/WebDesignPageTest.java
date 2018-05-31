package com.luxurypresence.tests.customers.luxurypresence;

import com.luxurypresence.pageobjects.customers.luxurypresence.MainPageObject;
import com.luxurypresence.pageobjects.customers.luxurypresence.WebDesignPageObject;
import com.luxurypresence.tests.GalenTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebDesignPageTest extends GalenTestBase {
    protected MainPageObject mainPageObject;
    protected WebDesignPageObject webDesignPageObject;

    @Test(dataProvider = "devices")
    public void mainPage_imageComparison_onDevice(TestDevice device) throws IOException {
        load(customersUrl.LUXURY_PRESENCE_URL);
        this.mainPageObject = new MainPageObject(getDriver());
        webDesignPageObject = mainPageObject.clickWebDesignButton();
        webDesignPageObject.removeSupportIframe();
        checkLayout("/specs/customers/luxurypresence/webDesignPage/webDesignPage.spec", device.getTags());
    }
}
