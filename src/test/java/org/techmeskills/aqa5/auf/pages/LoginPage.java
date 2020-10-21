package pages;

import org.openqa.selenium.By;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return driver.findElement(By.id("button_primary")).isDisplayed();
    }

    public UIElement getEmailField() {
        return new UIElement(driver, emailSelector);
    }

    public UIElement getPasswordField() {
        return new UIElement(driver, passwordSelector);
    }

    public UIElement getLoginButton() {
        return new UIElement(driver, loginSelector);
    }
}
