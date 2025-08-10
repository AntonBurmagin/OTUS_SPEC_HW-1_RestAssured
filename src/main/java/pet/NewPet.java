package pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.Collections;
import java.util.List;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;



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
  @SuppressFBWarnings("EI_EXPOSE_REP2") // Suppress specific warning
  private List<String> photoUrls = Collections.unmodifiableList(List.of());
  private String status;


  @Builder.Default
  @SuppressFBWarnings("EI_EXPOSE_REP2") // Suppress specific warning
  private List<PetTag> tags = List.of();


}
