package io.github.isandratskiy.screenobjects.screen;

import io.github.isandratskiy.screenobjects.AbstractScreen;
import io.qameta.allure.Step;

import static io.appium.java_client.MobileBy.*;

public class MainScreen extends AbstractScreen {

    public final String ACTIVITY = ".ApiDemos";

    @Step("Open Preference screen")
    public PreferenceScreen openPreference() {
        action.tap(AccessibilityId("Preference"));
        return new PreferenceScreen();
    }
}
