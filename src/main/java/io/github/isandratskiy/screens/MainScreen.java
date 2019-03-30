package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.*;

public class MainScreen extends BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public final String ACTIVITY = ".ApiDemos";

    public MainScreen(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Open Preference screen")
    public PreferenceScreen openPreference() {
        tap(AccessibilityId("Preference"));
        return new PreferenceScreen(driver, wait);
    }
}