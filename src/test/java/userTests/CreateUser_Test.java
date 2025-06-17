package userTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.UserPage;
import user.NewUser;


public class CreateUser_Test {
  private UserPage page = new UserPage();


  //создание пользователя с полной информацией
  @Test
  void createUserPositiveTest(){
    NewUser user = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();

    page.assertCreateUserResponseForm(user);
  }


  //параметризированный тест: создание пользователя с неполными данными
  @ParameterizedTest
  @MethodSource("dataProvider.DataProvider#provideNewUsers")
  void createIncompleteUserTest(NewUser user){
    page.createUserResponseShouldMatchSchema(user);
  }



}
