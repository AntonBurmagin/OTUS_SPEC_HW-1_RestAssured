package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuicePagesModule;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class UIExtension implements BeforeEachCallback {
  private Injector injector = null;

  @Override
  public void beforeEach(ExtensionContext context) {
    injector = Guice.createInjector(new GuicePagesModule());
    injector.injectMembers(context.getTestInstance().get());
  }

}
