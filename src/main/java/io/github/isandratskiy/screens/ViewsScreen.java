package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.MobileAction;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewsScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final MobileAction action;

    ViewsScreen(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.action = new MobileAction(driver, wait);
    }
}
