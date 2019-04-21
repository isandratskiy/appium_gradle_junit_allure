package io.github.isandratskiy.core;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public final class NavigationRouter {

    private static final String APP_PACKAGE = "io.appium.android.apis";

    public NavigationRouter() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    private static Activity getActivity(final String activity) {
        return new Activity(APP_PACKAGE, activity);
    }

    public static void openActivity(final AndroidDriver driver, final String activity) {
        driver.startActivity(getActivity(activity));
    }
}