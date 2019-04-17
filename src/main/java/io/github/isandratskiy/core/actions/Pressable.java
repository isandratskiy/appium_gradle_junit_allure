package io.github.isandratskiy.core.actions;

import org.openqa.selenium.By;

import java.time.Duration;

public interface Pressable {

    //click by locator
    void click(final By locator);

    //tap action by locator
    void tap(final By locator);

    //tap action by position with waiter
    void tapByElementPosition(final By locator, final Duration duration);
}
