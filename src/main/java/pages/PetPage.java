package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import annotations.BasePath;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.hc.core5.http.HttpStatus;
import pet.NewPet;
import services.PetStoreApi;


@BasePath("/pet")
public class PetPage extends AbsBasePage {
  String basePath = getBasePath();

  public PetPage(PetStoreApi api){
    super(api);
  }

  public ValidatableResponse getPetById(Long id){
    String pathParam = Long.toString(id);
    return api.get(basePath, "petId", pathParam);
  }

  public ValidatableResponse createNewPet(NewPet pet) {
    return api.post(basePath, pet);
  }

  public ValidatableResponse deletePetById(Long id){
    String pathParam = Long.toString(id);
    return api.delete(basePath, "petId", pathParam);
  }

  public void getPetResponseShouldMatchSchema(ValidatableResponse getPetResponse) {
    getPetResponse
        .statusCode(HttpStatus.SC_OK)
        .time(lessThan(5000L))
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getPetResponse.json"));
  }

  public void getPetResponseShouldBeEqualTo(ValidatableResponse getPetResponse, NewPet created) {
    NewPet receivedPet = getPetResponse.extract().as(NewPet.class);
    assertThat(receivedPet).isEqualTo(created);
  }

  public void getNonExistentPetShouldNotBeFound(ValidatableResponse getPetResponse) {
    getPetResponse
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .body("code", equalTo(1))
        .body("type", equalTo("error"))
        .body("message", equalTo("Pet not found"));
  }



}
