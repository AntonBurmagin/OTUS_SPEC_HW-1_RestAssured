package pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.annotation.concurrent.Immutable;
import java.lang.annotation.Annotation;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PetCategory implements Immutable {
  private Long id;
  private String name;

  @Override
  public Class<? extends Annotation> annotationType() {
    return null;
  }
}
