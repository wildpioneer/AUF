package org.techmeskills.aqa5.auf.baseEntity;

import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.models.User;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public ReadProperties properties;
    public User user;

    @BeforeTest
    public void openPage() {
        properties = new ReadProperties();
        user = new User.Builder()
                .withUsername("atrostyanko+master@gmail.com")
                .withName("Alex")
                .withPassword("QqtRK9elseEfAk6ilYcJ")
                .withAge(42)
                .build();
    }
}