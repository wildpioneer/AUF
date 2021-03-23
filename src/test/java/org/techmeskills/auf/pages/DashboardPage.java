package org.techmeskills.auf.pages;

import org.openqa.selenium.By;
import org.techmeskills.auf.baseEntity.BasePage;
import org.techmeskills.auf.core.BrowsersService;
import org.techmeskills.auf.elements.UIElement;

public class DashboardPage extends BasePage {
    protected By PAGEOPENEDIDENTIFIER = By.id("activityChart");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashboardPage(BrowsersService browsersService) {
        super(browsersService);
    }

    public boolean isPageOpened() {
        return !super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public UIElement getAddProjectButton() {
        return new UIElement(driver, addProjectButtonSelector);
    }

}
