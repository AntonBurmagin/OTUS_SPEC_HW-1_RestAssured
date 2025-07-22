package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.PetPage;
import pages.UserPage;
import services.PetStoreApi;


public class GuicePagesModule extends AbstractModule {
  private final PetStoreApi api;

  public GuicePagesModule() {
    this.api = new PetStoreApi();
  }

  @Provides
  @Singleton
  public UserPage getMainPage(){
    return new UserPage(api);
  }

  @Provides
  @Singleton
  public PetPage getCatalogPage(){
    return new PetPage(api);
  }
}
