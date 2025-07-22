package pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.Collections;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NewPet {
  private PetCategory category;
  private Long id;
  private String name;
  @Builder.Default
  private List<String> photoUrls = Collections.unmodifiableList(List.of());
  private String status;
  @Builder.Default
  private List<PetTag> tags = List.of();


}
