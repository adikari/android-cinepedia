package au.com.subash.cinepedia.view.activity;

import au.com.subash.cinepedia.comingsoonmovies.ComingSoonMoviesFragment;
import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.di.components.ActivityComponent;
import au.com.subash.cinepedia.core.di.components.ApplicationComponent;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import au.com.subash.cinepedia.nowplayingmovies.NowPlayingMoviesFragmentMovie;
import dagger.Component;

@PerActivity
@Component(
    dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, MainActivityModule.class }
)
public interface MainActivityComponent extends ActivityComponent {
  void inject(FeaturedShowFragment featuredShowFragment);
  void inject(NowPlayingMoviesFragmentMovie nowPlayingFragment);
  void inject(ComingSoonMoviesFragment comingSoonMoviesFragment);
}
