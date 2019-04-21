package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.MobileAction;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadersScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final MobileAction act;

    public HeadersScreen(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.act = new MobileAction(driver, wait);
    }
}