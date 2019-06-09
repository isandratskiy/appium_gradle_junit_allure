package io.github.isandratskiy.screenobjects.screen;

import io.github.isandratskiy.screenobjects.AbstractScreen;
import io.qameta.allure.Step;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class PreferenceScreen extends AbstractScreen {

    @Step("Open Headers screen")
    public HeadersScreen openHeaders() {
        action.tap(AccessibilityId("8. Headers"));
        return new HeadersScreen();
    }
}