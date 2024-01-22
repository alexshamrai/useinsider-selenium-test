package com.useinsider;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RequiredArgsConstructor
public class MenuBar {

    private final WebDriver driver;

    public MenuBar selectCompany() {
        // Select “Company” menu in navigation bar,
        WebElement companyMenu = driver.findElement(By.linkText("Company"));
        companyMenu.click();

        return new MenuBar(driver);
    }

    public MenuBar selectCareers() {
        WebElement careersLink = driver.findElement(By.linkText("Careers"));
        careersLink.click();
        return new MenuBar(driver);
    }
}
