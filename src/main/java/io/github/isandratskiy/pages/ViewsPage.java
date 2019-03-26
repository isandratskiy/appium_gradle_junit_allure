package io.github.isandratskiy.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewsPage extends BasePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    ViewsPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }
}
