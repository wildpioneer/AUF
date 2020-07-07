package org.techmeskills.aqa5.auf.tests;

import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.testng.annotations.Test;

public class SmokeTest1 extends BaseTest {
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR01", "Use a single repository for all cases (recommended)");
    }
}
