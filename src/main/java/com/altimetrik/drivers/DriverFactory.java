package com.altimetrik.drivers;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    /**
     * Creates the remote web driver instance with the local browser name
     * @param browserName The local browser name, refer {@link Browser} enum for the list of browsers
     * @return The instance of the {@link RemoteWebDriver}
     */
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

//    public static RemoteWebDriver createInstance(String url, String capFilePath) {
//        RemoteWebDriver driver = null;
//
//        try {
//            URL remoteUrl = new URL(url);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
}
