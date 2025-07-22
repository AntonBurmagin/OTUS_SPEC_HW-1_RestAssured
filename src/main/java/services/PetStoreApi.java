package services;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import javax.annotation.concurrent.Immutable;
import java.lang.annotation.Annotation;


public class PetStoreApi implements Immutable {
  private RequestSpecification specification;

  public PetStoreApi() {
    specification = given()
        .baseUri(System.getProperty("base.url"))
        .contentType(ContentType.JSON);
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

  public <T> ValidatableResponse get(String basePath, String paramName,String pathParam) {
    String p = String.format("%s/{%s}", basePath, paramName);
    return given(specification)
        .basePath(p)
        .pathParam(paramName, pathParam)
        .log().all()
        .when()
        .get()
        .then()
        .log().all();
  }

  public <T> ValidatableResponse delete(String basePath, String paramName,String pathParam) {
    String p = String.format("%s/{%s}", basePath, paramName);
    return given(specification)
        .basePath(p)
        .pathParam(paramName, pathParam)
        .log().all()
        .when()
        .delete()
        .then()
        .log().all();
  }


  @Override
  public Class<? extends Annotation> annotationType() {
    return null;
  }
}
