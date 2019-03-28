package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewsScreen extends BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    ViewsScreen(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }
}
