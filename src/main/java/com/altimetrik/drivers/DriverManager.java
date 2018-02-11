package com.altimetrik.drivers;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver rwd) {
        driver.set(rwd);
    }
}
