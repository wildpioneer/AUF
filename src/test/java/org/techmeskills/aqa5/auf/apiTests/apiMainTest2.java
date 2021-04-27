package org.techmeskills.aqa5.auf.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

public class apiMainTest2 {

    @Test
    public void test() {
        String baseUrl = "https://aqa5master.testrail.io/";
        String endpoint = "index.php?/api/v2/get_users";

        RestAssured.baseURI = baseUrl;

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Response response = httpRequest.request(Method.GET, endpoint);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Body: " + responseBody);

        Assert.assertEquals(statusCode, 200, "Invalid status code.");
    }
}
