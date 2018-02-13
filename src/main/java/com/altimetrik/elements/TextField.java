package com.altimetrik.elements;

import org.openqa.selenium.WebElement;

public class TextField extends Element {

    TextField(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public boolean canType() {
        return getUnderlyingElement().isEnabled();
    }

    public void sendKeys(String text) {
        getUnderlyingElement().sendKeys(text);
    }

    public void clear() {
        getUnderlyingElement().clear();
    }

    public String getText() {
        String text = getUnderlyingElement().getText();
        if (text.isEmpty()) {
            text = getUnderlyingElement().getAttribute("value");
        }
        return text;
    }
}
