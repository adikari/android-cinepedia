package au.com.subash.cinepedia.movies.nowplaying;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.di.components.ActivityComponent;
import au.com.subash.cinepedia.core.di.components.ApplicationComponent;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, NowPlayingModule.class}
)
public interface NowPlayingComponent extends ActivityComponent {
  void inject(NowPlayingListFragment nowPlayingListFragment);
}
