package io.github.isandratskiy.core.wrappers;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public final class ElementCondition {

    public ElementCondition() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    @Step("Element is present :: {locator} ")
    public static boolean isPresentElement(final AndroidDriver driver, final By locator) {
        Condition ele = element -> driver.findElements(locator).size() > 0;
        return ele.check(locator);
    }
}