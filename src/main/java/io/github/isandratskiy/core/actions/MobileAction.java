package io.github.isandratskiy.core.actions;

import io.appium.java_client.TouchAction;
import io.github.isandratskiy.core.wrappers.WaitCondition;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.github.isandratskiy.core.driver.AndroidDriverProvider.getDriver;
import static io.github.isandratskiy.core.wrappers.WaitCondition.present;

public class MobileAction {
    private final Dimension size;
    private WebDriverWait wait;

    public MobileAction(WebDriverWait wait) {
        this.wait = wait;
        this.size = getDriver().manage().window().getSize();
    }

    //getter for touch instance
    private TouchAction getTouchAction() {
        return new TouchAction(getDriver());
    }

    //wait for element condition
    private WebElement waitFor(final WaitCondition condition, final By locator) {
        try {
            return wait.until(condition.getType().apply(locator));
        } catch (TimeoutException ex) {
            throw new TimeoutException("[WebDriverWait] : " + ex.getMessage());
        }
    }

    //type text value
    public MobileAction type(final By locator, final CharSequence text) {
        waitFor(present, locator).sendKeys(text);
        return this;
    }

    //waiter for tap actions chain
    public MobileAction suspend(final Duration duration) {
        getTouchAction()
                .waitAction(waitOptions((duration)))
                .perform();
        return this;
    }

    public String textValue(By locator) {
        return waitFor(present, locator).getText();
    }

    public void click(By locator) {
        waitFor(present, locator).click();
    }

    public void tap(By locator) {
        getTouchAction()
                .tap(tapOptions().withElement(element(waitFor(present, locator))))
                .perform();
    }

    public void tapByElementPosition(By locator, Duration duration) {
        val element = waitFor(present, locator);
        val position = element.getLocation();
        getTouchAction()
                .waitAction(waitOptions(duration))
                .tap(point(position.x, position.y))
                .perform();
    }

    public void scrollDown(Duration duration) {
        int width = (int) (size.width * 0.50);
        int start = (int) (size.getHeight() * 0.80);
        int end = (int) (size.getHeight() * 0.30);
        getTouchAction()
                .press(point(width, start))
                .waitAction(waitOptions(duration))
                .moveTo(point(width, end))
                .release()
                .perform();
    }

    public void moveTo(By source, By destination) {
        getTouchAction()
                .longPress(longPressOptions()
                        .withElement(element(waitFor(present, source))))
                .moveTo(element((waitFor(present, destination))))
                .release()
                .perform();
    }
}