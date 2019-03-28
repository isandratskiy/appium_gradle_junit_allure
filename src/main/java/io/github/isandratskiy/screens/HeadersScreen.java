package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.*;

public class HeadersScreen extends BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public final By PREF_ONE_BUTTON = AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Prefs 1\")");
    public final By PREF_TWO_BUTTON = AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Prefs 2\")");
    public final By INTENT_BUTTON = AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Intent\")");

    public HeadersScreen(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }
}