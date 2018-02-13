package com.altimetrik.elements;

import org.openqa.selenium.WebElement;

public class Form extends Element {

    Form(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public void submit() {
        getUnderlyingElement().submit();
    }
}
