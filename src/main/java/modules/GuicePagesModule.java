package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import pages.PetPage;
import pages.UserPage;


public class GuicePagesModule extends AbstractModule {
  private WebDriver driver;

  public GuicePagesModule(WebDriver driver) {
    this.driver = driver;
  }

  @Provides
  public WebDriver getDriver() {
    return driver;
  }

  @Provides
  @Singleton
  public UserPage getMainPage(){
    return new UserPage();
  }

  @Provides
  @Singleton
  public PetPage getCatalogPage(){
    return new PetPage();
  }
}
