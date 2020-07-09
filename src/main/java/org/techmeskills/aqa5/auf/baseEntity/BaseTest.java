package org.techmeskills.aqa5.auf.baseEntity;

import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.models.User;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    public ReadProperties properties;
    public User user;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        browsersService.getDriver().get(properties.getURL());
        user = new User.Builder()
                .withUsername("atrostyanko+master@gmail.com")
                .withName("Alex")
                .withPassword("QqtRK9elseEfAk6ilYcJ")
                .withAge(42)
                .build();
/*
        User user = new User("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        new User("ddd", null)
*/
    }

    @AfterClass
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}