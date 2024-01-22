package com.useinsider;

import com.useinsider.pages.MainPage;
import com.useinsider.pages.QualityAssurancePage;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class UseInsiderTest extends BaseTest {

    @Test
    void testCareerIstanbulQaScenario() {

        var mainPage = new MainPage(driver);
        mainPage.open()
                .isLoaded()
                .acceptAllCookies();
        mainPage.assertThat()
                .hasCorrectInfo();

        var menuBar = new MenuBar(driver);
        var careersPage = menuBar.selectCompany()
                .selectCareers();
        careersPage.assertThat()
                .hasCorectUrl()
                .hasCorrectLocations()
                .teamsBlockIsOpen()
                .lifeAtInsiderBlockIsOpen();

        var qualityAssurancePage = new QualityAssurancePage(driver);
        qualityAssurancePage.open()
                .clickOnSeeAllQaJobsButton()
                .isLoaded()
                .filterJobsByIstanbulLocation()
                .filterByQualityAssuranceDepartment()
                .scrollToTheSearchResults()
                .waitForPositionsInfoIsUpdated();
        qualityAssurancePage.assertThat()
                .allJobsPositionContains(Set.of("Quality Assurance", "QA", "Tester"))
                .departmentContains("Quality Assurance")
                .locationContains("Istanbul, Turkey");

        qualityAssurancePage
                .clickViewRoleButton()
                .assertThat()
                .viewRoleRedirectedToLeverApplicationForm();
    }

}