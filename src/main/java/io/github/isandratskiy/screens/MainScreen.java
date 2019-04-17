package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.MobileAction;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.*;

public class MainScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final MobileAction action;

    public final String ACTIVITY = ".ApiDemos";

    public MainScreen(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.action = new MobileAction(driver, wait);
    }

    @Step("Open Preference screen")
    public PreferenceScreen openPreference() {
        action.tap(AccessibilityId("Preference"));
        return new PreferenceScreen(driver, wait);
    }
}