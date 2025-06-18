package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import annotations.BasePath;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.hc.core5.http.HttpStatus;
import user.CreateUserResponse;
import user.NewUser;


@BasePath("/user")
public class UserPage extends AbsBasePage {
  String basePath = getBasePath();

  public ValidatableResponse createUser(NewUser user) {
    return api.post(basePath, user);
  }

  public void assertCreateUserResponseForm(NewUser user) {
    CreateUserResponse response = createUser(user).extract().as(CreateUserResponse.class);
    assertThat(response.getMessage()).isEqualTo(Long.toString(user.getId()));
    assertThat(response.getCode()).isEqualTo(200);
    assertThat(response.getType()).isEqualTo("unknown");
  }

  public void createUserResponseShouldMatchSchema(NewUser user) {
    createUser(user)
        .statusCode(HttpStatus.SC_OK)
        .time(lessThan(5000L))
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/createUserResponse.json"))
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo(Long.toString(user.getId())));
  }



}
