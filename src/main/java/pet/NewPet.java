package pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
  private List<String> photoUrls = List.of();
  private String status;
  @Builder.Default
  private List<PetTag> tags = List.of();
}
