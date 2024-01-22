package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    private static final String MAIN_PAGE_URL = "https://useinsider.com/";
    private static final By ACCEPT_ALL_BUTTON = By.id("wt-cli-accept-all-btn");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }

    public MainPage open() {
        driver.get(MAIN_PAGE_URL);
        return new MainPage(driver);
    }

    public MainPage acceptAllCookies() {
        var acceptAllButton = driver.findElement(ACCEPT_ALL_BUTTON);
        acceptAllButton.click();
        return new MainPage(driver);
    }

    // TODO move to BasePage
    public MainPage isLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lang-dropdown")));
        return new MainPage(driver);
    }
}
