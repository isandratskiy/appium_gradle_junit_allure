package io.github.isandratskiy.core.wrappers;

import org.openqa.selenium.By;

public interface Condition {
    boolean check(By by);
}
