package io.github.isandratskiy.extensions;

import io.github.isandratskiy.core.driver.AppiumServiceProvider;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AppiumServiceExtension implements BeforeAllCallback, AfterAllCallback {
    private AppiumServiceProvider service;

    public AppiumServiceExtension() {
        this.service = new AppiumServiceProvider();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        service.startService();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        service.stopService();
    }
}