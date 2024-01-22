package com.useinsider;

import com.useinsider.pages.MainPage;
import com.useinsider.pages.QualityAssurancePage;
import org.junit.jupiter.api.Test;

public class UseInsiderTest extends BaseTest {

    @Test
    void testCareerIstanbulQaScenario() {

        var mainPage = new MainPage(driver);
        mainPage.open()
                .isLoaded()
                .acceptAllCookies();
        //TODO Assert home page is opened

        var menuBar = new MenuBar(driver);
        menuBar.selectCompany()
                .selectCareers();
        //TODO  check Career page, its Locations, Teams and Life at Insider blocks are opened or not

        var qualityAssurancePage = new QualityAssurancePage(driver);
        qualityAssurancePage.open()
                .clickOnSeeAllQaJobsButton()
                .isLoaded()
                .filterJobsByIstanbulLocation()
                .filterByQualityAssuranceDepartment()
                .scrollToTheSearchResults();

        // TODO check presence of jobs list. Assertion: Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, Location contains “Istanbul, Turkey”

        qualityAssurancePage
                .clickViewRoleButton();
        //TODO check that action redirects us to Lever Application form page

    }

}