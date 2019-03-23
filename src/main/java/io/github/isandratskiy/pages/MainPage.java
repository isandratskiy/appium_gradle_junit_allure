package io.github.isandratskiy.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.*;

public class MainPage extends BasePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public MainPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    public PreferencePage openPreference() {
        tap(AccessibilityId("Preference"));
        return new PreferencePage(driver, wait);
    }
}
