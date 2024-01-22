package com.useinsider;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UseInsiderTest {

    WebDriver driver;

    @Test
    void testCareerIstanbulQaScenario() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));

        driver.get("https://useinsider.com/");
        // Assert home page is opened
        var title = driver.getTitle();
        System.out.println(title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Select “Company” menu in navigation bar,
        WebElement companyMenu = driver.findElement(By.linkText("Company"));
        companyMenu.click();

        // Select “Careers”
        WebElement careersLink = driver.findElement(By.linkText("Careers"));
        careersLink.click();

        // Assertion:  check Career page, its Locations, Teams and Life at Insider blocks are opened or not

        // Go to https://useinsider.com/careers/quality-assurance/,
        driver.get("https://useinsider.com/careers/quality-assurance/");

        // Click on the “See all QA jobs” link/button
        WebElement seeAllQAJobsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See all QA jobs")));
        seeAllQAJobsButton.click();

        //        filter jobs by Location
        WebElement locationFilter = driver.findElement(By.id("select2-filter-by-location-container"));
        locationFilter.click();

        //  - Istanbul, Turkey and department - Quality Assurance, check presence of jobs list
        WebElement istanbul = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-filter-by-location-result-1q1m-Istanbul, Turkey")));
        istanbul.click();

        // Open department dropdown
        WebElement departmentFilter = driver.findElement(By.id("select2-filter-by-department-container"));
        departmentFilter.click();

        // Choose Quality Assurance departemnt
        WebElement qaDepartment = driver.findElement(By.id("select2-filter-by-department-result-gnu9-Quality Assurance"));
        qaDepartment.click();

        // Assertion: Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, Location contains “Istanbul, Turkey”

        //5. Click “View Role” button and check that this action redirects us to Lever
        //Application form page

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    @BeforeEach
    void getToken() {
        driver = new ChromeDriver();
    }
}