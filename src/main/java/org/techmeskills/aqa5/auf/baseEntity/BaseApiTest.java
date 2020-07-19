package org.techmeskills.aqa5.auf.baseEntity;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.models.User;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public ReadProperties properties;
    public User master;
    public User tester;

    @BeforeTest
    public void setup() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getApiUsername(), properties.getApiPassword());

        master = new User.Builder()
                .withName("AQA5 Master")
                .withEmail("atrostyanko+master@gmail.com")
                .withIsActive(true)
                .build();

        tester = new User.Builder()
                .withName("AQA5 Tester")
                .withEmail("atrostyanko+tester@gmail.com")
                .withIsActive(true)
                .build();

        System.out.println("Setup is done.");
    }
}