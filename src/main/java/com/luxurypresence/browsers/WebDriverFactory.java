package com.luxurypresence.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    protected static WebDriver driver;

    public WebDriverFactory() {
    }

    private void setupSystemDrivers() {

        switch (System.getProperty("os.name")) {
            case "Windows 10":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win.exe");
                break;
            case "Windows 8.1":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win.exe");
                break;
                //TODO add Mac names
            case "mac":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_mac");
                break;
                //TODO add Linux names
            case "linux":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win.exe");
        }
    }

    public WebDriver getDriverByType(String type, boolean headless){
        setupSystemDrivers();
        switch (type) {
            case "chrome":
                if (headless) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    this.driver = new ChromeDriver(options);
                    return driver;
                }
                this.driver = new ChromeDriver();
                return driver;
            default:
                if (headless) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    this.driver = new ChromeDriver(options);
                    return driver;
                }
                this.driver = new ChromeDriver();
                return driver;
        }
    }
}
