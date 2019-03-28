package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class PreferenceScreen extends BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    PreferenceScreen(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Open Headers screen")
    public HeadersScreen openHeaders() {
        tap(AccessibilityId("8. Headers"));
        return new HeadersScreen(driver, wait);
    }
}