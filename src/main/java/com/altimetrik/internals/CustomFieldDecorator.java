package com.altimetrik.internals;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    private ElementFactory elementFactory = new CustomElementFactory();

    public CustomFieldDecorator(SearchContext context) {
        super(new DefaultElementLocatorFactory(context));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        WebElement wrappedElement = proxyForLocator(loader, locator);
        if (Element.class.isAssignableFrom(field.getType())) {
            return decorateElement(field, wrappedElement);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final Field field, final WebElement wrappedElement) {
        return elementFactory.create((Class<? extends Element>)field.getType(), wrappedElement);
    }
}
