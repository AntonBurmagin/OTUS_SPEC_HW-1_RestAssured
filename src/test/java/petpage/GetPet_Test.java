package petpage;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import pages.PetPage;
import pet.PetCategory;
import pet.NewPet;
import pet.PetTag;
import java.util.List;


public class GetPet_Test {
  PetPage page = new PetPage();

  //Get запрос существующего животного.
  //Проверка ответа на соответствие схеме; соответствие данным созданного животного.
  @Test
  void getPetPositiveTest() {
    PetCategory petCategory = new PetCategory(717L, "cat");
    PetTag tag = new PetTag(17L, "#cinnamon bun");
    NewPet pet = NewPet.builder()
        .id(12358132134L)
        .category(petCategory)
        .name("Bruce")
        .status("softer than cloud")
        .tags(List.of(tag))
        .build();
    page.createNewPet(pet);

    ValidatableResponse getPetResponse = page.getPetById(12358132134L);
    page.getPetResponseShouldMatchSchema(getPetResponse);
    page.getPetResponseShouldBeEqualTo(getPetResponse, pet);
  }

  //Get запрос НЕсуществующего животного.
  //Проверка ответа на статус 404.
  @Test
  void getNonExistentPetTest() {
    page.deletePetById(12358132133L);
    ValidatableResponse nonExistentPetResponse = page.getPetById(12358132133L);
    page.getNonExistentPetShouldNotBeFound(nonExistentPetResponse);
  }

}
