package io.github.isandratskiy.core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.core.actions.Extractable;
import io.github.isandratskiy.core.actions.Pressable;
import io.github.isandratskiy.core.actions.Scrollable;
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
import static io.github.isandratskiy.core.wrappers.WaitCondition.present;

public class MobileAction implements Pressable, Scrollable, Extractable {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final Dimension size;

    public MobileAction(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.size = driver.manage().window().getSize();
    }

    private TouchAction getTouchAction() {
        return new TouchAction(driver);
    }

    //TODO
    //wait for element condition
    public WebElement waitFor(final WaitCondition condition, final By locator) {
        try {
            return wait.until(condition.getType().apply(locator));
        } catch (TimeoutException ex) {
            throw new TimeoutException("[WebDriverWait] : " + ex.getMessage());
        }
    }

    //TODO
    //type text value
    public MobileAction type(final By locator, final CharSequence text) {
        waitFor(present, locator).sendKeys(text);
        return this;
    }

    //TODO
    //waiter for tap actions chain
    public MobileAction suspend(final Duration duration) {
        getTouchAction()
                .waitAction(waitOptions((duration)))
                .perform();
        return this;
    }

    @Override
    public String textValue(By locator) {
        return waitFor(present, locator).getText();
    }

    @Override
    public void click(By locator) {
        waitFor(present, locator).click();
    }

    @Override
    public void tap(By locator) {
        getTouchAction()
                .tap(tapOptions().withElement(element(waitFor(present, locator))))
                .perform();
    }

    @Override
    public void tapByElementPosition(By locator, Duration duration) {
        val element = waitFor(present, locator);
        val position = element.getLocation();
        getTouchAction()
                .waitAction(waitOptions(duration))
                .tap(point(position.x, position.y))
                .perform();
    }

    @Override
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

    @Override
    public void moveTo(By source, By destination) {
        getTouchAction()
                .longPress(longPressOptions()
                        .withElement(element(waitFor(present, source))))
                .moveTo(element((waitFor(present, destination))))
                .release()
                .perform();
    }
}