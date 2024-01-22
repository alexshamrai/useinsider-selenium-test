package com.useinsider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualityAssurancePage extends BasePage {

    private static final String QUALITY_ASSURANCE_PAGE_PATH = "/careers/quality-assurance/";
    private static final By ALL_QA_JOBS_BUTTON = By.linkText("See all QA jobs");
    private static final By LOCATOR_FILTER = By.id("select2-filter-by-location-container");
    private static final By ISTANBUL_OPTION = By.xpath("//li[contains(text(), 'Istanbul, Turkey')]");
    private static final By DEPARTMENT_FILTER = By.id("select2-filter-by-department-container");
    private static final By QA_OPTION = By.xpath("//li[contains(text(), 'Quality Assurance')]");
    private static final By VIEW_ROLE_BUTTON = By.xpath("//div[contains(@class, 'position-list-item-wrapper bg-light')]//a[contains(text(), 'View Role')]");
    private static final By RESULT_COUNTER = By.id("resultCounter");
    private static final By POSITION_LIST_WRAPPER = By.cssSelector(".position-list-item-wrapper");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(DEFAULT_WAIT_TIMEOUT_MILLS));
    }

    public QualityAssurancePage open() {
        driver.get(BASE_URL + QUALITY_ASSURANCE_PAGE_PATH);
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage clickOnSeeAllQaJobsButton() {
        var seeAllQAJobsButton = wait.until(ExpectedConditions.elementToBeClickable(ALL_QA_JOBS_BUTTON));
        seeAllQAJobsButton.click();
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage filterJobsByIstanbulLocation() {
        var locationFilter = driver.findElement(LOCATOR_FILTER);
        locationFilter.click();
        var istanbulOption = driver.findElement(ISTANBUL_OPTION);
        istanbulOption.click();
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage filterByQualityAssuranceDepartment() {
        var departmentFilter = driver.findElement(DEPARTMENT_FILTER);
        departmentFilter.click();
        var qaDepartment = driver.findElement(QA_OPTION);
        qaDepartment.click();
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage isLoaded() {
        waitForLoading(driver);
        return new QualityAssurancePage(driver);
    }

    public QualityAssurancePage scrollToTheSearchResults() {
        var element = driver.findElement(RESULT_COUNTER);
        var javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(POSITION_LIST_WRAPPER));
        return new QualityAssurancePage(driver);
    }

    public void clickViewRoleButton() {
        // TODO get rid of Thread.sleep - currently left for handling default animated delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var viewRoleButton = driver.findElement(VIEW_ROLE_BUTTON);
        viewRoleButton.click();
    }

}
