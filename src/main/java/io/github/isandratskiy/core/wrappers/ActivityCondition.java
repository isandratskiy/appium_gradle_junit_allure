package io.github.isandratskiy.core.wrappers;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ActivityCondition {

    public ActivityCondition() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    @Step("Activity: {activity} is opened")
    public static boolean activityIsPresent(AndroidDriver driver, WebDriverWait wait, String activity) {
        try {
            return wait.until(state ->
                    driver.currentActivity().equalsIgnoreCase(activity));
        } catch (Exception ex) {
            throw new TimeoutException("[Wait] Activity is not present", ex);
        }
    }
}