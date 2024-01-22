package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static final String BASE_URL = "https://useinsider.com/";
    protected static final By LANGUAGE_DROPDOWN = By.id("lang-dropdown");
    protected static final int DEFAULT_WAIT_TIMEOUT_MILLS = 2000;

    protected void waitForLoading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(DEFAULT_WAIT_TIMEOUT_MILLS));
        wait.until(ExpectedConditions.elementToBeClickable(LANGUAGE_DROPDOWN));
    }
}
