package com.useinsider.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QualityAssuransePageAsserts {

    private static final By POSITION = By.cssSelector(".position-title");
    private static final By DEPARTMENT = By.cssSelector(".position-department");
    private static final By LOCATION = By.cssSelector(".position-location");
    private static final String LEVER_APPLICATION_FORM_URL = "https://jobs.lever.co";

    private final WebDriver driver;

    public QualityAssuransePageAsserts(WebDriver driver) {
        this.driver = driver;
    }

    public QualityAssuransePageAsserts allJobsPositionContains(Set<String> expectedPositions) {
        var positions = driver.findElements(POSITION).stream()
                .map(WebElement::getText)
                .toList();

        positions.forEach(position -> {
            boolean matches = expectedPositions.stream().anyMatch(position::contains);
            assertTrue(matches, "Position title does not contain any of the expected texts. Actual: " + position);
        });
        return this;
    }

    public QualityAssuransePageAsserts departmentContains(String expectedDepartment) {
        var departments = driver.findElements(DEPARTMENT).stream()
                .map(WebElement::getText)
                .toList();
        departments.forEach(department -> assertTrue(department.contains(expectedDepartment),
                "Department does not contain expected text: " + expectedDepartment + ". Actual: " + department));
        return this;
    }

    public QualityAssuransePageAsserts locationContains(String expectedLocation) {
        var locations = driver.findElements(LOCATION).stream()
                .map(WebElement::getText)
                .toList();
        locations.forEach(location -> assertTrue(location.contains(expectedLocation),
                "Location does not contain expected text: " + expectedLocation + ". Actual: " + location));
        return this;
    }

    public QualityAssuransePageAsserts viewRoleRedirectedToLeverApplicationForm() {
        switchToANewTab();
        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(LEVER_APPLICATION_FORM_URL),
                "Expected URL to contain " + LEVER_APPLICATION_FORM_URL + ", but actual URL was: " + actualURL);
        return this;
    }

    private void switchToANewTab() {
        var browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
    }
}
