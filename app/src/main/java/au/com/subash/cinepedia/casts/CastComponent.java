package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.di.components.ActivityComponent;
import au.com.subash.cinepedia.core.di.components.ApplicationComponent;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, CastModule.class }
)
public interface CastComponent extends ActivityComponent {
  void inject(CastScrollFragment castScrollFragment);
}
