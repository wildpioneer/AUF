package org.techmeskills.aqa5.auf.apiTests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class apiTest4 {

    @Test
    public void getAllUsers() {
        // Setup RestAssured
        given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ")
                .when()
                .get("https://aqa5master.testrail.io/index.php?/api/v2/get_users")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
