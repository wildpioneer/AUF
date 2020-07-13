package org.techmeskills.aqa5.auf.apiTests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.techmeskills.aqa5.auf.models.ProjectTypes;
import org.techmeskills.aqa5.auf.models.User;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiTest4 extends BaseApiTest {

    @Test
    public void getTest1() {
        String endpoint = "/index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest2() {
        String endpoint = "/index.php?/api/v2/get_users";

        User user = new User.Builder()
                .withName("AQA5 Master")
                .withEmail("atrostyanko+master@gmail.com")
                .withIsActive(true)
                .build();

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest3() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void postTest1() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project project = new Project.Builder()
                .withName("PR01")
                .withType(ProjectTypes.SINGLE_SUITE_MODE)
                .build();

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", project.getName(), project.getSuiteMode()))
        .when()
                .post(endpoint)
        .then()
                .log().body();
    }

    @Test
    public void postTest2() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project project = new Project.Builder()
                .withName("PR02")
                .withType(ProjectTypes.MULTIPLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getSuiteMode());

        given()
                .body(jsonAsMap)
        .when()
                .post(endpoint)
        .then()
                .log().body();
    }
}
