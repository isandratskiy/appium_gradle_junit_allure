package io.github.isandratskiy.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class PreferencePage extends BasePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    PreferencePage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    public HeadersPage openHeaders() {
        tap(AccessibilityId("8. Headers"));
        return new HeadersPage(driver, wait);
    }
}