package au.com.subash.cinepedia;

import android.app.Application;
import au.com.subash.cinepedia.core.di.components.ApplicationComponent;
import au.com.subash.cinepedia.core.di.modules.ApplicationModule;
import au.com.subash.cinepedia.core.di.components.DaggerApplicationComponent;
// import com.squareup.leakcanary.LeakCanary;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
    this.initializeLeakDetection();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  private void initializeLeakDetection() {
    /**
    if (BuildConfig.DEBUG) {
      LeakCanary.install(this);
    }**/
  }
}
