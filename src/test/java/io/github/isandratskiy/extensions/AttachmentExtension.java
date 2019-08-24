package io.github.isandratskiy.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static io.github.isandratskiy.utils.AttachmentUtils.takeScreenshot;

public class AttachmentExtension implements TestWatcher {
    public AttachmentExtension() {
        throw new UnsupportedOperationException("Illegal access to constructor.");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshot();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot();
    }
}
