package com.luxurypresence.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    protected static WebDriver driver;

    public WebDriverFactory() {
    }

    private void setupSystemDrivers(){
        System.setProperty("webdriver.chrome.driver", "D:\\tat\\chromedriver_win32\\chromedriver.exe");
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
