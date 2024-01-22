package com.useinsider.pages;

import com.useinsider.asserts.QualityAssuransePageAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private static final By POSITION_ITEM = By.className("position-list-item");
    private static final String DATA_ANIMATED_ATTRIBUTE = "data-animated";

    private final WebDriver driver;
    private final WebDriverWait wait;

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    public QualityAssurancePage open() {
        driver.get(BASE_URL + QUALITY_ASSURANCE_PAGE_PATH);
        return this;
    }

    public QualityAssurancePage clickOnSeeAllQaJobsButton() {
        var seeAllQAJobsButton = wait.until(ExpectedConditions.elementToBeClickable(ALL_QA_JOBS_BUTTON));
        seeAllQAJobsButton.click();
        return this;
    }

    public QualityAssurancePage filterJobsByIstanbulLocation() {
        var locationFilter = driver.findElement(LOCATOR_FILTER);
        locationFilter.click();
        var istanbulOption = driver.findElement(ISTANBUL_OPTION);
        istanbulOption.click();
        return this;
    }

    public QualityAssurancePage filterByQualityAssuranceDepartment() {
        var departmentFilter = driver.findElement(DEPARTMENT_FILTER);
        departmentFilter.click();
        var qaDepartment = driver.findElement(QA_OPTION);
        qaDepartment.click();
        return this;
    }

    public QualityAssurancePage isLoaded() {
        waitForLoading(driver);
        return this;
    }

    public QualityAssurancePage scrollToTheSearchResults() {
        var element = driver.findElement(RESULT_COUNTER);
        var javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(POSITION_LIST_WRAPPER));
        return this;
    }

    public QualityAssurancePage clickViewRoleButton() {
        var viewRoleButton = driver.findElement(VIEW_ROLE_BUTTON);
        viewRoleButton.click();
        return this;
    }

    public QualityAssuransePageAsserts assertThat() {
        return new QualityAssuransePageAsserts(driver);
    }

    public void waitForPositionsInfoIsUpdated() {
        // TODO Investigate why "data-animated" is not stable
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(driver -> {
            WebElement element = driver.findElement(POSITION_ITEM);
            String animated = element.getAttribute(DATA_ANIMATED_ATTRIBUTE);
            return animated != null && animated.equals("true");
        });
    }

}
