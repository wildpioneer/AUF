package pages;

import org.openqa.selenium.By;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class DashboardPage extends BasePage {
    private static String ENDPOINT = "/dashboard";

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashboardPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return driver.findElement(By.id("activityChart")).isDisplayed();
    }

    public UIElement getAddProjectButton() {
        return new UIElement(driver, addProjectButtonSelector);
    }

}
