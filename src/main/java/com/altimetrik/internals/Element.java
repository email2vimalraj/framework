package com.altimetrik.internals;

import org.openqa.selenium.WebElement;

public class Element {
    private WebElement underlyingElement;

    Element(WebElement underlyingElement) {
        this.underlyingElement = underlyingElement;
    }

    public final WebElement getUnderlyingElement() {
        return underlyingElement;
    }

    public final boolean isEnabled() {
        return getUnderlyingElement().isEnabled();
    }

    public final boolean isDisplayed() {
        return getUnderlyingElement().isDisplayed();
    }

    public final boolean isSelected() {
        return getUnderlyingElement().isSelected();
    }

    public final void click() {
        getUnderlyingElement().click();
    }
}
