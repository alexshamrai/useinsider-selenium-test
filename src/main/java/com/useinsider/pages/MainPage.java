package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private static final String MAIN_PAGE_PATH = "/";
    private static final By ACCEPT_ALL_BUTTON = By.id("wt-cli-accept-all-btn");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(BASE_URL + MAIN_PAGE_PATH);
        return new MainPage(driver);
    }

    public MainPage acceptAllCookies() {
        var acceptAllButton = driver.findElement(ACCEPT_ALL_BUTTON);
        acceptAllButton.click();
        return new MainPage(driver);
    }

    public MainPage isLoaded() {
        waitForLoading(driver);
        return new MainPage(driver);
    }
}
