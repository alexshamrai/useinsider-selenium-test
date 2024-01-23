package com.useinsider.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CareersPageAsserts {

    private static final String CAREERS_PAGE_URL = "https://useinsider.com/careers/";
    private static final Set<String> EXPECTED_LOCATIONS = Set.of("New York\nUS", "Sao Paulo\nBrazil", "London\nUnited Kingdom");
    private static final int EXPECTED_LOCATIONS_AMOUNT = 28;
    private static final By LOCATIONS_SECTION = By.id("career-our-location");
    private static final By TEAMS_SECTION = By.id("career-find-our-calling");
    private static final By LIFE_AT_INSIDER_SECTION = By.xpath("//section[.//h2[text()='Life at Insider']]");
    private static final By LOCATION_INFO = By.cssSelector(".location-info");

    private final WebDriver driver;

    public CareersPageAsserts(WebDriver driver) {
        this.driver = driver;
    }

    public CareersPageAsserts hasCorectUrl() {
        var currentUrl = driver.getCurrentUrl();
        assertEquals(CAREERS_PAGE_URL, currentUrl);
        return this;
    }

    public CareersPageAsserts hasCorrectLocations() {
        var locationsSection = driver.findElement(LOCATIONS_SECTION);
        assertTrue(locationsSection.isDisplayed(), "Locations section is not displayed");

        var locationInfos = driver.findElements(LOCATION_INFO);
        assertEquals(EXPECTED_LOCATIONS_AMOUNT, locationInfos.size());
        var actualLocations = locationInfos.stream()
                .map(WebElement::getText)
                .toList();
        assertTrue(actualLocations.containsAll(EXPECTED_LOCATIONS),
                "Not all expected locations are present in the list. Actual locations:" + actualLocations);
        return this;
    }

    public CareersPageAsserts teamsBlockIsOpen() {
        var locationsSection = driver.findElement(TEAMS_SECTION);
        assertTrue(locationsSection.isDisplayed(), "Teams section is not displayed");
        return this;
    }

    public CareersPageAsserts lifeAtInsiderBlockIsOpen() {
        var locationsSection = driver.findElement(LIFE_AT_INSIDER_SECTION);
        assertTrue(locationsSection.isDisplayed(), "Life at insider section is not displayed");
        return this;
    }
}
