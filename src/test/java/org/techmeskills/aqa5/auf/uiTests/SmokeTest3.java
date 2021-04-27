package org.techmeskills.aqa5.auf.uiTests;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.pages.administration.ProjectsPage;
import org.techmeskills.aqa5.auf.steps.AdministrationStep;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest3 extends BaseTest {
    @Test
    public void login() {
        mainLogger.warn("login method started...");

        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        mainLogger.debug("Debug info...");

        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR02", "Use a single repository with baseline support");

        Assert.assertTrue(browsersService.getDriver().getTitle().equalsIgnoreCase("PR02 - TestRail")
                || browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail"));  ;
    }

    @Test(dependsOnMethods = "createProject")
    public void deleteProject() {
        Marker marker = MarkerManager.getMarker("CLASS");
        mainLogger.info(marker, "Info test...");

        AdministrationStep administrationStep = new AdministrationStep(browsersService);
        administrationStep.deleteProject("PR02");

        ProjectsPage projectsPage = new ProjectsPage(browsersService, false);
        Assert.assertEquals(projectsPage.getMessageSuccessText(), "Successfully deleted the project.");
    }
}
