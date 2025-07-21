package user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NewUser {
  private String email;
  private String firstName;
  @Builder.Default
  private Long id = 0L;
  private String lastName;
  private String password;
  private String phone;
  @Builder.Default
  private Long userStatus = 0L;
  private String username;

//  public Long getId() {
//    return (id == null ? 0L : id);
//  }
//
//  public Long getUserStatus() {
//    return (userStatus == null ? 0L : userStatus);
//  }
}
