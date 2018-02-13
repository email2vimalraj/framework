package com.altimetrik.pagefactory;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageFactory {
    private static HomePage homePage;

    public static HomePage getHomePage(RemoteWebDriver remoteWebDriver) {
        if (homePage == null) {
            homePage = org.openqa.selenium.support.PageFactory.initElements(remoteWebDriver, HomePage.class);
        }
        return homePage;
    }
}
