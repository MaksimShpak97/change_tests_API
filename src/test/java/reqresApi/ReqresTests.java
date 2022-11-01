package reqresApi;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import reqresApi.model.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static reqresApi.specsifications.RequestSpecs.*;

@Owner("Shpak-ma")
@Story("API tests")
@Link("reqres.in")
public class ReqresTests {

    private String errorText = "Note: Only defined users succeed registration";

    @Test
    @DisplayName("Create users")
    void create() {
        UserData body = new UserData();
        body.setName("morpheus");
        body.setJob("leader");

        CreateResponse response = given()
                .when()
                .spec(requestSpecs)
                .body(body)
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .as(CreateResponse.class);

        assertThat(response.getJob()).isEqualTo("leader");
    }

    @Test
    @DisplayName("Changing jobs")
    void update() {
        UserData body = new UserData();
        body.setName("morpheus");
        body.setJob("zion resident");

        UpdateResponse response = given()
                .when()
                .spec(requestSpecs)
                .body(body)
                .put("/api/users/2")
                .then()
                .spec(responseSpecs)
                .extract().body().as(UpdateResponse.class);

        assertThat(response.getJob()).isEqualTo("zion resident");

    }

    @Test
    @DisplayName("Deleting a user")
    void deleteUser() {
        given()
                .when()
                .spec(requestSpecs)
                .delete("/api/users/2")
                .then()
                .log().all()
                .statusCode(204);

    }

    @Test
    @DisplayName("Checking that the image format .jpg")
    void checkingImageFormat() {
        List<AvatarData> users = given()
                .when()
                .spec(requestSpecs)
                .get("/api/users?page=2")
                .then()
                .spec(responseSpecs)
                .extract().body().jsonPath().getList("data", AvatarData.class);

        assertTrue(users.stream().allMatch(x -> x.getAvatar().endsWith(".jpg")));
    }

    @Test
    @DisplayName("Checking that the last name and first name match")
    void checkingUsersFirstAndLastName() {
        given()
                .when()
                .spec(requestSpecs)
                .get("/api/users/2")
                .then()
                .spec(responseSpecs)
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }

    @Test
    @DisplayName("Checking that the user is not found")
    void singleUserNotFound() {
        given()
                .when()
                .spec(requestSpecs)
                .get("/api/users/23")
                .then()
                .statusCode(404);

    }

    @Test
    @DisplayName("Checking that the token is not empty")
    void registerUser() {
        RegisterNotSuccessful body = new RegisterNotSuccessful();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");

        ResponseLoginSuccessful response = given()
                .when()
                .spec(requestSpecs)
                .body(body)
                .post("/api/register")
                .then()
                .spec(responseSpecs)
                .extract().body().as(ResponseLoginSuccessful.class);

        assertThat(response.getToken()).isNotNull();

    }

    @Test
    @DisplayName("Registration of a user with incorrect data")
    void registerUnSuccessfulUser() {
        RegisterNotSuccessful body = new RegisterNotSuccessful();
        body.setEmail("eve.holt@reqres.com"); // for the status code 200, change the URI
        body.setPassword("pistol");

        given()
                .when()
                .spec(requestSpecs)
                .body(body)
                .post("/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", is(errorText));

    }

}
