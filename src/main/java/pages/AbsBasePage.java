package pages;

import annotations.BasePath;
import services.PetStoreApi;

public abstract class AbsBasePage {
  protected PetStoreApi api = null;
  
  public AbsBasePage(PetStoreApi api) {
    this.api = api;
  }

  protected String getBasePath() {
    Class cl = this.getClass();
    if (!cl.isAnnotationPresent(BasePath.class))
      throw new RuntimeException(String.format("%s doesn't have annotation BasePath", this.getClass()));
    BasePath declaredAnnotation = (BasePath) cl.getDeclaredAnnotation(BasePath.class);
    return declaredAnnotation.value();
  }
}
