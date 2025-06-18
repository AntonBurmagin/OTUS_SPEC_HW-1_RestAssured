package userpage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.UserPage;
import user.NewUser;


public class CreateUser_Test {
  private UserPage page = new UserPage();


  //Создание пользователя с полной информацией.
  //Проверка формы ответа.
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


  //Параметризированный тест: создание пользователя с неполными данными.
  //Проверка схемы, времени отклика, данных пользователя.
  @ParameterizedTest
  @MethodSource("dataprovider.DataProvider#provideNewUsers")
  void createIncompleteUserTest(NewUser user){
    page.createUserResponseShouldMatchSchema(user);
  }



}
