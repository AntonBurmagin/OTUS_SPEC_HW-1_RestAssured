package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import annotations.BasePath;
import exceptions.UserNameNotFoundException;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.hc.core5.http.HttpStatus;
import user.CreateUserResponse;
import user.NewUser;


@BasePath("/user")
public class UserPage extends AbsBasePage {
  String basePath = getBasePath();

  public ValidatableResponse createUser(NewUser user) {
    if (user.getUsername() == null)
      throw new UserNameNotFoundException("Username field required for post user request: " + user);
    return api.post(basePath, user);
  }

  public ValidatableResponse getUserByUsername(String username){
    ValidatableResponse response = api.get(basePath, "username", username);
    try {
      response.extract().as(NewUser.class);
      return response;
    } catch (Exception e) {
      throw new RuntimeException("GetUser request results with Exception. Couldn't get user by username: " + username);
    }
  }

  public void getUserShouldBeEqualTo(ValidatableResponse getUser, NewUser created) {
    NewUser receivedUser = getUser.extract().as(NewUser.class);
    assertThat(receivedUser).isEqualTo(created);
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
