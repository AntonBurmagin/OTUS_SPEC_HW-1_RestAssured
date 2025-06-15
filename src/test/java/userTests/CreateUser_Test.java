package userTests;

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.PetStoreApi;
import user.NewUser;
import user.PostUserResponse;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class CreateUser_Test {
  private PetStoreApi api = new PetStoreApi();

  public static Stream<Arguments> dataprovider() {
    NewUser user1 = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();
    NewUser user2 = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .id(313L)
        .phone("+7(953)933-63-53")
        .build();

    return Stream.of(
      Arguments.of(user1),
      Arguments.of(user2)
    );
  }

  @Test
  void postUserTest(){
    NewUser user = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();

    api.createUser(user)
        .statusCode(HttpStatus.SC_OK)
//        .time(lessThan(2000L))
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/createUserResponse.json"))
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("313"));

    PostUserResponse userResponse = api.createUser(user).extract().body().as(PostUserResponse.class);
    String actualType = api.createUser(user).extract().body().jsonPath().get("type");
    Assertions.assertAll(
        () -> assertThat(userResponse.getMessage()).isEqualTo("313"),
        () -> assertThat(userResponse.getCode()).isEqualTo(200),
        () -> assertThat(userResponse.getType()).isEqualTo("unknown")
    );
    {
        System.out.println("Where are linters?");
    }

  }

//  @ParameterizedTest
//  @MethodSource("dataprovider")
//  void test(NewUser user){
//    api.createUser(user);
//  }


}
