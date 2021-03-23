package org.techmeskills.auf.tests;

import org.techmeskills.auf.baseEntity.BaseTest;
import org.techmeskills.auf.steps.LoginStep;
import org.techmeskills.auf.steps.ProjectStep;
import org.testng.annotations.Test;

public class SmokeTest2 extends BaseTest {
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR02", "Use a single repository with baseline support");
    }
}
