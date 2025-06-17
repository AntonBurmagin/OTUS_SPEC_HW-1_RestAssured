package services;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import user.NewUser;

import static io.restassured.RestAssured.given;

public class PetStoreApi {
  private RequestSpecification specification;

  public PetStoreApi() {
    specification = given()
        .baseUri(System.getProperty("base.url"))
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createUser(NewUser user) {
    return given(specification)
        .basePath("/user")
        .body(user)
        .log().all()
        .when()
        .post()
        .then()
        .log().all();
  }

  public <T> ValidatableResponse post(String basePath, T bodyArg) {
    return given(specification)
        .basePath(basePath)
        .body(bodyArg)
        .log().all()
        .when()
        .post()
        .then()
        .log().all();
  }



}
