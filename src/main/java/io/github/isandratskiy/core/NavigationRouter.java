package io.github.isandratskiy.core;

import io.appium.java_client.android.Activity;

import static io.github.isandratskiy.core.driver.AndroidDriverProvider.getDriver;

public final class NavigationRouter {
    private static final String APP_PACKAGE = "io.appium.android.apis";

    public NavigationRouter() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    private static Activity getActivity(final String activity) {
        return new Activity(APP_PACKAGE, activity);
    }

    public static void open(final String activity) {
        getDriver().startActivity(getActivity(activity));
    }
}