package com.useinsider.pages;

import com.useinsider.asserts.CareersPageAsserts;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    private final WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public CareersPageAsserts assertThat() {
        return new CareersPageAsserts(driver);
    }
}
