package com.useinsider.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageAsserts {

    private static final By BUTTON = By.cssSelector(".btn");
    private static final String GET_A_DEMO_BUTTON_TITLE = "Get a Demo";
    private static final String PLATFORM_TOUR_BUTTON_TITLE = "Platform Tour";

    private final WebDriver driver;

    public MainPageAsserts(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageAsserts hasCorrectInfo() {
        var buttons = driver.findElements(BUTTON);

        boolean isGetDemoButtonPresent = buttons.stream().anyMatch(button -> GET_A_DEMO_BUTTON_TITLE.equals(button.getText()));
        assertTrue(isGetDemoButtonPresent, "Get a Demo button is not present");

        boolean isPlatformTourButtonPresent = buttons.stream().anyMatch(button -> PLATFORM_TOUR_BUTTON_TITLE.equals(button.getText()));
        assertTrue(isPlatformTourButtonPresent, "Platform Tour button is not present");
        return this;
    }
}
