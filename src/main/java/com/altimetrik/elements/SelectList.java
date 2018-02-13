package com.altimetrik.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectList extends Element {

    SelectList(WebElement underlyingElement) {
        super(underlyingElement);
    }

    public void selectByVisibleText(String text) {
        constructSelectElement().selectByVisibleText(text);
    }

    public void deselectByVisibleText(String text) {
        constructSelectElement().deselectByVisibleText(text);
    }

    public void selectByValue(String value) {
        constructSelectElement().selectByValue(value);
    }

    public void deselectByValue(String value) {
        constructSelectElement().deselectByValue(value);
    }

    public void selectByIndex(int index) {
        constructSelectElement().selectByIndex(index);
    }

    public void deselectByIndex(int index) {
        constructSelectElement().deselectByIndex(index);
    }

    public void selectAllOptions() {
        for (WebElement option: constructSelectElement().getOptions()) {
            if (!option.isSelected()) {
                option.click();
            }
        }
    }

    public void deselectAllOptions() {
        constructSelectElement().deselectAll();
    }

    public List<WebElement> allOptions() {
        return constructSelectElement().getOptions();
    }

    public String getTextOfSelectedOption() {
        WebElement element = selectedOption();
        if (element == null) {
            return "";
        }
        return element.getText();
    }

    public String getValueOfSelectedOption() {
        WebElement element = selectedOption();
        if (element == null) {
            return "";
        }
        return element.getAttribute("value");
    }

    private Select constructSelectElement() {
        return new Select(getUnderlyingElement());
    }

    private WebElement selectedOption() {
        for (WebElement option : constructSelectElement().getOptions()) {
            if (option.isSelected()) {
                return option;
            }
        }
        return null;
    }
}
