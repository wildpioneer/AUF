package org.techmeskills.aqa5.auf.baseEntity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.models.User;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public static final Logger logger = LogManager.getLogger(BaseApiTest.class.getName());

    public ReadProperties properties;
    public User master;
    public User tester;

    @BeforeTest
    public void setup() {
        logger.trace("setUp has started");

        properties = new ReadProperties();

        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getApiUsername(), properties.getApiPassword());

        master = User.builder()
                .name("AQA5 Master")
                .email("atrostyanko+master@gmail.com")
                .isActive(true)
                .build();

        tester = User.builder()
                .name("AQA5 Tester")
                .email("atrostyanko+tester@gmail.com")
                .isActive(true)
                .build();

        logger.trace("setUp has done.");
    }
}