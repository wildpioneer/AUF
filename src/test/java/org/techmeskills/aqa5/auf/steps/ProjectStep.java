package steps;


import io.qameta.allure.Step;
import org.techmeskills.aqa5.auf.baseEntity.BaseStep;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import pages.AddProjectPage;
import pages.DashboardPage;

public class ProjectStep extends BaseStep {

    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void createNewProject(String name, String type) {
        DashboardPage dashboardPage = new DashboardPage(browsersService, false);
        dashboardPage.getAddProjectButton().click();

        AddProjectPage addProjectPage = new AddProjectPage(browsersService, false);
        addProjectPage.getNameField().sendKeys(name);

        switch (type) {
            case "Use a single repository for all cases (recommended)":
                addProjectPage.getSuiteModeSingleOption().click();
                break;
            case "Use a single repository with baseline support":
                addProjectPage.getSuiteModeSingleBaselineOption().click();
                break;
            case "Use multiple test suites to manage cases":
                addProjectPage.getSuiteModeMultiSelectorOption().click();
                break;
        }

        addProjectPage.getAddProjectButton().submit();
    }
}
