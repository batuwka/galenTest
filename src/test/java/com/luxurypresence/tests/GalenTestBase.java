package com.luxurypresence.tests;

import com.galenframework.testng.GalenTestNgTestBase;
import com.luxurypresence.browsers.WebDriverFactory;
import com.luxurypresence.url.CustomersUrl;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    public CustomersUrl customersUrl = new CustomersUrl();

    @Override
    public WebDriver createDriver(Object[] args) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.getDriverByType("chrome",true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice)args[0];
                if (device.getScreenSize() != null) {
                    driver.manage().window().setSize(device.getScreenSize());
                }
            }
        }
        return driver;
    }

    public void load(String uri) {
        getDriver().get(uri);
    }

    @DataProvider(name = "devices")
    public Object [][] devices () {
        return new Object[][] {
//                {new TestDevice("mobile", new Dimension(450, 800), asList("mobile"))},
//                {new TestDevice("tablet", new Dimension(750, 800), asList("tablet"))},
                {new TestDevice("desktop", new Dimension(1600, 1200), asList("desktop"))}
        };
    }

    public static class TestDevice {
        private final String name;
        private final Dimension screenSize;
        private final List<String> tags;

        public TestDevice(String name, Dimension screenSize, List<String> tags) {
            this.name = name;
            this.screenSize = screenSize;
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public Dimension getScreenSize() {
            return screenSize;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
        }


    }

}
