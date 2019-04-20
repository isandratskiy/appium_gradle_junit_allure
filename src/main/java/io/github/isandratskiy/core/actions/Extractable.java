package io.github.isandratskiy.core.actions;

import org.openqa.selenium.By;

public interface Extractable {

    //get text value
    String textValue(final By locator);
}
