package com.altimetrik.listeners;

import com.altimetrik.annotations.NeedBrowser;
import com.altimetrik.drivers.Browser;
import com.altimetrik.drivers.DriverFactory;
import com.altimetrik.drivers.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class DriverListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ITestNGMethod testMethod = method.getTestMethod();
            Method actualMethod = testMethod.getConstructorOrMethod().getMethod();
            if (testMethod.getXmlTest().getAllParameters().containsKey("browserName")) {
                String browserName = testMethod.getXmlTest().getAllParameters().get("browserName");
                createDriverInstance(browserName);
                return;
            }
            if (actualMethod.isAnnotationPresent(NeedBrowser.class)) {
                NeedBrowser annotation = actualMethod.getAnnotation(NeedBrowser.class);
                String browserName = annotation.name();
                createDriverInstance(browserName);
            }
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ITestNGMethod testMethod = method.getTestMethod();
            Method actualMethod = testMethod.getConstructorOrMethod().getMethod();
            if (actualMethod.isAnnotationPresent(NeedBrowser.class) || testMethod.getXmlTest().getAllParameters().containsKey("browserName")) {
                DriverManager.getDriver().quit();
            }
        }
    }

    private void createDriverInstance(String browserName) {
        if (browserName.equals("")) {
            browserName = Browser.CHROME.toString();
        }
        RemoteWebDriver driver = DriverFactory.createInstance(browserName);
        DriverManager.setDriver(driver);
    }

}
