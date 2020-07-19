package org.techmeskills.aqa5.auf.apiTests;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiMainTest4 extends BaseApiTest {

    @Test
    public void getAllUsers() {
        String endpoint = "/index.php?/api/v2/get_users";
        User user = master;

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .body("get(0).is_active", is(user.isActive()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUser() {
        String endpoint = "index.php?/api/v2/get_user/2";
        User user = tester;

        given()
                .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("name", is(user.getName()))
                .body("email", equalTo(user.getEmail()))
                .body("is_active", is(user.isActive()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

}
