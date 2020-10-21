package tests;

import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.testng.annotations.Test;
import steps.ProjectStep;

public class SmokeTest2 extends BaseTest {
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+aqa07@gmail.com", "w3n1bU7F4rxOfnfvrBJL");
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR02", "Use a single repository with baseline support");
    }
}
