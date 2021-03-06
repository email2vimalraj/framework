package com.altimetrik.internals;

import com.altimetrik.elements.Element;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> clazz, WebElement wrappedElement);
}
