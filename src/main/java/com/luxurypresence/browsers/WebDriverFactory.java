package com.luxurypresence.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    protected static WebDriver driver;

    public WebDriverFactory() {
    }

    private void setupSystemDrivers() {
        switch (System.getProperty("system")) {
            case "win":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win.exe");
                break;
            case "mac":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_mac");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win");
        }
    }

    public WebDriver getDriverByType(String type){
        setupSystemDrivers();
        switch (type) {
            case "chrome":
                this.driver = new ChromeDriver();
                return driver;
            default:
                this.driver = new ChromeDriver();
                return driver;
        }
    }
}
