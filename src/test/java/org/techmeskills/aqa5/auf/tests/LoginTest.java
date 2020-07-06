package org.techmeskills.aqa5.auf.tests;

import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.login("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }
}
