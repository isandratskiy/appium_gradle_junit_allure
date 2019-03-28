package io.github.isandratskiy.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.wrappers.WaitCondition;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.github.isandratskiy.core.wrappers.WaitCondition.*;

public abstract class BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final Dimension size;

    BaseScreen(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.size = driver.manage().window().getSize();
    }

    private TouchAction getTouchAction() {
        return new TouchAction(driver);
    }

    //wait for element condition
    public WebElement waitFor(WaitCondition condition, By locator) {
        try {
            return wait.until(condition.getType().apply(locator));
        } catch (TimeoutException ex) {
            throw new TimeoutException("[WebDriverWait] : " + ex.getMessage());
        }
    }

    //click by locator
    public BaseScreen click(final By locator) {
        waitFor(present, locator).click();
        return this;
    }

    //type text value
    public BaseScreen type(final By locator, final CharSequence text) {
        waitFor(present, locator).sendKeys(text);
        return this;
    }

    //get text value
    public String textValue(final By locator) {
        return waitFor(present, locator).getText();
    }

    //tap action by locator
    public BaseScreen tap(final By locator) {
        getTouchAction()
                .tap(tapOptions().withElement(element(waitFor(present, locator))))
                .perform();
        return this;
    }

    //tap action by position with waiter
    public BaseScreen tapByElementPosition(final By locator, final Duration duration) {
        val element = waitFor(present, locator);
        val position = element.getLocation();
        getTouchAction()
                .waitAction(waitOptions(duration))
                .tap(point(position.x, position.y))
                .perform();
        return this;
    }

    //waiter for tap actions chain
    public BaseScreen suspend(final Duration duration) {
        getTouchAction()
                .waitAction(waitOptions((duration)))
                .perform();
        return this;
    }

    //scroll down view
    public BaseScreen scrollDown(final Duration duration) {
        int width = (int) (size.width * 0.50);
        int start = (int) (size.getHeight() * 0.80);
        int end = (int) (size.getHeight() * 0.30);
        getTouchAction()
                .press(point(width, start))
                .waitAction(waitOptions(duration))
                .moveTo(point(width, end))
                .release()
                .perform();
        return this;
    }

    //move from element to needed element
    public BaseScreen moveTo(final By source, final By destination) {
        getTouchAction()
                .longPress(longPressOptions()
                .withElement(element(waitFor(present, source))))
                .moveTo(element((waitFor(present, destination))))
                .release()
                .perform();
        return this;
    }
}