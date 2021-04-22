package org.techmeskills.aqa5.auf.tests;

import io.qameta.allure.*;
import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.techmeskills.aqa5.auf.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import java.util.Random;

public class SmokeTest1 extends BaseTest {

    @Epic("Smoke Test Epic")
    @Feature("Feature 1")
    @Story("Story 1")
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Epic("Smoke Test Epic")
    @Feature("Feature 2")
    @Story("Story 2")
    @Test(dependsOnMethods = "login", description = "Project Creation Test")
    @Description("Additional information for creation test")
    @Link(name = "Test Lisk", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR01", "Use a single repository for all cases (recommended)");

        Assert.assertTrue(false);
    }


    //@Test (retryAnalyzer = Retry.class)
    @Test
    @Flaky
    public void flakyTest() {
        Assert.assertTrue(new Random().nextBoolean());
    }
}
