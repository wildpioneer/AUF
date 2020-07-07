package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class DashboardPage extends BasePage {
    protected By PAGEOPENEDIDENTIFIER = By.id("activityChart");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashboardPage(BrowsersService browsersService) {
        super(browsersService);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGEOPENEDIDENTIFIER);
    }

    public UIElement getAddProjectButton() {
        return new UIElement(driver, addProjectButtonSelector);
    }

}
