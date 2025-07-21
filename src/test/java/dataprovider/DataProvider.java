package dataprovider;

import org.junit.jupiter.params.provider.Arguments;
import user.NewUser;
import java.util.stream.Stream;


public class DataProvider {

  public static Stream<Arguments> provideNewUsers() {
    NewUser userNoEmail = NewUser.builder()
        .firstName("Anton")
        .lastName("Burmagin")
        .id(314L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .username("Anton_no_email")
        .build();
    NewUser userNoName = NewUser.builder()
        .email("antonio@gmail.com")
        .lastName("Burmagin")
        .id(315L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .username("Anton_no_firstName")
        .build();
    NewUser userNoLastName = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .id(316L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .username("Anton_no_lastName")
        .build();
    NewUser userNoId = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .username("Anton_no_id")
        .build();
    NewUser userNoPhone = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(318L)
        .userStatus(2L)
        .username("Anton_no_phone")
        .build();
    NewUser userNoStatus = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(319L)
        .phone("+7(953)933-63-53")
        .username("Anton_no_status")
        .build();

    return Stream.of(
        Arguments.of(userNoEmail),
        Arguments.of(userNoName),
        Arguments.of(userNoLastName),
        Arguments.of(userNoId),
        Arguments.of(userNoPhone),
        Arguments.of(userNoStatus)
    );
  }
}
