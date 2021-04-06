package org.techmeskills.aqa5.auf.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class apiMainTest {

    @Test
    public void simpleApiTest() {
        String baseUrl = "https://reqres.in";
        String endpoint = "/api/users/2";

        RestAssured.baseURI = baseUrl;

        // Setup Request Object
        RequestSpecification httpRequest = RestAssured.given();

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response StatusCode
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Body: " + responseBody);

        // Verify Status Code
        Assert.assertEquals(statusCode, 200, "Invalid status code.");
    }

    @Test
    public void test() {
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

}
