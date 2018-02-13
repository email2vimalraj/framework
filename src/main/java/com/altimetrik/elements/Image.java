package com.altimetrik.elements;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class Image extends Element {

    public Image(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public Dimension getSize() {
        return getUnderlyingElement().getSize();
    }
}
