package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.MobileAction;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class PreferenceScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final MobileAction action;

    PreferenceScreen(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.action = new MobileAction(driver, wait);
    }

    @Step("Open Headers screen")
    public HeadersScreen openHeaders() {
        action.tap(AccessibilityId("8. Headers"));
        return new HeadersScreen(driver, wait);
    }
}