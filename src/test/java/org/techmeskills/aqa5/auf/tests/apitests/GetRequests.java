package org.techmeskills.aqa5.auf.tests.apitests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetRequests extends BaseApiTest {

    @Test
    public void getAllUsers() {
        // Указываем базовый URL
        //RestAssured.baseURI = properties.getURL();
        //RestAssured.baseURI = "https://reqres.in";

        // Указываем относительный путь к  ФЗШ
        //String endpoint = "/users?id=2";

        when().
                get("https://reqres.in/api/users?id={id}", 2).
        then()
            .statusCode(200);
    }
}
