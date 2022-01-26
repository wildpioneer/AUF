package org.techmeskills.aqa5.auf.apiTests;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.ProjectAPI;
import org.techmeskills.aqa5.auf.models.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiMainTest4 extends BaseApiTest {

    @Test
    public void getUser() {
        String endpoint = "index.php?/api/v2/get_user/1";
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
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getProject() {
        int projectID = 5;
        String endpoint = "/index.php?/api/v2/get_project/" + projectID;

        ProjectAPI projectAPIExpected = ProjectAPI.builder()
                .name("MainProject")
                .id(5)
                .show_announcement(false)
                .is_completed(false)
                .suite_mode(3)
                .url("https://qa1504.testrail.io/index.php?/projects/overview/2")
                .build();

        String response = given()
                .when()
                .get(endpoint).asString();

        Gson gson = new Gson();

        ProjectAPI projectAPI = gson.fromJson(response, ProjectAPI.class);
        System.out.println(response);

        Assert.assertEquals(projectAPI.toString(), projectAPIExpected.toString());
    }
}
