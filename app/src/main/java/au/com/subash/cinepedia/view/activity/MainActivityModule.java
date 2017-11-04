package au.com.subash.cinepedia.view.activity;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.featuredshow.GetFeaturedShow;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.nowplayingmovies.GetNowPlayingMovies;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class MainActivityModule {

  @Provides @PerActivity @Named("getNowPlayingMovies") UseCase
  provideGetNowPlayingMovies(GetNowPlayingMovies getNowPlayingMovies) {
    return getNowPlayingMovies;
  }

  @Provides @PerActivity @Named("getFeaturedShow") UseCase
  provideGetFeaturedShowUseCase(GetFeaturedShow getFeaturedShowUseCase) {
    return getFeaturedShowUseCase;
  }
}
