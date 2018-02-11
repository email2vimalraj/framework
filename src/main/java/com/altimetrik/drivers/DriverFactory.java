package com.altimetrik.drivers;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static RemoteWebDriver createInstance(String browserName) {
        RemoteWebDriver driver = null;

        if (browserName.toUpperCase().equals(Browser.CHROME.toString())) {
            driver = new ChromeDriver();
            return driver;
        }
        if (browserName.toUpperCase().equals(Browser.FIREFOX.toString())) {
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.toUpperCase().equals(Browser.SAFARI.toString())) {
            driver = new SafariDriver();
            return driver;
        }
        if (browserName.toUpperCase().equals(Browser.IE.toString())) {
            driver = new InternetExplorerDriver();
            return driver;
        }
        if (browserName.toUpperCase().equals(Browser.JBROWSERDRIVER.toString())) {
            driver = new JBrowserDriver();
            return driver;
        }
        return driver;
    }
}
