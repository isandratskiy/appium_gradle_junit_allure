package io.github.isandratskiy.core.actions;

import org.openqa.selenium.By;

import java.time.Duration;

public interface Scrollable {

    //scroll down view
    void scrollDown(final Duration duration);

    //move from element to needed element
    void moveTo(final By source, final By destination);
}
