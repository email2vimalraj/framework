package com.altimetrik.elements;

import org.openqa.selenium.WebElement;

public class Label extends Element {

    Label(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public String getText() {
        return getUnderlyingElement().getText();
    }
}
