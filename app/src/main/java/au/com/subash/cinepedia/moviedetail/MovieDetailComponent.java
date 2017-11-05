package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.di.components.ApplicationComponent;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, MovieDetailModule.class }
)
interface MovieDetailComponent {
  void inject(MovieDetailFragment movieDetailFragment);
}
