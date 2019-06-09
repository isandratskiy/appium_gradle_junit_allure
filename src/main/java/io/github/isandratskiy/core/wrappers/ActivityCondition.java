package io.github.isandratskiy.core.wrappers;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;

import static io.github.isandratskiy.core.driver.AppiumDriverProvider.*;

public final class ActivityCondition {

    public ActivityCondition() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    @Step("Activity: {activity} is opened")
    public static boolean activityIsPresent(final String activity) {
        try {
            return getDriverWait().until(state ->
                    getDriver().currentActivity().equalsIgnoreCase(activity));
        } catch (Exception ex) {
            throw new TimeoutException("[Wait] Activity is not present", ex);
        }
    }
}