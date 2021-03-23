package org.techmeskills.auf.tests;

import org.techmeskills.auf.baseEntity.BaseTest;
import org.techmeskills.auf.steps.LoginStep;
import org.techmeskills.auf.steps.ProjectStep;
import org.testng.annotations.Test;

public class SmokeTest1 extends BaseTest {
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR01", "Use a single repository for all cases (recommended)");
    }
}
