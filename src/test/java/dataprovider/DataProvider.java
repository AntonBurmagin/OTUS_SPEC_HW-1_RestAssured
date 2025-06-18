package dataprovider;

import org.junit.jupiter.params.provider.Arguments;
import user.NewUser;
import java.util.stream.Stream;


public class DataProvider {

  public static Stream<Arguments> provideNewUsers() {
    NewUser userNoEmail = NewUser.builder()
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();
    NewUser userNoName = NewUser.builder()
        .email("antonio@gmail.com")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();
    NewUser userNoLastName = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .id(313L)
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();
    NewUser userNoId = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .phone("+7(953)933-63-53")
        .userStatus(2L)
        .build();
    NewUser userNoPhone = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .userStatus(2L)
        .build();
    NewUser userNoStatus = NewUser.builder()
        .email("antonio@gmail.com")
        .firstName("Anton")
        .lastName("Burmagin")
        .id(313L)
        .phone("+7(953)933-63-53")
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
