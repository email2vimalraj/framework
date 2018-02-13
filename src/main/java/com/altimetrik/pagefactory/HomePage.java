package com.altimetrik.pagefactory;

import com.altimetrik.internals.CustomFieldDecorator;
import com.altimetrik.internals.Label;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//h1[@class='heading']")
    private Label heading;

    public HomePage(RemoteWebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public String getHeadingText() {
        return heading.getText();
    }
}
