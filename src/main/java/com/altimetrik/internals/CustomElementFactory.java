package com.altimetrik.internals;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class CustomElementFactory implements ElementFactory {
    @Override
    public <E extends Element> E create(Class<E> clazz, WebElement wrappedElement) {
        E element;
        try {
            element = findImplementingClass(clazz)
                        .getDeclaredConstructor(WebElement.class)
                        .newInstance(wrappedElement);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return element;
    }

    private <E extends Element> Class<? extends E> findImplementingClass(final Class<E> elementClass) {
        String pack = elementClass.getPackage().getName();
        String className = elementClass.getSimpleName();
        String extendedClassName = pack + "." + className;
        try {
            return (Class<? extends  E>)Class.forName(extendedClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load class for " + extendedClassName, e);
        }
    }
}
