package com.useinsider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuBar {

    private static final By COMPANY_MENU_ITEM = By.linkText("Company");
    private static final By CAREERS_MENU_SUB_ITEM = By.linkText("Careers");

    private final WebDriver driver;

    public MenuBar(WebDriver driver) {
        this.driver = driver;
    }

    public MenuBar selectCompany() {
        var companyMenu = driver.findElement(COMPANY_MENU_ITEM);
        companyMenu.click();
        return new MenuBar(driver);
    }

    public MenuBar selectCareers() {
        var careersLink = driver.findElement(CAREERS_MENU_SUB_ITEM);
        careersLink.click();
        return new MenuBar(driver);
    }
}
