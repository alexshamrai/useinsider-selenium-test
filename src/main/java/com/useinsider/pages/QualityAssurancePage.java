package com.useinsider.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualityAssurancePage {

    private static final String QUALITY_ASSURANCE_PAGE_URL = "https://useinsider.com/careers/quality-assurance/";
    private static final By ALL_QA_JOBS_BUTTON = By.linkText("See all QA jobs");
    private static final By LOCATOR_FILTER = By.id("select2-filter-by-location-container");
    private static final By ISTANBUL_OPTION = By.xpath("//li[contains(text(), 'Istanbul, Turkey')]");
    private static final By DEPARTMENT_FILTER = By.id("select2-filter-by-department-container");
    private static final By QA_OPTION = By.xpath("//li[contains(text(), 'Quality Assurance')]");
    private static final By VIEW_ROLE_BUTTON = By.xpath("//div[contains(@class, 'position-list-item-wrapper bg-light')]//a[contains(text(), 'View Role')]");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }

    public QualityAssurancePage open() {
        driver.get(QUALITY_ASSURANCE_PAGE_URL);
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage clickOnSeeAllQaJobsButton() {
        WebElement seeAllQAJobsButton = wait.until(ExpectedConditions.elementToBeClickable(ALL_QA_JOBS_BUTTON));
        seeAllQAJobsButton.click();
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage filterJobsByIstanbulLocation() {
        WebElement locationFilter = driver.findElement(LOCATOR_FILTER);
        locationFilter.click();
        WebElement istanbulOption = driver.findElement(ISTANBUL_OPTION);
        istanbulOption.click();
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage filterByQualityAssuranceDepartment() {
        WebElement departmentFilter = driver.findElement(DEPARTMENT_FILTER);
        departmentFilter.click();
        WebElement qaDepartment = driver.findElement(QA_OPTION);
        qaDepartment.click();
        return new QualityAssurancePage(driver);
    }

    // TODO move to BasePage
    public QualityAssurancePage isLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lang-dropdown")));
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage scrollToTheSearchResults() {
        WebElement element = driver.findElement(By.id("resultCounter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".position-list-item-wrapper")));
        return new QualityAssurancePage(driver);
    }

    public void clickViewRoleButton() {
        WebElement viewRoleButton = driver.findElement(VIEW_ROLE_BUTTON);
        viewRoleButton.click();
    }

}
