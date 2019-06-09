package io.github.isandratskiy.core.wrappers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.github.isandratskiy.core.driver.AppiumDriverProvider.*;

public final class ElementCondition {

    public ElementCondition() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    @Step("Element is present :: {locator} ")
    public static boolean isPresentElement(final By locator) {
        Condition ele = element -> getDriver().findElements(locator).size() > 0;
        return ele.check(locator);
    }
}
