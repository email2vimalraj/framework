package com.altimetrik.elements;

import org.openqa.selenium.WebElement;

public class Checkbox extends Element {
    Checkbox(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public void check() {
        if (!isSelected()) {
            getUnderlyingElement().click();
        }
    }

    public void uncheck() {
        if (isSelected()) {
            getUnderlyingElement().click();
        }
    }

    public boolean isChecked() {
        return isSelected();
    }
}
